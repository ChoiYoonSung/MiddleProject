package kr.or.ddit.comment.handler;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comment.service.CommentServiceImpl;
import kr.or.ddit.comment.service.ICommentService;
import kr.or.ddit.comment.vo.CommentVO;
import kr.or.ddit.common.handler.CommandHandler;

public class GetCommentListHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/common/comment.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		return false;
		
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String code = req.getParameter("code");
		long boardSeq = Long.parseLong(req.getParameter("boardSeq"));
		
		ICommentService service = CommentServiceImpl.getInstance();
		
		
		
		return VIEW_PAGE;
	}

}
