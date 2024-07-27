package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.model.Article;
import article.model.Writer;
import jdbc.JdbcUtil;

public class ArticleDao {

    // Article 객체를 데이터베이스에 삽입하는 메서드
    public Article insert(Connection conn, Article article) throws SQLException {
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Article을 삽입하는 SQL 쿼리 준비
            pstmt = conn.prepareStatement(
                    "insert into article " + 
                    "(article_no, writer_id, writer_name, title, regdate, moddate, read_cnt) " +
                    "values (article_no_seq.nextval, ?, ?, ?, ?, ?, 0)");

            // SQL 쿼리에 데이터 바인딩
            pstmt.setString(1, article.getWriter().getId());
            pstmt.setString(2, article.getWriter().getName());
            pstmt.setString(3, article.getTitle());
            pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
            pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));

            // SQL 쿼리 실행 및 삽입된 행 수 반환
            int insertedCount = pstmt.executeUpdate();

            if (insertedCount > 0) {
                // 삽입된 Article의 ID를 조회하는 SQL 쿼리
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT article_no " + 
                                       "FROM (SELECT article_no " + 
                                       "      FROM article " +
                                       "      ORDER BY article_no DESC) " + 
                                       "WHERE ROWNUM = 1");

                // 삽입된 Article의 ID를 가져와 Article 객체 생성
                if (rs.next()) {
                    Integer newNo = rs.getInt(1);
                    return new Article(newNo, article.getWriter(), article.getTitle(), 
                                       article.getRegDate(), article.getModifiedDate(), 0);
                }
            }
            return null; // 삽입 실패 시 null 반환
        } finally {
            // 자원 해제
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
            JdbcUtil.close(pstmt);
        }
    }

    // Date 객체를 Timestamp 객체로 변환하는 메서드
    private Timestamp toTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    // Article 테이블의 전체 행 수를 조회하는 메서드
    public int selectCount(Connection conn) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 행 수를 조회하는 SQL 쿼리 실행
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select count(*) from article");
            if (rs.next()) {
                return rs.getInt(1); // 조회된 행 수 반환
            }
            return 0; // 행이 없으면 0 반환
        } finally {
            // 자원 해제
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }
    }

    // 특정 범위의 Article 목록을 조회하는 메서드
    public List<Article> select(Connection conn, int firstRow, int endRow) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 범위 내 Article을 조회하는 SQL 쿼리
            pstmt = conn.prepareStatement("select * from (select rownum as rnum, a.* from " +
                    "(select * from article order by article_no desc) a " +
                    "where rownum <= ?) where rnum >= ?");

            // SQL 쿼리에 데이터 바인딩
            pstmt.setInt(1, endRow);
            pstmt.setInt(2, firstRow);

            // SQL 쿼리 실행
            rs = pstmt.executeQuery();
            List<Article> result = new ArrayList<>();
            while (rs.next()) {
                result.add(convertArticle(rs)); // ResultSet을 Article 객체로 변환하여 리스트에 추가
            }
            return result; // Article 리스트 반환
        } finally {
            // 자원 해제
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    // ResultSet에서 Article 객체로 변환하는 메서드
    private Article convertArticle(ResultSet rs) throws SQLException {
        return new Article(rs.getInt("article_no"), 
                           new Writer(rs.getString("writer_id"), rs.getString("writer_name")),
                           rs.getString("title"), 
                           toDate(rs.getTimestamp("regdate")), 
                           toDate(rs.getTimestamp("moddate")),
                           rs.getInt("read_cnt"));
    }

    // Timestamp 객체를 Date 객체로 변환하는 메서드
    private Date toDate(Timestamp timestamp) {
        return new Date(timestamp.getTime());
    }

    // 특정 ID를 가진 Article을 조회하는 메서드
    public Article selectById(Connection conn, int no) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Article을 조회하는 SQL 쿼리
            pstmt = conn.prepareStatement("select * from article where article_no = ?");
            pstmt.setInt(1, no);

            // SQL 쿼리 실행
            rs = pstmt.executeQuery();
            Article article = null;
            if (rs.next()) {
                article = convertArticle(rs); // 조회된 Article을 변환
            }
            return article; // Article 반환
        } finally {
            // 자원 해제
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    // Article의 조회 수를 증가시키는 메서드
    public void increaseReadCount(Connection conn, int no) throws SQLException {
        try (PreparedStatement pstmt = conn
                .prepareStatement("update article set read_cnt = read_cnt + 1 where article_no = ?")) {
            pstmt.setInt(1, no); // Article ID 바인딩
            pstmt.executeUpdate(); // SQL 쿼리 실행
        }
    }

    // Article의 제목을 업데이트하는 메서드
    public int update(Connection conn, int no, String title) throws SQLException {
        try (PreparedStatement pstmt = conn
                .prepareStatement("UPDATE article SET title = ?, moddate = SYSDATE WHERE article_no = ?")) {
            pstmt.setString(1, title); // 제목 바인딩
            pstmt.setInt(2, no); // Article ID 바인딩
            return pstmt.executeUpdate(); // SQL 쿼리 실행 후 업데이트된 행 수 반환
        }
    }

    // 특정 ID를 가진 Article을 삭제하는 메서드
    public int delete(Connection conn, int articleNo) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("delete from article where article_no = ?")) {
            pstmt.setInt(1, articleNo); // Article ID 바인딩
            return pstmt.executeUpdate(); // SQL 쿼리 실행 후 삭제된 행 수 반환
        }
    }
}
