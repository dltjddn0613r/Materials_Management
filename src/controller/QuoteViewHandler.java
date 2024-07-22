package controller;

import mvc.command.CommandHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import model.Quote;
import model.QuoteDAO;

public class QuoteViewHandler implements CommandHandler {

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        QuoteDAO quoteDAO = new QuoteDAO();
        List<Quote> quotes = quoteDAO.getQuotes();
        
        // 디버깅 메시지 추가
        System.out.println("Quotes size: " + quotes.size());
        
        req.setAttribute("quotes", quotes);
        return "/views/quoteView.jsp";
    }
}
