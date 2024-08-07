package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import model.Product;

public class ProductDAO {

    // 새로운 제품을 데이터베이스에 추가하는 메서드
    public Product insert(Connection conn, Product product) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(
                "INSERT INTO Product (ProductCode, ProductName, ProductGroup, Standard, Barcode, PurchasePrice, SellingPrice, ProductionProcess) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, product.getProductCode());
            pstmt.setString(2, product.getProductName());
            pstmt.setString(3, product.getProductGroup());
            pstmt.setString(4, product.getStandard());
            pstmt.setString(5, product.getBarcode());
            pstmt.setDouble(6, product.getPurchasePrice());
            pstmt.setDouble(7, product.getSellingPrice());
            pstmt.setString(8, product.getProductionProcess());

            int insertedCount = pstmt.executeUpdate(); // SQL 문 실행 및 삽입된 행 수를 반환

            if (insertedCount > 0) { // 삽입이 성공한 경우
                rs = pstmt.getGeneratedKeys(); // 자동 생성된 키를 가져옵니다.
                if (rs.next()) {
                    // 생성된 키를 사용하여 ProductCode를 설정합니다.
                    product.setProductCode(rs.getString(1));
                }
                return product; // 삽입된 Product 객체 반환
            }
            return null; // 삽입 실패 시 null 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    // 데이터베이스에 저장된 총 제품 수를 반환하는 메서드
    public int selectCount(Connection conn) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) FROM Product");
            if (rs.next()) {
                return rs.getInt(1); // 총 행 수 반환
            }
            return 0; // 행이 없을 경우 0 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }
    }

    // 페이지에 따라 제품 리스트를 가져오는 메서드
    public List<Product> select(Connection conn, int firstRow, int endRow) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum as rnum, a.* FROM "
                    + "(SELECT * FROM Product ORDER BY ProductCode DESC) a " + "WHERE rownum <= ?) WHERE rnum >= ?");
            pstmt.setInt(1, endRow); // 종료 행 번호 설정
            pstmt.setInt(2, firstRow); // 시작 행 번호 설정

            rs = pstmt.executeQuery(); // 쿼리 실행
            List<Product> result = new ArrayList<>(); // 결과를 담을 리스트 생성
            while (rs.next()) {
                result.add(convertProduct(rs)); // 각 행을 Product 객체로 변환하여 리스트에 추가
            }
            return result; // 결과 리스트 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    // ResultSet을 Product 객체로 변환하는 메서드
    private Product convertProduct(ResultSet rs) throws SQLException {
        return new Product(
            rs.getString("ProductCode"),
            rs.getString("ProductName"),
            rs.getString("ProductGroup"),
            rs.getString("Standard"),
            rs.getString("Barcode"),
            rs.getDouble("PurchasePrice"),
            rs.getDouble("SellingPrice"),
            rs.getString("ProductionProcess")
        );
    }

    // 제품 코드로 특정 제품을 조회하는 메서드
    public Product selectByCode(Connection conn, String productCode) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Product WHERE ProductCode = ?");
            pstmt.setString(1, productCode);

            rs = pstmt.executeQuery();
            Product product = null;
            if (rs.next()) {
                product = convertProduct(rs); // 결과를 Product 객체로 변환하여 반환
            }
            return product; // 결과가 없으면 null 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    // 검색어에 해당하는 제품의 총 개수를 반환하는 메서드
    public int searchCount(Connection conn, String searchQuery) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Product WHERE ProductName LIKE ? OR ProductCode LIKE ?";
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

    // 검색어에 해당하는 제품들을 검색하는 메서드
    public List<Product> search(Connection conn, String searchQuery, int firstRow, int endRow) throws SQLException {
        String sql = "SELECT * FROM (SELECT rownum as rnum, a.* FROM (SELECT * FROM Product WHERE ProductName LIKE ? OR ProductCode LIKE ? ORDER BY ProductCode DESC) a WHERE rownum <= ?) WHERE rnum >= ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%");
            pstmt.setString(2, "%" + searchQuery + "%");
            pstmt.setInt(3, endRow);
            pstmt.setInt(4, firstRow);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Product> result = new ArrayList<>();
                while (rs.next()) {
                    result.add(convertProduct(rs)); // 각 결과를 Product 객체로 변환하여 리스트에 추가
                }
                return result; // 결과 리스트 반환
            }
        }
    }
}
