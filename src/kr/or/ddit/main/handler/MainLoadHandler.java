package kr.or.ddit.main.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.common.handler.CommandHandler;

public class MainLoadHandler implements CommandHandler {
	private static final String VIEW_PAGE = "/WEB-INF/view/login/main.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		/** 회원 세션이 존재하는지 확인 */
		HttpSession session = req.getSession(true); // 세션 생성
		String visitFlag = ""; // true : 기존 방문 이력이 있음, false : 방문 이력이 없음
		
		if(session.isNew()) { // 새로 만든 세션이라면 
			visitFlag = "FALSE";
			System.out.println("★★★★★"+visitFlag);
		} else {
			visitFlag = "TRUE";
			System.out.println("★★★★★★"+visitFlag);
		}
		
		session.setAttribute("VISITFLAG", visitFlag);
		
		return VIEW_PAGE;
	}

}
