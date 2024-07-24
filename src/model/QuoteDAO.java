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
                quote.setQuoteID(rs.getString("QuoteID"));
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
	        String sqlQuote = "INSERT INTO Quotes (QuoteDate, QuoteNumber, CustomerCode, EmployeeCode, ProductCode, ValidityPeriod, TotalAmount, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        String sqlCustomer = "INSERT INTO Customers (CustomerCode, CustomerName) SELECT ?, ? FROM dual WHERE NOT EXISTS (SELECT 1 FROM Customers WHERE CustomerCode = ?)";
	        String sqlEmployee = "INSERT INTO Employees (EmployeeCode, EmployeeName) SELECT ?, ? FROM dual WHERE NOT EXISTS (SELECT 1 FROM Employees WHERE EmployeeCode = ?)";
	        String sqlProduct = "INSERT INTO Products (ProductCode, ProductName, Price) SELECT ?, ?, ? FROM dual WHERE NOT EXISTS (SELECT 1 FROM Products WHERE ProductCode = ?)";

	        try (Connection conn = ConnectionProvider.getConnection()) {
	            conn.setAutoCommit(false);
	            try (PreparedStatement pstmtQuote = conn.prepareStatement(sqlQuote);
	                 PreparedStatement pstmtCustomer = conn.prepareStatement(sqlCustomer);
	                 PreparedStatement pstmtEmployee = conn.prepareStatement(sqlEmployee);
	                 PreparedStatement pstmtProduct = conn.prepareStatement(sqlProduct)) {

	                // Insert Quote
	                pstmtQuote.setDate(1, quote.getQuoteDate());
	                pstmtQuote.setString(2, quote.getQuoteNumber());
	                pstmtQuote.setString(3, quote.getCustomerCode());
	                pstmtQuote.setString(4, quote.getEmployeeCode());
	                pstmtQuote.setString(5, quote.getProductCode());
	                pstmtQuote.setDate(6, quote.getValidityPeriod());
	                pstmtQuote.setDouble(7, quote.getTotalAmount());
	                pstmtQuote.setString(8, quote.getStatus());
	                pstmtQuote.executeUpdate();

	                // Insert Customer if not exists
	                pstmtCustomer.setString(1, quote.getCustomerCode());
	                pstmtCustomer.setString(2, "New Customer");
	                pstmtCustomer.setString(3, quote.getCustomerCode());
	                pstmtCustomer.executeUpdate();

	                // Insert Employee if not exists
	                pstmtEmployee.setString(1, quote.getEmployeeCode());
	                pstmtEmployee.setString(2, "New Employee");
	                pstmtEmployee.setString(3, quote.getEmployeeCode());
	                pstmtEmployee.executeUpdate();

	                // Insert Product if not exists
	                pstmtProduct.setString(1, quote.getProductCode());
	                pstmtProduct.setString(2, "New Product");
	                pstmtProduct.setDouble(3, 0.0);
	                pstmtProduct.setString(4, quote.getProductCode());
	                pstmtProduct.executeUpdate();

	                conn.commit();
	                return 1;
	            } catch (SQLException e) {
	                conn.rollback();
	                e.printStackTrace();
	                throw e;
	            }
	        }
	    }
	}