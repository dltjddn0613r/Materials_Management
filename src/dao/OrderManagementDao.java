package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import model.OrderManagement;

public class OrderManagementDao {

	public OrderManagement insert(Connection conn, OrderManagement orderManagement) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into orderManagement"
				+ "(OrderNumber, OrderName, OrderType)"
				+ "values(?, ?, ?)");
		pstmt.setString(1, orderManagement.getOrderNumber());
		pstmt.setString(2, orderManagement.getOrderName());
		pstmt.setString(3, orderManagement.getOrderType());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT OrderNumber FROM OrderManagement ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
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
}
