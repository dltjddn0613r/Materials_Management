package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.command.CommandHandler;
import service.EmployeeSearchService;
import service.EmployeePage;

public class EmployeeSearchHandler implements CommandHandler {
    private EmployeeSearchService employeeSearchService = new EmployeeSearchService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String searchQuery = req.getParameter("searchQuery");
        String pageNoVal = req.getParameter("pageNo");
        int pageNo = 1;
        if (pageNoVal != null) {
            pageNo = Integer.parseInt(pageNoVal);
        }

        EmployeePage employeePage = employeeSearchService.searchEmployees(searchQuery, pageNo);

        req.setAttribute("employeePage", employeePage);
        req.setAttribute("searchQuery", searchQuery);

        return "/WEB-INF/view/employeeSearch.jsp";
    }
}
