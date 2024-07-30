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
import model.Sale;

public class ProductDao {

	public Product insert(Connection conn, Product product) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement("insert into product"
				+ "(ProductCode, ProductName, ProductGroup, Price, Barcode, PurchasePrice, SellingPrice, ProductionProcess, Image)"
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
		pstmt.setString(1, product.getProductCode());
		pstmt.setString(2, product.getProductName());
		pstmt.setString(3, product.getProductGroup());
		pstmt.setDouble(4, product.getPrice());
		pstmt.setString(5, product.getBarcode());
		pstmt.setDouble(6, product.getPurchasePrice());
		pstmt.setDouble(7, product.getSellingPrice());
		pstmt.setString(8, product.getProductionProcess());
		pstmt.setBlob(9, product.getImage());
		
		int insertedCount = pstmt.executeUpdate();
		
		if(insertedCount > 0) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM(SELECT ProductCode FROM Product ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
			if(rs.next()) {
				return new Product(product.getProductCode(), 
									product.getProductName(),
									product.getProductGroup(),
									product.getPrice(),
									product.getBarcode(),
									product.getPurchasePrice(),
									product.getSellingPrice(),
									product.getProductionProcess(),
									product.getImage());
			}
		}
		return null;
	} finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(pstmt);
	}
	}
	
	public int selectCount(Connection conn) throws SQLException { // Product 테이블의 전체 레코드 수 리턴
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) FROM Product");
            if (rs.next()) {
                return rs.getInt(1); // 조회된 행 수 반환
            }
            return 0; // 행이 없으면 0 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }
    }
	
	public List<Product> select(Connection conn, int firstRow, int endRow) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
          
            pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum AS rnum, a.* FROM (SELECT * FROM Product ORDER BY SaleDate DESC) a WHERE rownum <= ?) WHERE rnum >= ?");
            pstmt.setInt(1, endRow);
            pstmt.setInt(2, firstRow);

            rs = pstmt.executeQuery();
            List<Product> result = new ArrayList<>();
            while (rs.next()) {
            	result.add(convertSale(rs));
            }
            return result;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
