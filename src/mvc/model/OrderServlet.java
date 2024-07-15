package mvc.model;
import javax.servlet.*;
import javax.servlet.http.*;

import mvc.model.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("searchQuery");
        List<Order> orderList = getOrderList(); // 실제 데이터 가져오는 메서드

        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            orderList = filterOrders(orderList, searchQuery);
        }

        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderView.jsp");
        dispatcher.forward(request, response);
    }

    private List<Order> getOrderList() {
        // 예시 데이터 추가
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1, "2024-07-15", "001", "ABC Corp", "John Doe", "Item A", "2024-07-20", 2000.00, "진행 중", "Voucher 1"));
        // 추가 데이터...
        return orderList;
    }

    private List<Order> filterOrders(List<Order> orderList, String searchQuery) {
        List<Order> filteredList = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getClientName().contains(searchQuery) || 
                order.getManagerName().contains(searchQuery) || 
                order.getItemName().contains(searchQuery)) {
                filteredList.add(order);
            }
        }
        return filteredList;
    }
}
