package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

/*ShipmentInputHandler 클래스는 출하입력 폼을 처리하는 핸들러입니다.*/

public class ShipmentInputHandler implements CommandHandler {
	
	private static final String INPUT_PAGE = "/views/shipmentInput.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		try {
			//Shipment 입력 폼을 처리하기 위한 로직작성
		} catch(Exception e) {
			req.setAttribute("errorMessage", "출하를 작성하는 동안 에러가 발생했습니다.");
			e.printStackTrace();
			return "/views/error.jsp";
		}
		return INPUT_PAGE;
	}

}
