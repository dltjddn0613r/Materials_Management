package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.ProjectPage;
import service.ProjectSearchService;

public class ProjectSearchHandler implements CommandHandler {
  
    private ProjectSearchService projectSearchService = new ProjectSearchService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        String searchQuery = req.getParameter("searchQuery");
        String pageNoVal = req.getParameter("pageNo");
        int pageNo = 1;
        if (pageNoVal != null) {
            pageNo = Integer.parseInt(pageNoVal);
        }

        ProjectPage projectPage = projectSearchService.searchProjects(searchQuery, pageNo);

        req.setAttribute("projectPage", projectPage);
        req.setAttribute("searchQuery", searchQuery);

        return "/WEB-INF/view/projectSearch.jsp";
    }
}
