package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import model.OrderManagement;

public class OrderManagementDao {

    public OrderManagement insert(Connection conn, OrderManagement orderManagement) throws SQLException {
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement("INSERT INTO orderManagement"
                    + " (OrderNumber, OrderName, OrderType)"
                    + " VALUES (?, ?, ?)");
            pstmt.setString(1, orderManagement.getOrderNumber());
            pstmt.setString(2, orderManagement.getOrderName());
            pstmt.setString(3, orderManagement.getOrderType());

            int insertedCount = pstmt.executeUpdate();

            if (insertedCount > 0) {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM (SELECT OrderNumber FROM OrderManagement ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
                if (rs.next()) {
                    return new OrderManagement(orderManagement.getOrderNumber(),
                            orderManagement.getOrderName(),
                            orderManagement.getOrderType());
                }
            }
            return null;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
            JdbcUtil.close(pstmt);
        }
    }

    public List<OrderManagement> selectAll(Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<OrderManagement> orderList = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM OrderManagement");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                OrderManagement orderManagement = new OrderManagement(
                        rs.getString("OrderNumber"),
                        rs.getString("OrderName"),
                        rs.getString("OrderType")
                );
                orderList.add(orderManagement);
            }
            return orderList;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    public OrderManagement selectByOrderName(Connection conn, String orderName) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement("SELECT * FROM OrderManagement WHERE OrderName = ?");
            pstmt.setString(1, orderName);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return new OrderManagement(
                        rs.getString("OrderNumber"),
                        rs.getString("OrderName"),
                        rs.getString("OrderType")
                );
            }
            return null;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}

