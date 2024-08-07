package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.CustomerPage;
import service.CustomerSearchService;

public class CustomerSearchHandler implements CommandHandler {
    private CustomerSearchService customerSearchService = new CustomerSearchService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String searchQuery = req.getParameter("searchQuery");
        String pageNoVal = req.getParameter("pageNo");
        int pageNo = 1;
        if (pageNoVal != null) {
            pageNo = Integer.parseInt(pageNoVal);
        }

        CustomerPage customerPage = customerSearchService.searchCustomers(searchQuery, pageNo);

        req.setAttribute("customerPage", customerPage);
        req.setAttribute("searchQuery", searchQuery);

        return "/WEB-INF/view/customerSearch.jsp";
    }
}
