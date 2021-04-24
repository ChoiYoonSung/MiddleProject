package kr.or.ddit.event.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.handler.CommandHandler;
import kr.or.ddit.event.service.EventServiceImpl;
import kr.or.ddit.event.service.IEventService;
import kr.or.ddit.event.vo.EventVO;

public class ListEventHandler implements CommandHandler{
	private static final String VIEW_PAGE = "/WEB-INF/view/eventBoard/listEvent.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IEventService eventService = EventServiceImpl.getInstance();
		
		List<EventVO> eventList = eventService.getAllEvent();
		
		req.setAttribute("eventList", eventList);
		
		return VIEW_PAGE;
	}
}
