package kr.or.ddit.commBoard.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.commBoard.vo.CommBoardVO;

public class CommBoardDaoImpl implements ICommBoardDao{

	private static ICommBoardDao commDao;
	
	private CommBoardDaoImpl() {
		
	}
	
	public static ICommBoardDao getInstance() {
		if(commDao == null) {
			commDao = new CommBoardDaoImpl();
		}
		return commDao;
	}
	
	@Override
	public int insertBoard(SqlMapClient smc, CommBoardVO cv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("commBoard.inserBoard", cv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<CommBoardVO> GetAllBoardList(SqlMapClient smc) throws SQLException {
		
		List<CommBoardVO> boardList = smc.queryForList("commBoard.getAllBoardList");
		
		return boardList;
	}

	@Override
	public int updateBoard(SqlMapClient smc, CommBoardVO cv) throws SQLException {
		
		int cnt = 0;
		
		cnt = smc.update("commBoard.updateBoard", cv);
		
		return cnt;
	}

	@Override
	public int deleteBoard(SqlMapClient smc, String userId) throws SQLException {

		int cnt = smc.delete("commBoard.deleteBoard", userId);
		
		return cnt;
	}

	@Override
	public List<CommBoardVO> getSearchBoard(SqlMapClient smc, CommBoardVO cv) throws SQLException {
			
		List<CommBoardVO> boardList = smc.queryForList("commBoard.getSearchBoard", cv);
		
		return boardList;
	}

	@Override
	public CommBoardVO getBoard(SqlMapClient smc, String userId) throws SQLException {

		CommBoardVO cv = (CommBoardVO)smc.queryForObject("commBoard.getBoardInfo", userId); 
		
		return cv;
	}

}
