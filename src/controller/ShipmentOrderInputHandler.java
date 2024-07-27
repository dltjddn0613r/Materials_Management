package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

/*	ShipmentOrderInputHandler 클래스는 출하지시서입력 폼을 처리하는 핸들어입니다.*/

public class ShipmentOrderInputHandler implements CommandHandler {
		private static final String INPUT_PAGE = "/views/shipmentOrderInput.jsp";

		@Override
		public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
			try {
				// ShipmentOrder 입력 폼을 처리하기 위한 로직 작성
			} catch (Exception e) {
				// 예외처리: 로그를 기록하고 에러 페이로 포워딩
				req.setAttribute("errorMessage", "출하지시서를 작성하는 동안 에러가 발생했습니다.");
				e.printStackTrace();
				return "/views/error.jsp";
			}
			return INPUT_PAGE;
		}
		
}
