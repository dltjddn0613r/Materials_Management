package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ProductDAO; // 데이터베이스와 상호작용하는 DAO 클래스
import jdbc.JdbcUtil; // JDBC 유틸리티 클래스
import jdbc.connection.ConnectionProvider; // 데이터베이스 연결 제공
import model.Product; // 상품 데이터를 나타내는 모델 클래스

public class ProductInputService {
    private ProductDAO productDao = new ProductDAO(); // ProductDAO 인스턴스 생성

    // 새로운 상품을 추가하는 메서드
    public String addProduct(ProductInputRequest req) { // handler에서 호출
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            conn.setAutoCommit(false); // 트랜잭션 시작

            Product product = toProduct(req); // ProductInputRequest를 Product로 변환
            Product savedProduct = productDao.insert(conn, product); // 객체를 하나 따로 만듦
            if (savedProduct == null) { // insert()를 실행하고 결과를 savedProduct에 할당
                throw new RuntimeException("상품 삽입 실패");
            }
            conn.commit(); // 삽입이 성공하면 트랜잭션 커밋
            return savedProduct.getProductCode(); // handler로 리턴
        } catch (SQLException e) { // 예외가 발생하면 트랜잭션을 롤백
            JdbcUtil.rollback(conn);
            throw new RuntimeException("데이터베이스 오류", e);
        } catch (RuntimeException e) {
            JdbcUtil.rollback(conn);
            throw e;
        } finally {
            JdbcUtil.close(conn);
        }
    }

    // ProductInputRequest를 Product 객체로 변환하는 메서드
    private Product toProduct(ProductInputRequest req) {
        return new Product(
            req.getProductCode(),
            req.getProductName(),
            req.getProductGroup(),
            req.getStandard(),
            req.getBarcode(),
            req.getPurchasePrice(),
            req.getSellingPrice(),
            req.getProductionProcess()
        );
    }
}
