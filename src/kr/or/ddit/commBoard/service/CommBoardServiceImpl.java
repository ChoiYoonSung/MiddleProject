package kr.or.ddit.commBoard.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.commBoard.dao.CommBoardDaoImpl;
import kr.or.ddit.commBoard.dao.ICommBoardDao;
import kr.or.ddit.commBoard.vo.CommBoardVO;
import kr.or.ddit.common.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class CommBoardServiceImpl implements ICommBoardService{

	private ICommBoardDao boardDao;
	private SqlMapClient smc;
	
	private static ICommBoardService service;
	
	private CommBoardServiceImpl() {
		boardDao = CommBoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static ICommBoardService getInstance() {
		if(service == null) {
			service = new CommBoardServiceImpl();
		}
		return service;
		
	}
	
	@Override
	public int insertBoard(CommBoardVO cv) {
		
		int cnt =0;
		
		try {
			cnt = boardDao.insertBoard(smc, cv);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<CommBoardVO> getAllBoardList(PagingVO pagingVO) {

		List<CommBoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = boardDao.getAllBoardList(smc, pagingVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	@Override
	public int getAllBoardListCount() {
		int cnt = 0;
		try {
			cnt = boardDao.getAllBoardListCount(smc);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateBoard(CommBoardVO cv) {
		int cnt = 0;
		try {
			cnt = boardDao.updateBoard(smc, cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(CommBoardVO cv) {
		int cnt = 0;
		
		try {
			cnt = boardDao.deleteBoard(smc, cv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return cnt;
	}

	@Override
	public List<CommBoardVO> getSearchBoard(CommBoardVO cv) {
		
		List<CommBoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = boardDao.getSearchBoard(smc, cv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}

	@Override
	public CommBoardVO getBoard(long boardSeq) {
		CommBoardVO cv = null;
		
		try {
			cv = boardDao.getBoard(smc, boardSeq);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cv;
	}


}
