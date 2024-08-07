package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import model.Employee;

public class EmployeeDAO {
	
	// 새로운 직원 정보를 데이터베이스에 추가하는 메서드
    public Employee insert(Connection conn, Employee employee) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(
                "INSERT INTO Employee (EmployeeCode, EmployeeName, SearchContent, MenuCodeUsage, Memo, ContactNumber, Email) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, employee.getEmployeeCode());
            pstmt.setString(2, employee.getEmployeeName());
            pstmt.setString(3, employee.getSearchContent());
            pstmt.setString(4, employee.getMenuCodeUsage());
            pstmt.setString(5, employee.getMemo());
            pstmt.setString(6, employee.getContactNumber());
            pstmt.setString(7, employee.getEmail());

            int insertedCount = pstmt.executeUpdate(); // SQL 문 실행 및 삽입된 행 수를 반환

            if (insertedCount > 0) { // 삽입이 성공한 경우
                rs = pstmt.getGeneratedKeys(); // 자동 생성된 키를 가져옵니다.
                if (rs.next()) {
                    // 생성된 키를 사용하여 EmployeeCode를 설정합니다.
                    employee.setEmployeeCode(rs.getString(1));
                }
                return employee; // 삽입된 Employee 객체 반환
            }
            return null; // 삽입 실패 시 null 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
    
    // 데이터베이스에 저장된 총 직원 수를 반환하는 메서드
    public int selectCount(Connection conn) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) FROM Employee");
            if (rs.next()) {
                return rs.getInt(1); // 총 행 수 반환
            }
            return 0; // 행이 없을 경우 0 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }
    }
    
    // 페이지에 따라 직원 리스트를 가져오는 메서드
    public List<Employee> select(Connection conn, int firstRow, int endRow) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum as rnum, a.* FROM "
                    + "(SELECT * FROM Employee ORDER BY EmployeeCode DESC) a " + "WHERE rownum <= ?) WHERE rnum >= ?");
            pstmt.setInt(1, endRow); // 종료 행 번호 설정
            pstmt.setInt(2, firstRow); // 시작 행 번호 설정

            rs = pstmt.executeQuery(); // 쿼리 실행
            List<Employee> result = new ArrayList<>(); // 결과를 담을 리스트 생성
            while (rs.next()) {
                result.add(convertEmployee(rs)); // 각 행을 Employee 객체로 변환하여 리스트에 추가
            }
            return result; // 결과 리스트 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
    
    private Employee convertEmployee(ResultSet rs) throws SQLException {
        return new Employee(
            rs.getString("EmployeeCode"),
            rs.getString("EmployeeName"),
            rs.getString("SearchContent"),
            rs.getString("MenuCodeUsage"),
            rs.getString("Memo"),
            rs.getString("ContactNumber"),
            rs.getString("Email")
        );
    }
    
    // 직원 코드로 특정 직원을 조회하는 메서드
    public Employee selectByCode(Connection conn, String employeeCode) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Employee WHERE EmployeeCode = ?");
            pstmt.setString(1, employeeCode);

            rs = pstmt.executeQuery();
            Employee employee = null;
            if (rs.next()) {
                employee = convertEmployee(rs); // 결과를 Employee 객체로 변환하여 반환
            }
            return employee; // 결과가 없으면 null 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }


    public int searchCount(Connection conn, String searchQuery) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Employee WHERE EmployeeName LIKE ? OR EmployeeCode LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%");
            pstmt.setString(2, "%" + searchQuery + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
                return 0;
            }
        }
    }

    public List<Employee> search(Connection conn, String searchQuery, int firstRow, int endRow) throws SQLException {
        String sql = "SELECT * FROM (SELECT rownum as rnum, a.* FROM (SELECT * FROM Employee WHERE EmployeeName LIKE ? OR EmployeeCode LIKE ? ORDER BY EmployeeCode DESC) a WHERE rownum <= ?) WHERE rnum >= ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%");
            pstmt.setString(2, "%" + searchQuery + "%");
            pstmt.setInt(3, endRow);
            pstmt.setInt(4, firstRow);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Employee> result = new ArrayList<>();
                while (rs.next()) {
                    result.add(convertEmployee(rs));
                }
                return result;
            }
        }
    }

  
}
