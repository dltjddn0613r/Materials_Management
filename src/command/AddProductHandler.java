package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.ProductInputRequest;
import service.ProductInputService;

public class AddProductHandler implements CommandHandler {
    private static final String FORM_VIEW = "/WEB-INF/view/addProduct.jsp";
    private static final String SUCCESS_VIEW = "/WEB-INF/view/addProductSuccess.jsp";
    private ProductInputService productInputService = new ProductInputService();

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
        String productCode = req.getParameter("productCode");
        String productName = req.getParameter("productName");
        String productGroup = req.getParameter("productGroup");
        String standard = req.getParameter("standard");
        String barcode = req.getParameter("barcode");
        double purchasePrice = Double.parseDouble(req.getParameter("purchasePrice"));
        double sellingPrice = Double.parseDouble(req.getParameter("sellingPrice"));
        String productionProcess = req.getParameter("productionProcess");
     
       

        // ProductInputRequest 객체 생성
        ProductInputRequest productRequest = new ProductInputRequest(productCode, productName, productGroup, standard, barcode, purchasePrice, sellingPrice, productionProcess);

        // 유효성 검사
        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);
        productRequest.validate(errors);

        if (!errors.isEmpty()) {
            return FORM_VIEW; // 오류가 있으면 폼으로 다시 이동
        }

        try {
            // 상품 정보를 데이터베이스에 저장
            productInputService.addProduct(productRequest);
            return SUCCESS_VIEW; // 성공 페이지로 이동
        } catch (Exception e) {
            req.setAttribute("errorMessage", "중복된 상품코드입니다.");
            return FORM_VIEW; // 오류 발생 시 다시 입력 폼으로
        }
    }
}
