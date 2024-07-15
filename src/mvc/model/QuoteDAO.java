package mvc.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuoteDAO {
    private DataSource dataSource;

    public QuoteDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Quote> getQuotes() throws SQLException {
        List<Quote> quotes = new ArrayList<>();
        String sql = "SELECT * FROM Quotes";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Quote quote = new Quote(
                    rs.getInt("id"),
                    rs.getDate("date"),
                    rs.getString("number"),
                    rs.getString("clientName"),
                    rs.getString("managerName"),
                    rs.getString("itemName"),
                    rs.getDate("validityPeriod"),
                    rs.getDouble("totalAmount"),
                    rs.getString("status"),
                    rs.getString("createdVoucher")
                );
                quotes.add(quote);
            }
        }
        return quotes;
        }


    public List<Quote> searchQuotes(String searchQuery) {
        List<Quote> filteredList = new ArrayList<>();
        String sql = "SELECT * FROM Quotes WHERE clientName LIKE ? OR managerName LIKE ? OR itemName LIKE ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String likeQuery = "%" + searchQuery + "%";
            pstmt.setString(1, likeQuery);
            pstmt.setString(2, likeQuery);
            pstmt.setString(3, likeQuery);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	Quote quote = new Quote(
                		    rs.getInt("id"),
                		    rs.getDate("date"),
                		    rs.getString("number"),
                		    rs.getString("clientName"),
                		    rs.getString("managerName"),
                		    rs.getString("itemName"),
                		    rs.getDate("validityPeriod"),
                		    rs.getDouble("totalAmount"),
                		    rs.getString("status"),
                		    rs.getString("createdVoucher")
                		);
                    filteredList.add(quote);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 처리
        }
        return filteredList;
    }
}
