package controller;

import mvc.command.CommandHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * QuoteInputHandler 클래스는 견적서 입력 폼을 처리하는 핸들러입니다.
 */
public class UnorderedStatusHandler implements CommandHandler {

    private static final String INPUT_PAGE = "/views/unorderedStatus.jsp";

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        try {
            // Quote 입력 폼 처리를 위한 로직을 작성합니다.
        } catch (Exception e) {
            // 예외 처리: 로그를 기록하고 에러 페이지로 포워딩
            req.setAttribute("errorMessage", "견적서를 입력하는 동안 오류가 발생했습니다.");
            e.printStackTrace();
            return "/views/error.jsp";
        }
        return INPUT_PAGE;
    }
}