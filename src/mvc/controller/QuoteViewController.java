package mvc.controller;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import mvc.command.CommandHandler;
import mvc.model.Quote;
import mvc.model.QuoteDAO;

public class QuoteViewController implements CommandHandler {

    private QuoteDAO quoteDAO;

    public QuoteViewController() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/Materials_Management");
            this.quoteDAO = new QuoteDAO(dataSource); // DataSource로 QuoteDAO 초기화
        } catch (NamingException e) {
            throw new RuntimeException("Cannot retrieve DataSource", e);
        }
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String searchQuery = request.getParameter("searchQuery");
        List<Quote> quotes;

        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            quotes = quoteDAO.searchQuotes(searchQuery);
        } else {
            quotes = quoteDAO.getQuotes();
        }

        request.setAttribute("quotes", quotes);
        return "/quoteView.jsp";  // 포워딩할 JSP 페이지
    }
}
