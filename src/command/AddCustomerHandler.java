package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.CustomerInputRequest;
import service.CustomerInputService;

public class AddCustomerHandler implements CommandHandler {
    private static final String FORM_VIEW = "/WEB-INF/view/addCustomer.jsp";
    private static final String SUCCESS_VIEW = "/WEB-INF/view/addCustomerSuccess.jsp";
    private CustomerInputService customerInputService = new CustomerInputService();

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
        String customerCode = req.getParameter("customerCode");
        String customerName = req.getParameter("customerName");
        String ceoName = req.getParameter("ceoName");
        String businessType = req.getParameter("businessType");
        String industry = req.getParameter("industry");
        String phone = req.getParameter("phone");
        String fax = req.getParameter("fax");
        String searchContent = req.getParameter("searchContent");
        String mobile = req.getParameter("mobile");
        String postalCode = req.getParameter("postalCode");
        String address1 = req.getParameter("address1");
        String website = req.getParameter("website");
        String responsibleEmployee = req.getParameter("responsibleEmployee");
        String email = req.getParameter("email");

        // CustomerInputRequest 객체 생성
        CustomerInputRequest customerRequest = new CustomerInputRequest(
            customerCode, customerName, ceoName, businessType, industry, phone, 
            fax, searchContent, mobile, postalCode, address1, website, 
            responsibleEmployee, email);

        // 유효성 검사
        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);
        customerRequest.validate(errors);

        if (!errors.isEmpty()) {
            return FORM_VIEW; // 오류가 있으면 폼으로 다시 이동
        }
        

        try {
            // 고객 정보를 데이터베이스에 저장
            customerInputService.addCustomer(customerRequest);
            return SUCCESS_VIEW; // 성공 페이지로 이동
        } catch (Exception e) {
            req.setAttribute("errorMessage", "중복된 거래처코드입니다.");
            return FORM_VIEW; // 오류 발생 시 다시 입력 폼으로
        }
    }
}
