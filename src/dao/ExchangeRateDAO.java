package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import model.ExchangeRate;

public class ExchangeRateDAO {

	//새로운 통화 정보를 데이터베이스에 추가하는 메서드
	public ExchangeRate insert(Connection conn, ExchangeRate exchangeRate) throws SQLException{
		 PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        try {
	            pstmt = conn.prepareStatement(
	                "INSERT INTO ExchangeRate (ExchangeRateCode, ExchangeRateName, ExchangeRate) "
	                        + "VALUES (?, ?, ?)",
	                Statement.RETURN_GENERATED_KEYS);

	            pstmt.setString(1, exchangeRate.getExchangeRateCode());
	            pstmt.setString(2, exchangeRate.getExchangeRateName());
	            pstmt.setDouble(3, exchangeRate.getExchangeRate());

	            int insertedCount = pstmt.executeUpdate(); // SQL 문 실행 및 삽입된 행 수를 반환

	            if (insertedCount > 0) { // 삽입이 성공한 경우
	                rs = pstmt.getGeneratedKeys(); // 자동 생성된 키를 가져옵니다.
	                if (rs.next()) {
	                    // 생성된 키를 사용하여 ExchangeRateCode를 설정합니다.
	                	exchangeRate.setExchangeRateCode(rs.getString(1));
	                }
	                return exchangeRate; // 삽입된 ExchangeRate 객체 반환
	            }
	            return null; // 삽입 실패 시 null 반환
	        } finally {
	            JdbcUtil.close(rs);
	            JdbcUtil.close(pstmt);
	        }
	    }
	
	 // 데이터베이스에 저장된 총 통화 수를 반환하는 메서드
    public int selectCount(Connection conn) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) FROM ExchangeRate");
            if (rs.next()) {
                return rs.getInt(1); // 총 행 수 반환
            }
            return 0; // 행이 없을 경우 0 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }
    }
    
 // 페이지에 따라 통화 리스트를 가져오는 메서드
    public List<ExchangeRate> select(Connection conn, int firstRow, int endRow) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum as rnum, a.* FROM "
                    + "(SELECT * FROM ExchangeRate ORDER BY ExchangeRate DESC) a " + "WHERE rownum <= ?) WHERE rnum >= ?");
            pstmt.setInt(1, endRow); // 종료 행 번호 설정
            pstmt.setInt(2, firstRow); // 시작 행 번호 설정

            rs = pstmt.executeQuery(); // 쿼리 실행
            List<ExchangeRate> result = new ArrayList<>(); // 결과를 담을 리스트 생성
            while (rs.next()) {
                result.add(convertExchangeRate(rs)); // 각 행을 ExchangeRate 객체로 변환하여 리스트에 추가
            }
            return result; // 결과 리스트 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
    
    private ExchangeRate convertExchangeRate(ResultSet rs) throws SQLException {
        return new ExchangeRate(
            rs.getString("ExchangeRateCode"),
            rs.getString("ExchangeRateName"),
            rs.getDouble("ExchangeRate")
        );
    }
    
    //통화 코드로 특정 통화을 조회하는 메서드
    public ExchangeRate selectByCode(Connection conn, String exchangeRateCode) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM ExchangeRate WHERE ExchangeRateCode = ?");
            pstmt.setString(1, exchangeRateCode);

            rs = pstmt.executeQuery();
            ExchangeRate exchangeRate = null;
            if (rs.next()) {
            	exchangeRate = convertExchangeRate(rs); // 결과를 ExchangeRate 객체로 변환하여 반환
            }
            return exchangeRate; // 결과가 없으면 null 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
    
    public int searchCount(Connection conn, String searchQuery) throws SQLException {
        String sql = "SELECT COUNT(*) FROM ExchangeRate WHERE ExchangeRateName LIKE ? OR ExchangeRateCode LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%");
            pstmt.setString(2, "%" + searchQuery + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
                return 0;
            }
        }
    }
    
    public List<ExchangeRate> search(Connection conn, String searchQuery, int firstRow, int endRow) throws SQLException {
        String sql = "SELECT * FROM (SELECT rownum as rnum, a.* FROM (SELECT * FROM ExchangeRate WHERE ExchangeRateName LIKE ? OR ExchangeRateCode LIKE ? ORDER BY ExchangeRateCode DESC) a WHERE rownum <= ?) WHERE rnum >= ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%");
            pstmt.setString(2, "%" + searchQuery + "%");
            pstmt.setInt(3, endRow);
            pstmt.setInt(4, firstRow);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<ExchangeRate> result = new ArrayList<>();
                while (rs.next()) {
                    result.add(convertExchangeRate(rs));
                }
                return result;
            }
        }
    }
}
