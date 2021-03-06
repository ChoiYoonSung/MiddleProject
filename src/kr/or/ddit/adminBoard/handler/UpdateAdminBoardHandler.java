package kr.or.ddit.adminBoard.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.adminBoard.service.AdminBoardServiceImpl;
import kr.or.ddit.adminBoard.service.IAdminBoardService;
import kr.or.ddit.adminBoard.vo.AdminBoardVO;
import kr.or.ddit.common.handler.CommandHandler;

public class UpdateAdminBoardHandler implements CommandHandler{
	private static final String VIEW_PAGE = "";
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
		if(req.getMethod().equals("GET")) { // GET 방식인 경우 redirect를 하지 않는다.
			long boardSeq = Long.parseLong(req.getParameter("boardSeq"));
			
			//서비스 객체 생성
			IAdminBoardService adminBoardService = AdminBoardServiceImpl.getInstance();
			
			AdminBoardVO abv = adminBoardService.getAdminBoard(boardSeq);
			
			//정보등록
			req.setAttribute("adminBoardVO", abv);
			return VIEW_PAGE;
		}else { // POST 방식인 경우
			
			//요청 파라미터 정보 가져오기
			String userId = req.getParameter("userId");
			String boardTitle = req.getParameter("boardTitle");
			String boardContent = req.getParameter("boardContent");
			
			//서비스 객체 생성
			IAdminBoardService adminBoardService = AdminBoardServiceImpl.getInstance();
			
			//게시글 등록하기
			AdminBoardVO abv = new AdminBoardVO();
			abv.setUserId(userId);
			abv.setBoardTitle(boardTitle);
			abv.setBoardContent(boardContent);
//			abv.setAtchFileId(atchFileId);
			
			int cnt = adminBoardService.updateAdminBoard(abv);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			//목록조회 화면으로 이동
			String redirectUrl = req.getContextPath() + "adminBoard/get.do?msg=" + URLEncoder.encode(msg,"UTF-8");
			return redirectUrl;
		}
	}

}
