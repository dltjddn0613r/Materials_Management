package mvc.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class QuoteServlet extends HttpServlet {
    private DataSource dataSource;
    private QuoteDAO quoteDAO;

    public void init() throws ServletException {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/Materials_Management");
            quoteDAO = new QuoteDAO(dataSource); // DataSource로 QuoteDAO 초기화 ㅎ
        } catch (NamingException e) {
            throw new ServletException("Cannot retrieve java:/comp/env/jdbc/Materials_Management", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Quote> quotes = quoteDAO.getQuotes(); // DB에서 인용문을 가져옵니다.
            request.setAttribute("quotes", quotes); // 요청에 인용문을 설정합니다.
            RequestDispatcher dispatcher = request.getRequestDispatcher("quoteView.jsp");
            dispatcher.forward(request, response); // JSP로 전달합니다.
        } catch (SQLException e) {
            throw new ServletException("Error retrieving quotes from database", e);
        }
    }
}
