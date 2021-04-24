package kr.or.ddit.commBoard.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.commBoard.service.CommBoardServiceImpl;
import kr.or.ddit.commBoard.service.ICommBoardService;
import kr.or.ddit.commBoard.vo.CommBoardVO;
import kr.or.ddit.common.handler.CommandHandler;
import kr.or.ddit.common.service.AtchFileServiceImpl;
import kr.or.ddit.common.service.IAtchFileService;
import kr.or.ddit.common.vo.AtchFileVO;

public class GetCommBoardHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/commBoard/select.jsp";

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Long boardSeq= Long.parseLong(req.getParameter("boardSeq"));
		
		ICommBoardService boardService = CommBoardServiceImpl.getInstance();
		
		CommBoardVO cv= boardService.getBoard(boardSeq);
		
		req.setAttribute("boardVO", cv);
		
		return VIEW_PAGE;
	}
	
	
	
	
}
