package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import model.Warehouse;

public class WarehouseDao {

	public Warehouse insert(Connection conn, Warehouse warehouse) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into warehouse"
				+ "(WarehouseCode, WarehouseName, WarehouseCategory)"
				+ "values(?, ?, ?)");
		pstmt.setString(1, warehouse.getWarehouseCode());
		pstmt.setString(2, warehouse.getWarehouseName());
		pstmt.setString(3, warehouse.getWarehouseCategory());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT WarehouseCode FROM Warehouse ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
			if(rs.next()) {
				return new Warehouse(warehouse.getWarehouseCode(), 
									warehouse.getWarehouseName(),
									warehouse.getWarehouseCategory());
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
