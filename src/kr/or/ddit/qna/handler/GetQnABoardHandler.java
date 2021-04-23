package kr.or.ddit.qna.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.common.handler.CommandHandler;
import kr.or.ddit.qna.service.IQnABoardService;
import kr.or.ddit.qna.service.QnABoardServiceImpl;
import kr.or.ddit.qna.vo.QnABoardVO;

public class GetQnABoardHandler implements CommandHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/qnaBoard/selectQnA.jsp";
	@Override
	public boolean isRedirect(HttpServletRequest req) {
			return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String boardSeq = req.getParameter("boardSeq");
		
		IQnABoardService qnaService = QnABoardServiceImpl.getInstance();
		QnABoardVO qna = qnaService.getQnA(boardSeq);
		
		BeanUtils.populate(qna, req.getParameterMap());
		
		qnaService.getQnABoard(qna);
		req.setAttribute("qnaVO", qna);
		return VIEW_PAGE;
	}

}
