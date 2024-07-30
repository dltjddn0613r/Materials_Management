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
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs =stmt.executeQuery("select count(*) from transactionType");
			if(rs.next()) {
				return rs.getInt(1); // 조회된 행 수 반환
			}
			return 0;// 행이 없으면 0반환
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	public List<TransactionType> select(Connection conn,int firstRow, int endRow) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum as rnum, a.* FROM "
					+ "(SELECT * FROM transactionType ORDER BY TransactionTypeCode DESC) a " + "WHERE rownum <= ?) WHERE rnum >= ?");
		// SQL 쿼리에 데이ㅓ 바인딩
		pstmt.setInt(1, endRow);
		pstmt.setInt(2, endRow);
		
		rs= pstmt.executeQuery();
		List<TransactionType> result = new ArrayList<>();
		while(rs.next()) {
			result.add(convertTransactionType(rs));
		}
		return result;
	}finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
	}
	}
	private TransactionType convertTransactionType(ResultSet rs) throws SQLException{
		return  new TransactionType(rs.getString("TransactionTypeCode"),rs.getString("TransactionTypeName"));
	}
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	public TransactionType selectById(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from transactionType where TransactionTypeCode =?");
		    pstmt.setInt(1, no);
		    
		    // SQL 쿼리 실행
		    rs = pstmt.executeQuery();
		    TransactionType transactionType = null;
		    if(rs.next()) {
		    	transactionType = convertTransactionType(rs);
		    }
		    return transactionType;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		}
	}
}
