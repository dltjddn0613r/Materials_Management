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
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from Shipment");
			if (rs.next()) {
				return rs.getInt(1); // 조회된 행 수 반환
			}
			return 0; // 행이 없으면 0 반환
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}   

    public List<Shipment> select(Connection conn, int firstRow, int endRow) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
          
            pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum AS rnum, a.* FROM (SELECT * FROM Shipment ORDER BY ShipmentID DESC) a WHERE rownum <= ?) WHERE rnum >= ?");
            pstmt.setInt(1, endRow);
            pstmt.setInt(2, firstRow);

            rs = pstmt.executeQuery();
            List<Shipment> result = new ArrayList<>();
            while (rs.next()) {
            	result.add(convertShipment(rs));
            }
            return result;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
    private Shipment convertShipment(ResultSet rs) throws SQLException {
        return new Shipment(
            rs.getString("ShipmentID"),
            rs.getTimestamp("ShipmentDate"),
            rs.getString("ProductCode"),
            rs.getInt("Quantity"),
            rs.getString("Status")
        );
    }

	 private Date toDate(Timestamp timestamp) {
	        return new Date(timestamp.getTime());
	 }
    // Shipment 객체 조회 메서드 (ID 기준)
    public Shipment selectById(Connection conn, String ShipmentID) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Shipment WHERE ShipmentID = ?");
            pstmt.setString(1, ShipmentID);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                return convertShipment(rs);
            }
            return null;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
