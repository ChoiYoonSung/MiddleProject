package kr.or.ddit.qna.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.common.handler.CommandHandler;
import kr.or.ddit.qna.service.IQnABoardService;
import kr.or.ddit.qna.service.QnABoardServiceImpl;
import kr.or.ddit.qna.vo.QnABoardVO;

public class UpdateQnABoardHandler implements CommandHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/updateQnA.jsp";
	
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
			String userId = req.getParameter("userId");
			
			IQnABoardService qnaService = QnABoardServiceImpl.getInstance();
			QnABoardVO qna = qnaService.getQnA(userId);
			
			req.setAttribute("qnaVO", qna);
			return VIEW_PAGE;
		}else {
			String userId = req.getParameter("userId");				//ID
			String boardType = req.getParameter("boardType");		//유형
			String boardTitle = req.getParameter("boardTitle");		//제목
			String boardContent = req.getParameter("boardContent");	//내용
			String boardSecret = req.getParameter("boardSecret");	//비공개
			String boardPw = req.getParameter("boardPw");			//글비밀번호
			String atchFileId = req.getParameter("atchFileId");		//첨부파일ID
			
			IQnABoardService qnaService = QnABoardServiceImpl.getInstance();
			
			QnABoardVO qna = new QnABoardVO();
			BeanUtils.populate(qna, req.getParameterMap());
			
			int cnt = qnaService.updateQnABoard(qna);
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
}