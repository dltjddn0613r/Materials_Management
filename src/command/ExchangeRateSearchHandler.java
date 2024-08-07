package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.ExchangeRatePage;
import service.ExchangeRateSearchService;

public class ExchangeRateSearchHandler implements CommandHandler {

	private ExchangeRateSearchService exchangeRateSearchService = new ExchangeRateSearchService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String searchQuery = req.getParameter("searchQuery");
        String pageNoVal = req.getParameter("pageNo");
        int pageNo = 1;
        if (pageNoVal != null) {
            pageNo = Integer.parseInt(pageNoVal);
        }

        ExchangeRatePage exchangeRatePage = exchangeRateSearchService.searchExchangeRates(searchQuery, pageNo);

        req.setAttribute("exchangeRatePage", exchangeRatePage);
        req.setAttribute("searchQuery", searchQuery);

        return "/WEB-INF/view/exchangeRateSearch.jsp";
    }
}
