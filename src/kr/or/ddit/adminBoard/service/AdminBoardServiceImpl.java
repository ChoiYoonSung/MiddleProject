package kr.or.ddit.adminBoard.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.adminBoard.dao.AdminBoardDaoImpl;
import kr.or.ddit.adminBoard.dao.IAdminBoardDao;
import kr.or.ddit.adminBoard.vo.AdminBoardVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class AdminBoardServiceImpl implements IAdminBoardService{
	//사용할 DAO의 객체 변수 선언
	private IAdminBoardDao adminBdao;
	private SqlMapClient smc;
	
	private static IAdminBoardService service;
	
	private AdminBoardServiceImpl() {
		adminBdao = AdminBoardDaoImpl.getinstance();
			smc = SqlMapClientUtil.getInstance();
	}
	
	public static IAdminBoardService getInstance() {
		if(service == null) {
			service = new AdminBoardServiceImpl();
		}
		return service;
	}

	@Override
	public int insertAdminBoard(AdminBoardVO abv) {
		int cnt = 0;
		
		try {
			cnt = adminBdao.insertAdminBoard(smc, abv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public boolean checkAdminBoard(long boardSeq) {
		boolean chk = false;
		
		try {
			chk = adminBdao.checkAdminBoard(smc, boardSeq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public List<AdminBoardVO> getAllAdminBoardList() {
		List<AdminBoardVO> boardList = new ArrayList<AdminBoardVO>();
		try {
			boardList = adminBdao.getAllAdminBoardList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int updateAdminBoard(AdminBoardVO abv) {
		int cnt = 0;
		try {
			cnt = adminBdao.updateAdminBoard(smc, abv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteAdminBoard(AdminBoardVO abv) {
		int cnt = 0;
		try {
			cnt = adminBdao.deleteAdminBoard(smc, abv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<AdminBoardVO> getSearchAdminBoard(AdminBoardVO abv) {
		List<AdminBoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = adminBdao.getSearchAdminBoard(smc, abv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public AdminBoardVO getAdminBoard(long boardSeq) {
		AdminBoardVO abv = null;
		
		try {
			abv = adminBdao.getAdminBoard(smc, boardSeq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return abv;
	}
}
