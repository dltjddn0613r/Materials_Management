package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.QuoteDeleteService;
import service.QuoteNotFoundException;

public class QuoteDeleteHandler implements CommandHandler {

    private static final String SUCCESS_VIEW = "/WEB-INF/view/quoteDeleteSuccess.jsp";
    private static final String FAIL_VIEW = "/WEB-INF/view/quoteDeleteFail.jsp";
    
    private QuoteDeleteService quoteDeleteService = new QuoteDeleteService(); // 견적서 삭제를 위한 비즈니스 로직을 처리하는 서비스 객체
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            return processDelete(req, res);   // 요청 메서드가 POST인 경우 삭제 작업을 진행
        } else {
            res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return null; // POST가 아닌 요청에 대해 405 Method Not Allowed 상태 코드 설정
        }
    }

    private String processDelete(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String[] quote_nos = req.getParameterValues("quote_no");// 요청 파라미터에서 선택된 견적서 번호를 배열로 가져옵니다.

        if (quote_nos == null || quote_nos.length == 0) {
            req.setAttribute("errorMessage", "삭제할 견적을 선택하세요.");
            return FAIL_VIEW;    // 선택된 견적서 번호가 없을 경우 실패 페이지를 반환하며 에러 메시지를 설정
        }

        List<Integer> quoteNoList = new ArrayList<>();     // 견적서 번호를 저장할 리스트 생성
        try {
            for (String no : quote_nos) {   // 문자열로 된 견적서 번호를 정수로 변환하여 리스트에 추가
                quoteNoList.add(Integer.parseInt(no));
            }

            quoteDeleteService.deleteQuotes(quoteNoList);    // 서비스 객체를 이용해 견적서 삭제 작업 수행

            return SUCCESS_VIEW;  // 삭제 성공 시 성공 페이지 경로 반환
        } catch (NumberFormatException e) {  // 견적서 번호 형식이 잘못된 경우 실패 페이지 반환 및 에러 메시지 설정
            req.setAttribute("errorMessage", "잘못된 번호 형식입니다.");
            return FAIL_VIEW;
        } catch (QuoteNotFoundException e) { // 견적서가 존재하지 않는 경우 실패 페이지 반환 및 에러 메시지 설정
            req.setAttribute("errorMessage", e.getMessage());
            return FAIL_VIEW;
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
