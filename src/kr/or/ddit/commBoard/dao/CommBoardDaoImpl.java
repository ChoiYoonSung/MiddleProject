package kr.or.ddit.commBoard.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.commBoard.vo.CommBoardVO;
import kr.or.ddit.common.vo.PagingVO;

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
		
		Object obj = smc.insert("commBoard.insertBoard", cv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<CommBoardVO> getAllBoardList(SqlMapClient smc, PagingVO pagingVO) throws SQLException {
		
		System.out.println("가기전에 이것");
		
		System.out.println(pagingVO.getFirstRecNo());
		
		List<CommBoardVO> boardList = smc.queryForList("commBoard.getAllBoardList", pagingVO);
		
		System.out.println("갔다와서 이것");
		
		System.out.println(pagingVO.getFirstRecNo());
		
		
		return boardList;
	}
	
	@Override
	public int getAllBoardListCount(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("commBoard.getBoardAllCount");
		return cnt;
	}
	
	@Override
	public int updateBoard(SqlMapClient smc, CommBoardVO cv) throws SQLException {
		
		int cnt = 0;
		
		cnt = smc.update("commBoard.updateBoard", cv);
		
		return cnt;
	}

	@Override
	public int deleteBoard(SqlMapClient smc, CommBoardVO cv) throws SQLException {

		int cnt = smc.delete("commBoard.deleteBoard", cv);
		
		return cnt;
	}

	@Override
	public List<CommBoardVO> getSearchBoard(SqlMapClient smc, CommBoardVO cv) throws SQLException {
			
		List<CommBoardVO> boardList = smc.queryForList("commBoard.getSearchBoard", cv);
		
		return boardList;
	}

	@Override
	public CommBoardVO getBoard(SqlMapClient smc, long boardSeq) throws SQLException {
		CommBoardVO cv = (CommBoardVO)smc.queryForObject("commBoard.getBoard", boardSeq);
	
		return cv;
	}



}
