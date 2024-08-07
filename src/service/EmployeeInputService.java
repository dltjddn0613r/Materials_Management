package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.EmployeeDAO;
import jdbc.connection.ConnectionProvider;
import model.Employee;

public class EmployeeInputService {
    private EmployeeDAO employeeDao = new EmployeeDAO();

    public void addEmployee(EmployeeInputRequest req) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            Employee employee = new Employee(
                req.getEmployeeCode(), req.getEmployeeName(), req.getSearchContent(),
                req.getMenuCodeUsage(), req.getMemo(), req.getContactNumber(),
                req.getEmail()
            );
            employeeDao.insert(conn, employee);
        } catch (SQLException e) {
            throw new RuntimeException("직원 추가 중 오류가 발생했습니다.", e);
        }
    }
}
