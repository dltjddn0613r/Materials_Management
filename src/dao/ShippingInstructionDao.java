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
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from shippingInstruction ");
			if(rs.next()) {
				return rs.getInt(1); // 조회된 행 수 반환
			} 
			return 0; // 행이 없으면 0 반환 
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	public List<ShippingInstruction> select (Connection conn, int firstRow, int endRow) throws SQLException{
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum as rnum, a.* FROM" +"(SELECT * FROM shippingInstruction ORDER BY InstructionID DESC) a"+ "WHERE rownum <=?) WHERE rnum >=?");
			// SQL 쿼리에 데이터 바인딩
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);
			
			rs = pstmt.executeQuery();
			List<ShippingInstruction> result = new ArrayList<>();	
			while (rs.next()) {
				result.add(convertShippingInstruction(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		}
	}
	private ShippingInstruction convertShippingInstruction(ResultSet rs) throws SQLException{
		return new ShippingInstruction(rs.getString("InstructionID"),rs.getDate("InstructionDate"),rs.getString("ProductCode")
				,Integer.valueOf(rs.getInt("Quantity")), rs.getString("Status"));
	}
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	public ShippingInstruction selectById(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from shippingInstruction where InstructionID= ?");
			pstmt.setInt(1, no);
			
			// SQL 쿼리 실행
			rs = pstmt.executeQuery();
			ShippingInstruction shippingInstruction = null;
			if(rs.next()) {
				shippingInstruction = convertShippingInstruction(rs);
				
			}
			return shippingInstruction;
		}finally {
			// 자원해제
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
