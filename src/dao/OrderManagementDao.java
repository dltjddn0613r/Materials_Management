package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import model.OrderManagement;

public class OrderManagementDao {

	public OrderManagement insert(Connection conn, OrderManagement orderManagement) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into orderManagement"
				+ "(orderNumber, orderName, orderType)"
				+ "values(?, ?, ?)");
		pstmt.setString(1, orderManagement.getOrderNumber());
		pstmt.setString(2, orderManagement.getOrderName());
		pstmt.setString(3, orderManagement.getOrderType());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT orderNumber FROM OrderManagement ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
			if(rs.next()) {
				return new OrderManagement(orderManagement.getOrderNumber(), 
											orderManagement.getOrderName(),
											orderManagement.getOrderType());
			}
		}
		return null;
	} finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(pstmt);
	}
	}
	 public OrderManagement selectById(Connection conn, String orderNumber) throws SQLException {
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
	            pstmt = conn.prepareStatement("SELECT * FROM OrderManagement WHERE orderNumber = ?");
	            pstmt.setString(1, orderNumber);

	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return convertOrderManagement(rs);
	            }
	            return null;
	        } finally {
	            JdbcUtil.close(rs);
	            JdbcUtil.close(pstmt);
	        }
}
	private OrderManagement convertOrderManagement(ResultSet rs) throws SQLException{
		return new OrderManagement(
				rs.getString("orderNumber"),
				rs.getString("orderName"),
				rs.getString("orderType"));
	}
	public List<OrderManagement> select(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM (SELECT rownum AS rnum, a.* FROM (SELECT * FROM OrderManagement ORDER BY orderNumber DESC) a WHERE rownum <= ?) WHERE rnum >= ?");
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);

			rs = pstmt.executeQuery();
			List<OrderManagement> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertOrderManagement(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}