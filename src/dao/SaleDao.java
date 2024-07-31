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
import model.Sale;

public class SaleDao {

    // Sale 객체 삽입 메서드
    public Sale insert(Connection conn, Sale sale) throws SQLException {
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(
                "INSERT INTO Sale (SaleID, SaleDate, ProductCode, Quantity, TotalAmount, PaymentStatusID) "
                + "VALUES (?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, sale.getSaleID());
            pstmt.setTimestamp(2, toTimestamp(sale.getSaleDate()));
            pstmt.setString(3, sale.getProductCode());
            pstmt.setInt(4, sale.getQuantity());
            pstmt.setDouble(5, sale.getTotalAmount());
            pstmt.setString(6, sale.getPaymentStatusID());

            int insertedCount = pstmt.executeUpdate();

            if (insertedCount > 0) {
            	stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT SaleID FROM (SELECT SaleID FROM Sale ORDER BY SaleID DESC) WHERE ROWNUM = 1;");
                if(rs.next()) {
                	return new Sale(sale.getSaleID(),sale.getSaleDate(),sale.getProductCode(),sale.getQuantity(),sale.getTotalAmount(),sale.getPaymentStatusID());
                } 
            }
            return null;
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
			rs = stmt.executeQuery("select count(*) from sale");
			if (rs.next()) {
				return rs.getInt(1); // 조회된 행 수 반환
			}
			return 0; // 행이 없으면 0 반환
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}   

    public List<Sale> select(Connection conn, int firstRow, int endRow) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
          
            pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum AS rnum, a.* FROM (SELECT * FROM Sale ORDER BY SaleDate DESC) a WHERE rownum <= ?) WHERE rnum >= ?");
            pstmt.setInt(1, endRow);
            pstmt.setInt(2, firstRow);

            rs = pstmt.executeQuery();
            List<Sale> result = new ArrayList<>();
            while (rs.next()) {
            	result.add(convertSale(rs));
            }
            return result;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
    private Sale convertSale(ResultSet rs) throws SQLException {
        return new Sale(
            rs.getString("SaleID"),
            rs.getTimestamp("SaleDate"),
            rs.getString("ProductCode"),
            rs.getInt("Quantity"),
            rs.getDouble("TotalAmount"),
            rs.getString("PaymentStatusID")
        );
    }

	 private Date toDate(Timestamp timestamp) {
	        return new Date(timestamp.getTime());
	 }
    // Sale 객체 조회 메서드 (ID 기준)
    public Sale selectById(Connection conn, String saleID) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Sale WHERE SaleID = ?");
            pstmt.setString(1, saleID);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                return convertSale(rs);
            }
            return null;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
