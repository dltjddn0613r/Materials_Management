package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import model.TransactionType;

public class TransactionTypeDao {

	public TransactionType insert(Connection conn, TransactionType transactionType) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into transactionType"
				+ "(TransactionTypeCode, TransactionTypeName)"
				+ "values(?, ?)");
		pstmt.setString(1, transactionType.getTransactionTypeCode());
		pstmt.setString(2, transactionType.getTransactionTypeName());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT TransactionTypeCode FROM TransactionType ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
			if(rs.next()) {
				return new TransactionType(transactionType.getTransactionTypeCode(), 
											transactionType.getTransactionTypeName());
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
