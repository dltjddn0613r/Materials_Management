package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import model.Quote;

public class QuoteDao {

    public Quote insert(Connection conn, Quote quote) throws SQLException {
    	PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(
                "INSERT INTO Quote (QUOTE_NO, QuoteID, QuoteDate, QuoteNumber, CustomerCode, EmployeeCode, ProductCode, ValidityPeriod, TotalAmount, Status,CreatedVoucher) "
                + "VALUES (quote_no_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, quote.getQuoteID());
            pstmt.setTimestamp(2, toTimestamp(quote.getQuoteDate()));
            pstmt.setString(3, quote.getQuoteNumber());
            pstmt.setString(4, quote.getCustomerCode());
            pstmt.setString(5, quote.getEmployeeCode());
            pstmt.setString(6, quote.getProductCode());
            pstmt.setTimestamp(7, toTimestamp(quote.getValidityPeriod()));
            pstmt.setDouble(8, quote.getTotalAmount());
            pstmt.setString(9, quote.getStatus());
            pstmt.setString(10, quote.getCreatedVoucher());
            
            int insertedCount = pstmt.executeUpdate();

            if (insertedCount > 0) {
            	stmt =conn.createStatement();//아래 쿼리문은 가장 최근에 추가된 견적서 번호를 알고 싶다는 뜻
                rs =stmt.executeQuery("SELECT quote_no FROM (SELECT quote_no FROM Quote ORDER BY quote_no DESC) WHERE ROWNUM = 1;");
                //SELECT quote_no FROM Quote WHERE ROWNUM = 1 ORDER BY quote_no DESC; 이것도 가능할듯?
                if(rs.next()) {
                	Integer newNo = rs.getInt(1);
                	return new Quote(newNo, quote.getQuoteID(), quote.getQuoteDate(), quote.getQuoteNumber(), 
                            quote.getCustomerCode(), quote.getEmployeeCode(), quote.getProductCode(), 
                            quote.getValidityPeriod(), quote.getTotalAmount(), quote.getStatus(), quote.getCreatedVoucher());
                }
            }
            return null;
        }catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 로그를 남길 수 있습니다.
            throw e;
        } finally {
        	JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
            JdbcUtil.close(pstmt);
        }
    }

    private Timestamp toTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from quote");
			if (rs.next()) {
				return rs.getInt(1); // 조회된 행 수 반환
			}
			return 0; // 행이 없으면 0 반환
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Quote> select(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum as rnum, a.* FROM "
					+ "(SELECT * FROM quote ORDER BY quote_no DESC) a " + "WHERE rownum <= ?) WHERE rnum >= ?");
			// SQL 쿼리에 데이터 바인딩
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);
			
			rs = pstmt.executeQuery();
			List<Quote> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertQuote(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	 private Quote convertQuote(ResultSet rs) throws SQLException {
	        return new Quote(rs.getInt("quote_no"), rs.getString("QuoteID"), rs.getDate("QuoteDate"),
	                rs.getString("QuoteNumber"), rs.getString("CustomerCode"), rs.getString("EmployeeCode"),
	                rs.getString("ProductCode"), rs.getDate("ValidityPeriod"), rs.getDouble("TotalAmount"),
	                rs.getString("Status"), rs.getString("CreatedVoucher"));
	    }

	 private Date toDate(Timestamp timestamp) {
	        return new Date(timestamp.getTime());
	    }
	   
	public Quote selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from quote where quote_no = ?");
			pstmt.setInt(1, no);

			// SQL 쿼리 실행
			rs = pstmt.executeQuery();
			Quote quote = null;
			if (rs.next()) {
				quote = convertQuote(rs);
			}
			return quote;
		} finally {
			// 자원 해제
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
}