package kr.or.ddit.partyBoard.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.handler.CommandHandler;
import kr.or.ddit.partyBoard.service.IPartyBoardService;
import kr.or.ddit.partyBoard.service.PartyBoardServiceImpl;
import kr.or.ddit.partyBoard.vo.PartyBoardVO;
import kr.or.ddit.partyJoin.service.IPartyJoinService;
import kr.or.ddit.partyJoin.service.PartyJoinServiceImpl;
import kr.or.ddit.partyJoin.vo.PartyJoinVO;

public class InsertPartyHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/partyBoard/insertForm.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
		}else {
			
			IPartyBoardService service = PartyBoardServiceImpl.getInstance();
			PartyBoardVO pv = new PartyBoardVO();
			
			pv.setCode(req.getParameter("code"));
			pv.setUserId(req.getParameter("userId"));
			pv.setBoardTitle(req.getParameter("boardTitle"));
			pv.setBoardContent(req.getParameter("boardContent"));
			pv.setRestCode(req.getParameter("restCode"));
			pv.setPrice(req.getParameter("price"));
			pv.setDistance(req.getParameter("distance"));
			pv.setPartyEnd(req.getParameter("partyEnd"));
			pv.setRestType(req.getParameter("restType"));
			pv.setUserProfile(req.getParameter("userProfile"));
			
			service.insertPartyBoard(pv);			
			
			return req.getContextPath() + "/PARTY/main.do";
		}
	}

}
