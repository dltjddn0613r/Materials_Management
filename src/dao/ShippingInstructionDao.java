package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import jdbc.JdbcUtil;
import model.ShippingInstruction;

public class ShippingInstructionDao {

	public ShippingInstruction insert(Connection conn, ShippingInstruction shippingInstruction) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into shippingInstruction"
				+ "(InstructionID, InstructionDate, ProductCode, Quantity, Status)"
				+ "values(?, ?, ?, ?, ?)");
		pstmt.setString(1, shippingInstruction.getInstructionID());
		pstmt.setTimestamp(2, toTimestamp(shippingInstruction.getInstructionDate()));
		pstmt.setString(3, shippingInstruction.getProductCode());
		pstmt.setInt(4, shippingInstruction.getQuantity());
		pstmt.setString(5, shippingInstruction.getStatus());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT InstructionID FROM ShippingInstruction ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
			if(rs.next()) {
				return new ShippingInstruction(shippingInstruction.getInstructionID(), 
												shippingInstruction.getInstructionDate(),
												shippingInstruction.getProductCode(),
												shippingInstruction.getQuantity(),
												shippingInstruction.getStatus());
			}
		}
		return null;
	} finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(pstmt);
	}
	}

	private Timestamp toTimestamp(java.util.Date date) {
		return new Timestamp(date.getTime());
	}
}
