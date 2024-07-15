package model;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Quote;

public class QuoteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("searchQuery");
        List<Quote> quoteList = getQuoteList(); // 실제 데이터 가져오는 메서드

        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            quoteList = filterQuotes(quoteList, searchQuery);
        }

        request.setAttribute("quoteList", quoteList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("quoteView.jsp");
        dispatcher.forward(request, response);
    }

    private List<Quote> getQuoteList() {
        // 예시 데이터 추가
        List<Quote> quoteList = new ArrayList<>();
        quoteList.add(new Quote(1, "2024-07-15", "001", "ABC Corp", "John Doe", "Item A", "2024-08-15", 1000.00, "진행 중", "Voucher 1"));
        // 추가 데이터...
        return quoteList;
    }

    private List<Quote> filterQuotes(List<Quote> quoteList, String searchQuery) {
        List<Quote> filteredList = new ArrayList<>();
        for (Quote quote : quoteList) {
            if (quote.getClientName().contains(searchQuery) || 
                quote.getManagerName().contains(searchQuery) || 
                quote.getItemName().contains(searchQuery)) {
                filteredList.add(quote);
            }
        }
        return filteredList;
    }
}
