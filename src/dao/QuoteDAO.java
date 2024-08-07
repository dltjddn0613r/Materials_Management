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

public class QuoteDAO {

	public Quote insert(Connection conn, Quote quote) throws SQLException {
		PreparedStatement pstmt = null; // SQL 문을 실행하기 위한 PreparedStatement와 결과를 가져오기 위한 ResultSet 선언
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO Quote (Quote_no, QuoteDate, CustomerCode, EmployeeCode, ProductCode, ValidityPeriod, TotalAmount, Status, CreatedVoucher, WarehouseCode, TransactionTypeCode, ExchangeRateCode, ProjectCode) " +
	                         "VALUES (quote_no_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		
			  pstmt.setTimestamp(1, new Timestamp(quote.getQuoteDate().getTime()));
	            pstmt.setString(2, quote.getCustomerCode());
	            pstmt.setString(3, quote.getEmployeeCode());
	            pstmt.setString(4, quote.getProductCode());
	            pstmt.setTimestamp(5, new Timestamp(quote.getValidityPeriod().getTime()));
	            pstmt.setDouble(6, quote.getTotalAmount());
	            pstmt.setString(7, quote.getStatus());
	            pstmt.setString(8, quote.getCreatedVoucher());
	            pstmt.setString(9, quote.getWarehouseCode());
	            pstmt.setString(10, quote.getTransactionTypeCode());
	            pstmt.setString(11, quote.getExchangeRateCode());
	            pstmt.setString(12, quote.getProjectCode());

			int insertedCount = pstmt.executeUpdate(); // SQL 문 실행 및 삽입된 행 수를 반환

			if (insertedCount > 0) { // 삽입이 성공한 경우
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT quote_no_seq.CURRVAL FROM DUAL");// 시퀀스를 사용하여 생성된 견적 번호를 가져옴
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Quote(newNo, quote.getQuoteDate(), quote.getCustomerCode(), quote.getEmployeeCode(),
                            quote.getProductCode(), quote.getValidityPeriod(), quote.getTotalAmount(), 
                            quote.getStatus(), quote.getCreatedVoucher(), quote.getWarehouseCode(),
                            quote.getTransactionTypeCode(), quote.getExchangeRateCode(), quote.getProjectCode());
       }
			}
			return null;// 삽입 실패 시 null 반환
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {// 자원해제
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	public int selectCount(Connection conn) throws SQLException {// 데이터베이스에 저장된 총 견적 수
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from quote");
			if (rs.next()) {
				return rs.getInt(1);// 총 행 수 반환
			}
			return 0;// 행이 없을 경우 0 반환
		} finally {// 자원 해제
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
			pstmt.setInt(1, endRow); // 종료 행 번호 설정
			pstmt.setInt(2, firstRow); // 시작 행 번호 설정

			rs = pstmt.executeQuery();// 쿼리 실행
			List<Quote> result = new ArrayList<>(); // 결과를 담을 리스트 생성
			while (rs.next()) {
				result.add(convertQuote(rs));// 각 행을 Quote 객체로 변환하여 리스트에 추가
			}
			return result;// 결과 리스트 반환
		} finally {// 자원 해제
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	 private Quote convertQuote(ResultSet rs) throws SQLException {
	        return new Quote(
	            rs.getInt("Quote_no"), 
	            rs.getTimestamp("QuoteDate"), 
	            rs.getString("CustomerCode"), 
	            rs.getString("EmployeeCode"), 
	            rs.getString("ProductCode"), 
	            rs.getTimestamp("ValidityPeriod"), 
	            rs.getDouble("TotalAmount"), 
	            rs.getString("Status"), 
	            rs.getString("CreatedVoucher"), 
	            rs.getString("WarehouseCode"), 
	            rs.getString("TransactionTypeCode"), 
	            rs.getString("ExchangeRateCode"), 
	            rs.getString("ProjectCode")
	        );
	    }


	public Quote selectById(Connection conn, int no) throws SQLException {// 주어진 견적 번호로 견적을 선택하여 반환합니다.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from quote where quote_no = ?");
			pstmt.setInt(1, no); // 견적 번호 설정

			rs = pstmt.executeQuery(); // 쿼리 실행
			Quote quote = null;
			if (rs.next()) {
				quote = convertQuote(rs); // 결과를 Quote 객체로 변환
			}
			return quote; // Quote 객체 반환
		} finally {// 자원 해제
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// 주어진 견적 번호의 견적을 업데이트합니다.
	public int update(Connection conn, int no, Date quoteDate, String customerCode, String employeeCode,
            String productCode, Date validityPeriod, double totalAmount, String status, 
            String createdVoucher, String warehouseCode, String transactionTypeCode, 
            String exchangeRateCode, String projectCode)
			throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"UPDATE Quote SET QuoteDate = ?, CustomerCode = ?, EmployeeCode = ?, ProductCode = ?, " +
	                     "ValidityPeriod = ?, TotalAmount = ?, Status = ?, CreatedVoucher = ?, " +
	                     "WarehouseCode = ?, TransactionTypeCode = ?, ExchangeRateCode = ?, ProjectCode = ? " +
	                     "WHERE Quote_no = ?")) {
			 pstmt.setTimestamp(1, new Timestamp(quoteDate.getTime()));
	            pstmt.setString(2, customerCode);
	            pstmt.setString(3, employeeCode);
	            pstmt.setString(4, productCode);
	            pstmt.setTimestamp(5, new Timestamp(validityPeriod.getTime()));
	            pstmt.setDouble(6, totalAmount);
	            pstmt.setString(7, status);
	            pstmt.setString(8, createdVoucher);
	            pstmt.setString(9, warehouseCode);
	            pstmt.setString(10, transactionTypeCode);
	            pstmt.setString(11, exchangeRateCode);
	            pstmt.setString(12, projectCode);
	            pstmt.setInt(13, no);
			return pstmt.executeUpdate();
		}
	}

	public int delete(Connection conn, int quoteNo) throws SQLException {// 주어진 견적 번호의 견적을 삭제합니다.
		try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM quote WHERE quote_no = ?")) {
			pstmt.setInt(1, quoteNo);// 견적 번호 설정
			return pstmt.executeUpdate();// SQL 문 실행 및 삭제된 행 수 반환
		}
	}

	// 검색어에 따른 전체 검색 결과 수를 가져오는 메서드
	public int searchCount(Connection conn, String searchQuery) throws SQLException {
		String sql = "SELECT COUNT(*) FROM quote WHERE employeeCode LIKE ? OR customerCode LIKE ?";
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

	 // 검색어와 페이지 정보를 기반으로 검색 결과를 가져오는 메서드
    public List<Quote> search(Connection conn, String searchQuery, int firstRow, int endRow) throws SQLException {
        String sql = "SELECT * FROM (SELECT rownum as rnum, a.* FROM (SELECT * FROM Quote WHERE CustomerCode LIKE ? OR EmployeeCode LIKE ? ORDER BY Quote_no DESC) a WHERE rownum <= ?) WHERE rnum >= ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%");
            pstmt.setString(2, "%" + searchQuery + "%");
            pstmt.setInt(3, endRow);
            pstmt.setInt(4, firstRow);

			try (ResultSet rs = pstmt.executeQuery()) {
				List<Quote> result = new ArrayList<>();
				while (rs.next()) {
					result.add(convertQuote(rs));
				}
				return result;
			}
		}
	}

 // 상세 검색에 대한 총 결과 수를 가져오는 메서드
    public int detailSearchCount(Connection conn, String startDate, String endDate, String customerName,
                                 String employeeName, String productName, String validityPeriod, 
                                 String minTotalAmount, String maxTotalAmount) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Quote WHERE " +
                     "QuoteDate BETWEEN ? AND ? " +
                     "AND CustomerCode LIKE ? " +
                     "AND EmployeeCode LIKE ? " +
                     "AND ProductCode LIKE ? " +
                     "AND ValidityPeriod = ? " +
                     "AND TotalAmount BETWEEN ? AND ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, startDate);
            pstmt.setString(2, endDate);
            pstmt.setString(3, "%" + customerName + "%");
            pstmt.setString(4, "%" + employeeName + "%");
            pstmt.setString(5, "%" + productName + "%");
            pstmt.setString(6, validityPeriod);
            pstmt.setString(7, minTotalAmount);
            pstmt.setString(8, maxTotalAmount);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
                return 0;
            }
        }
    }

    // 상세 검색에 대한 결과를 가져오는 메서드
    public List<Quote> detailSearch(Connection conn, String startDate, String endDate, String customerName,
                                    String employeeName, String productName, String validityPeriod, 
                                    String minTotalAmount, String maxTotalAmount) throws SQLException {
        String sql = "SELECT * FROM Quote WHERE " +
                     "QuoteDate BETWEEN ? AND ? " +
                     "AND CustomerCode LIKE ? " +
                     "AND EmployeeCode LIKE ? " +
                     "AND ProductCode LIKE ? " +
                     "AND ValidityPeriod = ? " +
                     "AND TotalAmount BETWEEN ? AND ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, startDate);
            pstmt.setString(2, endDate);
            pstmt.setString(3, "%" + customerName + "%");
            pstmt.setString(4, "%" + employeeName + "%");
            pstmt.setString(5, "%" + productName + "%");
            pstmt.setString(6, validityPeriod);
            pstmt.setString(7, minTotalAmount);
            pstmt.setString(8, maxTotalAmount);

            try (ResultSet rs = pstmt.executeQuery()) {
                List<Quote> result = new ArrayList<>();
                while (rs.next()) {
                    result.add(convertQuote(rs));
                }
                return result;
            }
        }
    }
}