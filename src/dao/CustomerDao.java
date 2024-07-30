package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import model.Customer;

public class CustomerDao {

	public Customer insert(Connection conn, Customer customer) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into customer"
				+ "(customerCode, customerName, ceoName, businessType, Industry, phone, fax, SearchContent, mobile, postalCode, address1, website, responsibleEmployee, email)"
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
	 public Customer selectById(Connection conn, String customerCode) throws SQLException {
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
	            pstmt = conn.prepareStatement("SELECT * FROM Customer WHERE customerCode = ?");
	            pstmt.setString(1, customerCode);

	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return convertCustomer(rs);
	            }
	            return null;
	        } finally {
	            JdbcUtil.close(rs);
	            JdbcUtil.close(pstmt);
	        }
	    }
	private Customer convertCustomer(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return new Customer(
				rs.getString("customerCode"),
				rs.getString("customerName"),
				rs.getString("ceoName"),
				rs.getString("businessType"),
				rs.getString("industry"),
				rs.getString("phone"),
				rs.getString("fax"),
				rs.getString("SearchContent"),
				rs.getString("mobile"),
				rs.getString("postalCode"),
				rs.getString("address1"),
				rs.getString("website"),
				rs.getString("responsibleEmployee"),
				rs.getString("email"));
	}
	public List<Customer> select(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM (SELECT rownum AS rnum, a.* FROM (SELECT * FROM Customer ORDER BY customerCode DESC) a WHERE rownum <= ?) WHERE rnum >= ?");
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);

			rs = pstmt.executeQuery();
			List<Customer> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertCustomer(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
