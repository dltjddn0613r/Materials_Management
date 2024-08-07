package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.QuoteDAO;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import model.Quote;

public class QuoteDeleteService {

    private QuoteDAO quoteDao = new QuoteDAO();// QuoteDAO 인스턴스 생성

    public void deleteQuotes(List<Integer> quote_nos) {//주어진 견적 번호 리스트를 사용하여 견적을 삭제합니다.
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();  // 데이터베이스 연결 가져오기
            conn.setAutoCommit(false); 

            for (int quote_no : quote_nos) {   // 리스트에 포함된 각 견적 번호에 대해 반복
                Quote quote = quoteDao.selectById(conn, quote_no);// 주어진 ID로 견적 찾기
                if (quote == null) {
                    throw new QuoteNotFoundException("견적서를 찾을 수 없습니다: " + quote_no);
                }
                quoteDao.delete(conn, quote_no); // 삭제 작업 수행
            }

            conn.commit(); // 모든 삭제 작업이 성공하면 커밋
        } catch (SQLException e) {
            JdbcUtil.rollback(conn); // 예외 발생 시 롤백
            throw new RuntimeException("삭제 중 오류가 발생했습니다.", e);
        } finally {
            JdbcUtil.close(conn);   // 데이터베이스 연결 해제
        }
    }
}
