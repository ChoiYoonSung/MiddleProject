package kr.or.ddit.commBoard.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.commBoard.service.CommBoardServiceImpl;
import kr.or.ddit.commBoard.service.ICommBoardService;
import kr.or.ddit.commBoard.vo.CommBoardVO;
import kr.or.ddit.common.handler.CommandHandler;

public class DeleteCommBoardHandler implements CommandHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/commBoard/updateForm.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) { // GET 방식인 경우 redirect를 하지 않는다.
			return false;
		}else { // POST 방식인 경우
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if(req.getMethod().equals("GET")) {
		
			long boardSeq = Long.parseLong(req.getParameter("boardSeq"));
			
			ICommBoardService boardService = CommBoardServiceImpl.getInstance();
					
			CommBoardVO cv = boardService.getBoard(boardSeq);
			
			req.setAttribute("CommBoardVO", cv);
			
		return VIEW_PAGE;
		
		}else {
			
			long boardSeq = Long.parseLong(req.getParameter("boardSeq"));
			
			ICommBoardService boardService = CommBoardServiceImpl.getInstance();

			CommBoardVO cv = new CommBoardVO();
		
			cv.setBoardSeq(boardSeq);
		
		int cnt = boardService.deleteBoard(cv);
		
		String msg ="";
		
		if(cnt > 0) {
			msg ="성공";
		}else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/commBoard/list.do?msg" + URLEncoder.encode(msg, "UTF-8");
		return redirectUrl;
	}

	}
}
