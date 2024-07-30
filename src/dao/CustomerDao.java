package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import model.Customer;

public class CustomerDao {

	public Customer insert(Connection conn, Customer customer) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into customer"
				+ "(CustomerCode, CustomerName, CEOName, BusinessType, Industry, Phone, Fax, SearchContent, Mobile, PostalCode, Address1, Website, ResponsibleEmployee, Email)"
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		pstmt.setString(1, customer.getCustomerCode());
		pstmt.setString(2, customer.getCustomerName());
		pstmt.setString(3, customer.getCeoName());
		pstmt.setString(4, customer.getBusinessType());
		pstmt.setString(5, customer.getIndustry());
		pstmt.setString(6, customer.getPhone());
		pstmt.setString(7, customer.getFax());
		pstmt.setString(8, customer.getSearchContent());
		pstmt.setString(9, customer.getMobile());
		pstmt.setString(10, customer.getPostalCode());
		pstmt.setString(11, customer.getAddress1());
		pstmt.setString(12, customer.getWebsite());
		pstmt.setString(13, customer.getResponsibleEmployee());
		pstmt.setString(14, customer.getEmail());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT CustomerCode FROM Customer ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
			if(rs.next()) {
				return new Customer(customer.getCustomerCode(), 
									customer.getCustomerName(),
									customer.getCeoName(),
									customer.getBusinessType(),
									customer.getIndustry(),
									customer.getPhone(),
									customer.getFax(),
									customer.getSearchContent(),
									customer.getMobile(),
									customer.getPostalCode(),
									customer.getAddress1(),
									customer.getWebsite(),
									customer.getResponsibleEmployee(),
									customer.getEmail());
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
