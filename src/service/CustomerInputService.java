package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.CustomerDAO;
import jdbc.connection.ConnectionProvider;
import model.Customer;

public class CustomerInputService {
    private CustomerDAO customerDao = new CustomerDAO();

    public void addCustomer(CustomerInputRequest req) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            Customer customer = new Customer(
                req.getCustomerCode(), req.getCustomerName(), req.getCeoName(),
                req.getBusinessType(), req.getIndustry(), req.getPhone(),
                req.getFax(), req.getSearchContent(), req.getMobile(),
                req.getPostalCode(), req.getAddress1(), req.getWebsite(),
                req.getResponsibleEmployee(), req.getEmail()
            );
            customerDao.insert(conn, customer);
        } catch (SQLException e) {
            throw new RuntimeException("거래처 추가 중 오류가 발생했습니다.", e);
        }
    }
    
}
