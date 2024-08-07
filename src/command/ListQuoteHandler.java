package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.ListQuoteService;
import service.QuotePage;

public class ListQuoteHandler implements CommandHandler{
	private ListQuoteService listQuoteService = new ListQuoteService();// 견적서 목록 가져오기
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)throws Exception{
		String pageNoVal = req.getParameter("pageNo"); //pageNo 파라미터 값을 이용해서 읽어올 페이지 번호를 구한다.
		int pageNo=1; // 페이지 번호의 기본값을 1로 설정합니다.
		if(pageNoVal !=null) {  // "pageNo" 파라미터가 null이 아니면, 이를 정수로 변환하여 현재 페이지 번호로 사용합니다.
			pageNo = Integer.parseInt(pageNoVal); // 문자열을 정수로 변환
		}
		QuotePage quotePage = listQuoteService.getQuotePage(pageNo); //ListQuoteHandler를 이용해서 지정한 페이지 번호에 해당하는 데이터를 구한다.
		req.setAttribute("quotePage", quotePage); //QuotePage 객체를 jsp에서 사용할 수 있도록 request의 quotePage 속성에 저장
		return "/WEB-INF/view/listQuote.jsp"; // 견적서 목록을 렌더링할 JSP 페이지 경로를 반환합니다.
		
	}

}
