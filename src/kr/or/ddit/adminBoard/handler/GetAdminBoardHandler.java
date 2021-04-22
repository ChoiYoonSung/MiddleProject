package kr.or.ddit.adminBoard.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.adminBoard.service.AdminBoardServiceImpl;
import kr.or.ddit.adminBoard.service.IAdminBoardService;
import kr.or.ddit.adminBoard.vo.AdminBoardVO;
import kr.or.ddit.common.handler.CommandHandler;

public class GetAdminBoardHandler implements CommandHandler{
private static final String VIEW_PAGE = "";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		long boardSeq = Long.parseLong(req.getParameter("boardSeq"));//사용자 정보를 화면에 뿌려주기 위함
		
		
		
		//회원 정보 조회
		IAdminBoardService boardService = AdminBoardServiceImpl.getInstance();
		
		AdminBoardVO abv = boardService.getAdminBoard(boardSeq);
		
//		if(mv.getAtchFileId() > 0) { //첨부파일 존재하면...
//			//첨부파일 정보 조회
//			AtchFileVO fileVO = new AtchFileVO();
//			fileVO.setAtchFileId(mv.getAtchFileId());
//			
//			IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
//			List<AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
//			
//			req.setAttribute("atchFileList", atchFileList);
//			
//		}
		
		req.setAttribute("AdminBoardVO", abv);
		return VIEW_PAGE;
	}
}
