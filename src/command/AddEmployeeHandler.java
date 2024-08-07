package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.EmployeeInputRequest;
import service.EmployeeInputService;

public class AddEmployeeHandler implements CommandHandler {
    private static final String FORM_VIEW = "/WEB-INF/view/addEmployee.jsp";
    private static final String SUCCESS_VIEW = "/WEB-INF/view/addEmployeeSuccess.jsp";
    private EmployeeInputService employeeInputService = new EmployeeInputService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (req.getMethod().equalsIgnoreCase("GET")) {
            return FORM_VIEW; // GET 요청일 경우 입력 폼을 보여줍니다.
        } else if (req.getMethod().equalsIgnoreCase("POST")) {
            return processSubmit(req, res); // POST 요청일 경우 데이터를 처리합니다.
        } else {
            res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return null; // 허용되지 않은 HTTP 메서드에 대한 처리
        }
    }

    private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
        String employeeCode = req.getParameter("employeeCode");
        String employeeName = req.getParameter("employeeName");
        String searchContent = req.getParameter("searchContent");
        String menuCodeUsage = req.getParameter("menuCodeUsage");
        String memo = req.getParameter("memo");
        String contactNumber = req.getParameter("contactNumber");
        String email = req.getParameter("email");

        // EmployeeInputRequest 객체 생성
        EmployeeInputRequest employeeRequest = new EmployeeInputRequest(
            employeeCode, employeeName, searchContent, menuCodeUsage, memo, contactNumber, email);

        // 유효성 검사
        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);
        employeeRequest.validate(errors);

        if (!errors.isEmpty()) {
            return FORM_VIEW; // 오류가 있으면 폼으로 다시 이동
        }

        try {
            // 직원 정보를 데이터베이스에 저장
            employeeInputService.addEmployee(employeeRequest);
            return SUCCESS_VIEW; // 성공 페이지로 이동
        } catch (Exception e) {
            req.setAttribute("errorMessage", "중복된 사원코드입니다.");
            return FORM_VIEW; // 오류 발생 시 다시 입력 폼으로
        }
    }
}
