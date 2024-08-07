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

public class CustomerDAO {

    // 새로운 고객을 데이터베이스에 추가하는 메서드
    public Customer insert(Connection conn, Customer customer) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(
                "INSERT INTO Customer (CustomerCode, CustomerName, CEOName, BusinessType, Industry, Phone, Fax, SearchContent, Mobile, PostalCode, Address1, Website, ResponsibleEmployee, Email) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

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

            int insertedCount = pstmt.executeUpdate(); // SQL 문 실행 및 삽입된 행 수를 반환

            if (insertedCount > 0) { // 삽입이 성공한 경우
                rs = pstmt.getGeneratedKeys(); // 자동 생성된 키를 가져옵니다.
                if (rs.next()) {
                    // 생성된 키를 사용하여 CustomerCode를 설정합니다.
                    customer.setCustomerCode(rs.getString(1));
                }
                return customer; // 삽입된 Customer 객체 반환
            }
            return null; // 삽입 실패 시 null 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    // 데이터베이스에 저장된 총 고객 수를 반환하는 메서드
    public int selectCount(Connection conn) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) FROM Customer");
            if (rs.next()) {
                return rs.getInt(1); // 총 행 수 반환
            }
            return 0; // 행이 없을 경우 0 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }
    }

    // 페이지에 따라 고객 리스트를 가져오는 메서드
    public List<Customer> select(Connection conn, int firstRow, int endRow) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum as rnum, a.* FROM "
                    + "(SELECT * FROM Customer ORDER BY CustomerCode DESC) a " + "WHERE rownum <= ?) WHERE rnum >= ?");
            pstmt.setInt(1, endRow); // 종료 행 번호 설정
            pstmt.setInt(2, firstRow); // 시작 행 번호 설정

            rs = pstmt.executeQuery(); // 쿼리 실행
            List<Customer> result = new ArrayList<>(); // 결과를 담을 리스트 생성
            while (rs.next()) {
                result.add(convertCustomer(rs)); // 각 행을 Customer 객체로 변환하여 리스트에 추가
            }
            return result; // 결과 리스트 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    // ResultSet을 Customer 객체로 변환하는 메서드
    private Customer convertCustomer(ResultSet rs) throws SQLException {
        return new Customer(
            rs.getString("CustomerCode"),
            rs.getString("CustomerName"),
            rs.getString("CEOName"),
            rs.getString("BusinessType"),
            rs.getString("Industry"),
            rs.getString("Phone"),
            rs.getString("Fax"),
            rs.getString("SearchContent"),
            rs.getString("Mobile"),
            rs.getString("PostalCode"),
            rs.getString("Address1"),
            rs.getString("Website"),
            rs.getString("ResponsibleEmployee"),
            rs.getString("Email")
        );
    }

    // 고객 코드로 특정 고객을 조회하는 메서드
    public Customer selectByCode(Connection conn, String customerCode) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Customer WHERE CustomerCode = ?");
            pstmt.setString(1, customerCode);

            rs = pstmt.executeQuery();
            Customer customer = null;
            if (rs.next()) {
                customer = convertCustomer(rs); // 결과를 Customer 객체로 변환하여 반환
            }
            return customer; // 결과가 없으면 null 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    // 검색어에 해당하는 고객의 총 개수를 반환하는 메서드
    public int searchCount(Connection conn, String searchQuery) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Customer WHERE CustomerName LIKE ? OR CustomerCode LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%");
            pstmt.setString(2, "%" + searchQuery + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1); // 총 개수 반환
                }
                return 0; // 결과가 없으면 0 반환
            }
        }
    }

    // 검색어에 해당하는 고객들을 검색하는 메서드
    public List<Customer> search(Connection conn, String searchQuery, int firstRow, int endRow) throws SQLException {
        String sql = "SELECT * FROM (SELECT rownum as rnum, a.* FROM (SELECT * FROM Customer WHERE CustomerName LIKE ? OR CustomerCode LIKE ? ORDER BY CustomerCode DESC) a WHERE rownum <= ?) WHERE rnum >= ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%");
            pstmt.setString(2, "%" + searchQuery + "%");
            pstmt.setInt(3, endRow);
            pstmt.setInt(4, firstRow);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Customer> result = new ArrayList<>();
                while (rs.next()) {
                    result.add(convertCustomer(rs)); // 각 결과를 Customer 객체로 변환하여 리스트에 추가
                }
                return result; // 결과 리스트 반환
            }
        }
    }
 // 중복 체크를 위한 메서드
    public boolean existsByCode(Connection conn, String customerCode) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Customer WHERE CustomerCode = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customerCode);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // 존재하면 true 반환
                }
                return false;
            }
        }
    }
}
