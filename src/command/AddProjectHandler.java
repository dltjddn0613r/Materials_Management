package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.ProjectInputRequest;
import service.ProjectInputService;

public class AddProjectHandler implements CommandHandler {
    private static final String FORM_VIEW = "/WEB-INF/view/addProject.jsp";
    private static final String SUCCESS_VIEW = "/WEB-INF/view/addProjectSuccess.jsp";
    private ProjectInputService projectInputService = new ProjectInputService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        if (req.getMethod().equalsIgnoreCase("GET")) {
            return FORM_VIEW;
        } else if (req.getMethod().equalsIgnoreCase("POST")) {
            return processSubmit(req, res);
        } else {
            res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return null;
        }
    }


    private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
    	String projectCode = req.getParameter("projectCode");
    	String projectName = req.getParameter("projectName");
    	String projectGroup = req.getParameter("projectGroup");
    	String projectMemo = req.getParameter("projectMemo");
      

        ProjectInputRequest projectRequest = new ProjectInputRequest(projectCode,projectName,projectGroup,projectMemo);
        
        
        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);
        projectRequest.validate(errors);

        if (!errors.isEmpty()) {
            return FORM_VIEW;
        }
        try {

        projectInputService.addProject(projectRequest);
        return SUCCESS_VIEW;
        }catch(Exception e) {
        	req.setAttribute("errorMessage", "중복된 프로젝트코드입니다.");
        	return FORM_VIEW;
        }

   
    }
}
