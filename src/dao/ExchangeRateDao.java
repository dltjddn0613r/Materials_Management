package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import model.ExchangeRate;

public class ExchangeRateDao {

	public ExchangeRate insert(Connection conn, ExchangeRate exchangeRate) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into exchangeRate"
				+ "(ExchangeRateCode, ExchangeRateName, ExchangeRate)"
				+ "values(?, ?, ?)");
		pstmt.setString(1, exchangeRate.getExchangeRateCode());
		pstmt.setString(2, exchangeRate.getExchangeRateName());
		pstmt.setDouble(3, exchangeRate.getExchangeRate());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT ExchangeRateCode FROM ExchangeRate ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
			if(rs.next()) {
				return new ExchangeRate(exchangeRate.getExchangeRateCode(), 
										exchangeRate.getExchangeRateName(),
										exchangeRate.getExchangeRate());
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
