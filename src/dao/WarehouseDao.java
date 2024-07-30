package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from warehouse");
			if(rs.next()) {
				return rs.getInt(1); // 조회된 행 수 반환
			}
			return 0; // 행이 없으면 0 반환
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			
		}
	}
	public List<Warehouse> select(Connection conn, int firstRow, int endRow) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum as rnum, a.* FROM "
					+ "(SELECT * FROM warehouse ORDER BY WarehouseCode DESC) a " + "WHERE rownum <= ?) WHERE rnum >= ?");
		// SQL 쿼리에 데이터 바인딩
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			List<Warehouse> result = new ArrayList<Warehouse>();
			while (rs.next()) {
				result.add(convertWarehouse(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	private Warehouse convertWarehouse(ResultSet rs) throws SQLException{
		return new Warehouse(rs.getString("WarehouseCode"),rs.getString("WarehouseName"),rs.getString("WarehouseCategory"));
	}
	private Date todaDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	public Warehouse selectById(Connection conn, int no) throws SQLException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        pstmt = conn.prepareStatement("SELECT * FROM warehouse WHERE WarehouseCode = ?");
	        pstmt.setInt(1, no);

	        // SQL 쿼리 실행
	        rs = pstmt.executeQuery();
	        Warehouse warehouse = null;
	        if (rs.next()) {
	            warehouse = convertWarehouse(rs);
	        }
	        return warehouse;
	    } finally {
	        // 자원 해제
	        JdbcUtil.close(rs);
	        JdbcUtil.close(pstmt);
	    }
	}
}
