package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import model.Employee;


public class EmployeeDao {

	public Employee insert(Connection conn, Employee employee) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into employee"
				+ "(EmployeeCode, EmployeeName, SearchContent, MenuCodeUsage, Memo, ContactNumber, Email)"
				+ "values(?, ?, ?, ?, ?, ?, ?)");
		pstmt.setString(1, employee.getEmployeeCode());
		pstmt.setString(2, employee.getEmployeeName());
		pstmt.setString(3, employee.getSearchContent());
		pstmt.setString(4, employee.getMenuCodeUsage());
		pstmt.setString(5, employee.getMemo());
		pstmt.setString(6, employee.getContactNumber());
		pstmt.setString(7, employee.getEmail());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT EmployeeCode FROM Employee ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
			if(rs.next()) {
				return new Employee(employee.getEmployeeCode(), 
									employee.getEmployeeName(),
									employee.getSearchContent(),
									employee.getMenuCodeUsage(),
									employee.getMemo(),
									employee.getContactNumber(),
									employee.getEmail());
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
