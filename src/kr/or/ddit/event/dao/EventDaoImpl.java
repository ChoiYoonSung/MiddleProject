package kr.or.ddit.event.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.event.service.IEventService;
import kr.or.ddit.event.vo.EventVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class EventDaoImpl implements IEventDao{

	private static IEventDao evnDao;
	
	private SqlMapClientUtil smc;
	
	private EventDaoImpl() {
	}
	
	public static IEventDao getInstance() {
		if(evnDao == null) {
			evnDao = new EventDaoImpl();
		}
		return evnDao;
	}

	@Override
	public int insertEvent(SqlMapClient smc, EventVO event) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("event.insertEvent", event);
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateQnABoard(SqlMapClient smc, EventVO event) throws SQLException {
		int cnt = (int)smc.update("event.updateEvent", event);
		return cnt;
	}

	@Override
	public int deleteEvnet(SqlMapClient smc, String boardSeq) throws SQLException {
		int cnt = (int)smc.delete("event.deleteEvent", boardSeq);
		return cnt;
	}

	@Override
	public List<EventVO> getAllEvnet(SqlMapClient smc) throws SQLException {
		List<EventVO> list = smc.queryForList("event.getAllEvent"); 
		return list;
	}

	@Override
	public EventVO selectEvent(SqlMapClient smc, String boardSeq) throws SQLException {
		int cnt = smc.update("event.countHitsEvent", boardSeq);
		
		EventVO event = (EventVO) smc.queryForObject("event.selectEvent", boardSeq);
		System.out.println(event);
		return event;
	}
	
	@Override
	public EventVO getEvent(SqlMapClient smc, String boardSeq) throws SQLException {
		EventVO event = (EventVO) smc.queryForObject("event.getEvent", boardSeq);
		return event;
	}

//	@Override
//	public int countHitsQnABoard(SqlMapClient smc, String boardSeq) throws SQLException {
//		return cnt;
//	}

}
