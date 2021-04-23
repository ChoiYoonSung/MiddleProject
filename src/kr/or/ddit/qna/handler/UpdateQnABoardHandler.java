package kr.or.ddit.qna.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.common.handler.CommandHandler;
import kr.or.ddit.common.service.AtchFileServiceImpl;
import kr.or.ddit.common.service.IAtchFileService;
import kr.or.ddit.common.vo.AtchFileVO;
import kr.or.ddit.qna.service.IQnABoardService;
import kr.or.ddit.qna.service.QnABoardServiceImpl;
import kr.or.ddit.qna.vo.QnABoardVO;
import kr.or.ddit.util.FileUploadRequestWrapper;

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
			
			if(qna.getAtchFileId() > 0) { //첨부파일이 존재하면
		         //첨부파일 정보 조회
		         AtchFileVO fileVO = new AtchFileVO();
		         fileVO.setAtchFileId(qna.getAtchFileId());
		         
		         IAtchFileService atchFileService= AtchFileServiceImpl.getInstance();
		         List<AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
		         
		         req.setAttribute("atchFileList", atchFileList);
		         
		      }
			
			req.setAttribute("qnaVO", qna);
			return VIEW_PAGE;
		}else {
			// FileItem 추출
			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
			
			AtchFileVO atchFileVO = new AtchFileVO();
			
			// 기존의 첨부파일아이디 정보 가져오기
			atchFileVO.setAtchFileId(req.getParameter("atchFile") == null ? -1
					: Long.parseLong(req.getParameter("atchFile")));
			
			if(item != null && item.getName().equals("")) {
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				atchFileVO = fileService.saveAtchFile(item);	// 첨부파일 저장
			}
						
			long boardSeq = Long.parseLong(req.getParameter("boardSeq"));
			String userId = req.getParameter("userId");				//ID
			String boardTitle = req.getParameter("boardTitle");		//제목
			String boardContent = req.getParameter("boardContent");	//내용
			String boardSecret = req.getParameter("boardSecret");	//비공개
			String boardPw = req.getParameter("boardPw");			//글비밀번호
			
			IQnABoardService qnaService = QnABoardServiceImpl.getInstance();
			
			QnABoardVO qna = new QnABoardVO();
			qna.setBoardSeq(boardSeq);
			qna.setUserId(userId);
			qna.setBoardTitle(boardTitle);
			qna.setBoardContent(boardContent);
			qna.setBoardSecret((qna.getBoardSecret()==null)?"N":qna.getBoardSecret());
			qna.setBoardPw(("".equals(qna.getBoardPw()))?"N":qna.getBoardPw());
			qna.setAtchFileId(atchFileVO.getAtchFileId());
			
			qnaService.updateQnABoard(qna);
			
			String redirectUrl = req.getContextPath() + "/qnaBoard/select.do?boardSeq=" + boardSeq;
			
			return redirectUrl;
		}
	}
}