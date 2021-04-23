package kr.or.ddit.event.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.common.handler.CommandHandler;
import kr.or.ddit.common.service.AtchFileServiceImpl;
import kr.or.ddit.common.service.IAtchFileService;
import kr.or.ddit.common.vo.AtchFileVO;
import kr.or.ddit.event.service.EventServiceImpl;
import kr.or.ddit.event.service.IEventService;
import kr.or.ddit.event.vo.EventVO;

public class SelectEventHandler implements CommandHandler{
	private static final String VIEW_PAGE = "/WEB-INF/view/eventBoard/selectEvent.jsp";

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String boardSeq = req.getParameter("boardSeq");
		
		IEventService eventService = EventServiceImpl.getInstance();
		EventVO event = eventService.getEvent(boardSeq);
		
		BeanUtils.populate(event, req.getParameterMap());
		
		if(event.getAtchFileId() > 0) {
			AtchFileVO fileVO = new AtchFileVO();
			fileVO.setAtchFileId(event.getAtchFileId());
			
			IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
			List<AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
			
			req.setAttribute("atchFileList", atchFileList);
		}
		eventService.countHitsEvent(boardSeq);
		eventService.selectEvent(event);
		req.setAttribute("eventVO", event);
		return VIEW_PAGE;
	}

}
