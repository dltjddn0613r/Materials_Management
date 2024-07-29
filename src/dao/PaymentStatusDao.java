package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import model.PaymentStatus;

public class PaymentStatusDao {

	public PaymentStatus insert(Connection conn, PaymentStatus paymentStatus) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into paymentStatus"
				+ "(StatusID, StatusDescription)"
				+ "values(?, ?)");
		pstmt.setString(1, paymentStatus.getStatusID());
		pstmt.setString(2, paymentStatus.getStatusDescription());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT StatusID FROM PaymentStatus ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
			if(rs.next()) {
				return new PaymentStatus(paymentStatus.getStatusID(), 
										paymentStatus.getStatusDescription());
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
