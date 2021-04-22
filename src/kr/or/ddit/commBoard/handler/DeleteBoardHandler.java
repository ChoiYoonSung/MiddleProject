package kr.or.ddit.commBoard.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.commBoard.service.CommBoardServiceImpl;
import kr.or.ddit.commBoard.service.ICommBoardService;
import kr.or.ddit.common.handler.CommandHandler;

public class DeleteBoardHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String userId = req.getParameter("userId");
		
		ICommBoardService boardService = CommBoardServiceImpl.getInstance();
		
		int cnt = boardService.deleteBoard(userId);
		
		String msg ="";
		
		if(cnt > 0) {
			msg ="성공";
		}else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/board/list.do?msg" + URLEncoder.encode(msg, "UTF-8");
		
		
		return redirectUrl;
	}

}
