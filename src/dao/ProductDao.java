package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import model.Product;

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
}
