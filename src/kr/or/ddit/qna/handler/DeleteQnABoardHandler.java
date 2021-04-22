package kr.or.ddit.qna.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.common.handler.CommandHandler;
import kr.or.ddit.qna.service.IQnABoardService;
import kr.or.ddit.qna.service.QnABoardServiceImpl;
import kr.or.ddit.qna.vo.QnABoardVO;

public class DeleteQnABoardHandler implements CommandHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/qna/deleteQnA.jsp";
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		IQnABoardService qnaService = QnABoardServiceImpl.getInstance();
		QnABoardVO qna = new QnABoardVO();
		BeanUtils.populate(qna, req.getParameterMap());
		
		int cnt = qnaService.deleteQnABoard(qna);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/qna/listQnA.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		return redirectUrl;
	}
}
