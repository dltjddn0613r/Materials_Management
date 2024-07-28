package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import jdbc.JdbcUtil;
import model.Shipment;

public class ShipmentDao {

	public Shipment insert(Connection conn, Shipment shipment) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into shipment"
				+ "(ShipmentID, ShipmentDate, ProductCode, Quantity, Status)"
				+ "values(?, ?, ?, ?, ?)");
		pstmt.setString(1, shipment.getShipmentID());
		pstmt.setTimestamp(2, toTimestamp(shipment.getShipmentDate()));
		pstmt.setString(3, shipment.getProductCode());
		pstmt.setInt(4, shipment.getQuantity());
		pstmt.setString(5, shipment.getStatus());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT ShipmentID FROM Shipment ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
			if(rs.next()) {
				return new Shipment(shipment.getShipmentID(), 
									shipment.getShipmentDate(),
									shipment.getProductCode(),
									shipment.getQuantity(),
									shipment.getStatus());
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
