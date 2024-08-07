package command;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.QuoteModifyService;
import service.QuoteModifyRequest;

public class QuoteModifyHandler implements CommandHandler { // 견적서를 수정하는 핸들러

    private static final String FORM_VIEW = "/WEB-INF/view/quoteModify.jsp"; // 견적 수정 폼을 표시하기 위한 JSP 뷰의 경로
    private QuoteModifyService quoteModifyService = new QuoteModifyService(); // 견적 수정 로직을 처리하는 서비스 인스턴스

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        if (req.getMethod().equalsIgnoreCase("GET")) {
            return processForm(req, res); // GET 요청일 경우 폼 처리 메서드 호출
        } else if (req.getMethod().equalsIgnoreCase("POST")) {
            return processSubmit(req, res); // POST 요청일 경우 제출 처리 메서드 호출
        } else {
            res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return null; // 허용되지 않은 HTTP 메서드일 경우 에러 응답
        }
    }

    private String processForm(HttpServletRequest req, HttpServletResponse res) { // GET 요청 시 폼을 보여주는 메서드
        return FORM_VIEW;
    }

    private String processSubmit(HttpServletRequest req, HttpServletResponse res) { // POST 요청 시 폼 데이터를 처리하는 메서드
        Map<String, Boolean> errors = new HashMap<>(); // 오류 정보를 담는 Map 객체 생성
        req.setAttribute("errors", errors); // 오류 정보를 request에 저장

        QuoteModifyRequest quoteModifyReq = createQuoteModifyRequest(req); // 요청 파라미터를 기반으로 QuoteModifyRequest 객체 생성
		/*
		 * quoteModifyReq.validate(errors); // quoteModifyReq 객체가 유효한지 검사
		 */
        if (!errors.isEmpty()) { // 만약 오류가 존재한다면, 폼을 다시 보여줍니다.
            return FORM_VIEW;
        }

        try {
            quoteModifyService.modifyQuote(quoteModifyReq); // 견적 수정 서비스 호출하여 데이터를 수정
            req.setAttribute("successMessage", "견적서가 성공적으로 수정되었습니다.");
            return "/WEB-INF/view/quoteModifySuccess.jsp"; // 성공적으로 견적이 수정되었을 때 응답 페이지
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "견적서 수정 중 오류가 발생했습니다.");
            return FORM_VIEW;
        }
    }

    private QuoteModifyRequest createQuoteModifyRequest(HttpServletRequest req) { // 요청에서 파라미터를 읽어 QuoteModifyRequest 객체를 생성하는 메서드

        java.util.Date validityPeriod = java.sql.Date.valueOf(req.getParameter("validityPeriod")); // 유효 기간을 java.util.Date 객체로 변환
        java.util.Date quoteDate = java.sql.Date.valueOf(req.getParameter("quoteDate")); // 일자를 java.util.Date 객체로 변환

        return new QuoteModifyRequest( // 요청에서 파라미터를 가져와서 QuoteModifyRequest 객체 생성
            Integer.parseInt(req.getParameter("quoteNo")),
            // req.getParameter("quoteID"),
            // req.getParameter("quoteNumber"),
            quoteDate, //일자
            req.getParameter("customerCode"), // 거래처명
            req.getParameter("employeeCode"), // 담당자명
            req.getParameter("productCode"), // 품목명
            validityPeriod, // 유효기간
            Double.parseDouble(req.getParameter("totalAmount")), // 견적금액합계
            req.getParameter("status"), // 진행상태
            req.getParameter("createdVoucher"), // 전표출력

            // 추가된 필드
            req.getParameter("warehouseCode"), // 출하 창고
            req.getParameter("transactionTypeCode"), // 거래 유형
            req.getParameter("exchangeRateCode"), // 통화
            req.getParameter("projectCode") // 프로젝트
        );
    }
}
