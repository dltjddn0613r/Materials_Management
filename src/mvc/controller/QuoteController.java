package mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import mvc.model.Quote;
import mvc.model.QuoteDAO;

public class QuoteController extends HttpServlet {
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/Materials_Management"); // DataSource 초기화
        } catch (NamingException e) {
            throw new ServletException("Cannot retrieve DataSource", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuoteDAO quoteDAO = new QuoteDAO(dataSource); // DataSource로 QuoteDAO 초기화
        List<Quote> quotes;

        try {
            quotes = quoteDAO.getQuotes(); // DAO에서 견적서 목록 가져오기
            request.setAttribute("quotes", quotes); // JSP에 quotes 속성 설정
        } catch (SQLException e) {
            throw new ServletException("Error retrieving quotes from database", e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("quoteView.jsp");
        dispatcher.forward(request, response); // JSP로 포워드
    }
}