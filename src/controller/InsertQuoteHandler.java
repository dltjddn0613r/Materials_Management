package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/insertQuote")
public class InsertQuoteHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/Materials_Management");
        } catch (NamingException e) {
            throw new ServletException("Cannot retrieve java:comp/env/jdbc/Materials_Management", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 폼 데이터 읽기
        String quoteDate = request.getParameter("quoteDate");
        String quoteNumber = request.getParameter("quoteNumber");
        String customerCode = request.getParameter("customerCode");
        String employeeCode = request.getParameter("employeeCode");
        String productCode = request.getParameter("productCode");
        String validityPeriod = request.getParameter("validityPeriod");
        String totalAmountStr = request.getParameter("totalAmount");
        String status = request.getParameter("status");

        try (Connection conn = dataSource.getConnection()) {
            // SQL 쿼리 준비
            String sql = "INSERT INTO Quotes (QuoteID, QuoteDate, QuoteNumber, CustomerCode, EmployeeCode, ProductCode, ValidityPeriod, TotalAmount, Status) VALUES (?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // 각 파라미터 설정
                pstmt.setString(1, "Q" + System.currentTimeMillis()); // 유니크 ID 생성
                pstmt.setString(2, quoteDate);
                pstmt.setString(3, quoteNumber);
                pstmt.setString(4, customerCode);
                pstmt.setString(5, employeeCode);
                pstmt.setString(6, productCode);
                pstmt.setString(7, validityPeriod != null && !validityPeriod.isEmpty() ? validityPeriod : null);
                pstmt.setDouble(8, Double.parseDouble(totalAmountStr));
                pstmt.setString(9, status);

                // 쿼리 실행
                pstmt.executeUpdate();
            }

            // 리다이렉트
            response.sendRedirect(request.getContextPath() + "/quoteView");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
