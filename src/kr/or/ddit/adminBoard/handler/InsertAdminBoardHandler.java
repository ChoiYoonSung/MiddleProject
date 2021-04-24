package kr.or.ddit.adminBoard.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.adminBoard.service.AdminBoardServiceImpl;
import kr.or.ddit.adminBoard.service.IAdminBoardService;
import kr.or.ddit.adminBoard.vo.AdminBoardVO;
import kr.or.ddit.common.handler.CommandHandler;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class InsertAdminBoardHandler implements CommandHandler{
	
	private static String VIEW_PAGE = "";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {//get방식
			return false;
		}else {//post방식
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	if("notice".equals(req.getParameter("code"))) {
		VIEW_PAGE = "/WEB-INF/view/adminBoard/noticeInsert.jsp";
	} else {
		VIEW_PAGE = "/WEB-INF/view/adminBoard/faqInsert.jsp";
	}
		if(req.getMethod().equals("GET")) { //get방식인 경우 isRedirect X
			return VIEW_PAGE;
		}else {//post방식인 경우 isRedirect O
//			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("");
			
			//요청 파라미터 정보 가져오기
//			String code = req.getParameter("code");
			String userId = req.getParameter("userId");
			String boardTitle = req.getParameter("boardTitle");
			String boardContent = req.getParameter("boardContent");
			
			//서비스 객체 생성
			IAdminBoardService adminBoardService = AdminBoardServiceImpl.getInstance();
			
			//게시글 등록하기
			AdminBoardVO abv = new AdminBoardVO();
//			abv.setCode(code);
			abv.setUserId(userId);
			abv.setBoardTitle(boardTitle);
			abv.setBoardContent(boardContent);
//			abv.setAtchFileId(atchFileId);
			
			int cnt = adminBoardService.insertAdminBoard(abv);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			//목록조회 화면으로 이동
			String redirectUrl = req.getContextPath() + "/adminBoard/getAll.do?msg=" + URLEncoder.encode(msg,"UTF-8");
			return redirectUrl;
		}
	}
}