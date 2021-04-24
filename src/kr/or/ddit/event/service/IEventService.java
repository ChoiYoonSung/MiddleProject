package kr.or.ddit.event.service;

import java.util.List;

import kr.or.ddit.event.vo.EventVO;

public interface IEventService{
	public int insertEvent(EventVO event);
	
	public int updateEvent(EventVO event);
	
	public int deleteEvent(String boardSeq);
	
	public List<EventVO> getAllEvent();
	
	public EventVO selectEvent(String boardSeq);
	
	public EventVO getEvent(String boardSeq);
	
//	public int countHitsEvent(String boardSeq);
	
}
