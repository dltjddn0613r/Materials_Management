package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import dao.CustomerDAO;
import jdbc.connection.ConnectionProvider;
import model.Customer;

public class CustomerSearchService {
    private CustomerDAO customerDao = new CustomerDAO();
    private int size = 20; // 한 페이지당 표시할 개수

    public CustomerPage searchCustomers(String searchQuery, int pageNo) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            int total = customerDao.searchCount(conn, searchQuery);

            List<Customer> content = null;
            if (total > 0) {
                int firstRow = (pageNo - 1) * size + 1;
                int endRow = firstRow + size - 1;
                content = customerDao.search(conn, searchQuery, firstRow, endRow);
            }
            return new CustomerPage(total, pageNo, size, content);
        } catch (SQLException e) {
            throw new RuntimeException("고객 검색 중 오류가 발생했습니다.", e);
        }
    }
}
