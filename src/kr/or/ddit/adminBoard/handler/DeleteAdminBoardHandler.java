package kr.or.ddit.adminBoard.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.adminBoard.service.AdminBoardServiceImpl;
import kr.or.ddit.adminBoard.service.IAdminBoardService;
import kr.or.ddit.adminBoard.vo.AdminBoardVO;
import kr.or.ddit.common.handler.CommandHandler;

public class DeleteAdminBoardHandler implements CommandHandler{

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
			
			IAdminBoardService boardService = AdminBoardServiceImpl.getInstance();
			
			AdminBoardVO abv = boardService.getAdminBoard(boardSeq);
			
			//정보등록
			req.setAttribute("AdminBoardVO", abv);
			return VIEW_PAGE;
		}else { // POST 방식인 경우
			//1. 요청 파라미터 정보 가져오기
			String boardDelete = req.getParameter("boardDelete");
			
			//2.서비스 객체 생성
			IAdminBoardService boardService = AdminBoardServiceImpl.getInstance();
			
			//3. 정보 등록
			AdminBoardVO abv = new AdminBoardVO();
			abv.setBoardDelete(boardDelete);
			
			int cnt = boardService.deleteAdminBoard(abv);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			} else {
				msg = "실패";
			}
			
			//화면 이동
			String redirectUrl = req.getContextPath() + "adminBoard/getAll.do?msg=" + URLEncoder.encode(msg,"UTF-8");
			return redirectUrl;
		}
	}

}
