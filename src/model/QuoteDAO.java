package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.connection.ConnectionProvider;

public class QuoteDAO {

	public List<Quote> getQuotes() throws SQLException {
        List<Quote> quotes = new ArrayList<>();
        String sql = "SELECT * FROM Quotes";

        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
        	
        	   System.out.println("Executing query: " + sql);  // 디버깅 메시지 추가
        	
            while (rs.next()) {
                Quote quote = new Quote();
                quote.setQuoteID(rs.getInt("QuoteID"));
                quote.setQuoteDate(rs.getDate("QuoteDate"));
                quote.setQuoteNumber(rs.getString("QuoteNumber"));
                quote.setCustomerCode(rs.getString("CustomerCode"));
                quote.setEmployeeCode(rs.getString("EmployeeCode"));
                quote.setProductCode(rs.getString("ProductCode"));
                quote.setValidityPeriod(rs.getDate("ValidityPeriod"));
                quote.setTotalAmount(rs.getDouble("TotalAmount"));
                quote.setStatus(rs.getString("Status"));
                quote.setCreatedVoucher(rs.getString("CreatedVoucher"));
                quotes.add(quote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return quotes;
    }

    public int insertQuote(Quote quote) throws SQLException {
        String sql = "INSERT INTO Quotes (QuoteDate, CustomerCode, EmployeeCode, ProductCode, ValidityPeriod, TotalAmount, Status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, quote.getQuoteDate());
            pstmt.setString(2, quote.getCustomerCode());
            pstmt.setString(3, quote.getEmployeeCode());
            pstmt.setString(4, quote.getProductCode());
            pstmt.setDate(5, quote.getValidityPeriod());
            pstmt.setDouble(6, quote.getTotalAmount());
            pstmt.setString(7, quote.getStatus());

            int result = pstmt.executeUpdate();
            System.out.println("삽입된 행 수: " + result);  // 디버깅 메시지 추가
            return result;
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
