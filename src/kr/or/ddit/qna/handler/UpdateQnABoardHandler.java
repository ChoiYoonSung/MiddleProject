package kr.or.ddit.qna.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.common.handler.CommandHandler;
import kr.or.ddit.qna.service.IQnABoardService;
import kr.or.ddit.qna.service.QnABoardServiceImpl;
import kr.or.ddit.qna.vo.QnABoardVO;

public class UpdateQnABoardHandler implements CommandHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/qnaBoard/updateQnA.jsp";
	
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
			String boardSeq = req.getParameter("boardSeq");
			
			IQnABoardService qnaService = QnABoardServiceImpl.getInstance();
			QnABoardVO qna = qnaService.getQnA(boardSeq);
			
			req.setAttribute("qnaVO", qna);
			return VIEW_PAGE;
		}else {
			long boardSeq = Long.parseLong(req.getParameter("boardSeq"));
			String userId = req.getParameter("userId");				//ID
			String boardTitle = req.getParameter("boardTitle");		//제목
			String boardContent = req.getParameter("boardContent");	//내용
			String boardSecret = req.getParameter("boardSecret");	//비공개
			String boardPw = req.getParameter("boardPw");			//글비밀번호
			String atchFileId = req.getParameter("atchFileId");		//첨부파일ID
			
			IQnABoardService qnaService = QnABoardServiceImpl.getInstance();
			
			QnABoardVO qna = new QnABoardVO();
			qna.setBoardSeq(boardSeq);
			qna.setUserId(userId);
			qna.setBoardTitle(boardTitle);
			qna.setBoardContent(boardContent);
			qna.setBoardSecret(boardSecret);
			qna.setBoardPw(boardPw);
			qna.setAtchFileId(atchFileId);
			
			qnaService.updateQnABoard(qna);
			
			String redirectUrl = req.getContextPath() + "/qnaBoard/select.do?boardSeq=" + boardSeq;
			
			return redirectUrl;
		}
	}
}