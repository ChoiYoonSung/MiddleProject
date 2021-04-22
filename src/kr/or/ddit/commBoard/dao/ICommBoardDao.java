package kr.or.ddit.commBoard.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.commBoard.vo.CommBoardVO;


/**
 * DB와 연결해서 SQL문을 수행, 결과작성, service 전달 dao 인터페이스
 * @author PC-08
 *
 */
public interface ICommBoardDao {
	
	/**
	 * CommBoardVO 객체에 담긴 자료를 DB에 insert 하는 메서드.
	 * @param smc SQLMapClient객체.
	 * @param cv DB에  insert할 자료가 저장된 CommBoardVO객체.
	 * @return DB작업 성공시 1이상의 값이 반환되고, 실패하면 0 반환.
	 * @throws SQLException JDBC 예외 발생시 처리.
	 */
	public int insertBoard(SqlMapClient smc, CommBoardVO cv) throws SQLException;
	/**
	 * CommBoard 테이블의 전체 레코드를 가져와 List에 담아 반환하는 메서드. 
	 * @param smc
	 * @param cv
	 * @return 게시판 정보를 담는 List객체
	 * @throws SQLException
	 */
	public List<CommBoardVO> GetAllBoardList(SqlMapClient smc) throws SQLException;
	
	/**
	 * 게시판 정보 DB를 update하는 메서드
	 * @param smc
	 * @param cv
	 * @return 작업성공 1, 실패 0
	 * @throws SQLException
	 */
	public int updateBoard(SqlMapClient smc, CommBoardVO cv) throws SQLException;
	
	/**
	 * userId를 받아서 게시물을 삭제하는 메서드
	 * @param smc
	 * @param cv
	 * @return 작업성공 1, 실패 0
	 * @throws SQLException
	 */
	public int deleteBoard(SqlMapClient smc, String userId) throws SQLException;
	
	/**
	 * CommBoardVO 객체에 담긴 자료를 이용하여 게시물을 검색하는 메서드
	 * @param smc
	 * @param cv
	 * @return 검색결과를 담은 List
	 * @throws SQLException
	 */
	public List<CommBoardVO> getSearchBoard(SqlMapClient smc, CommBoardVO cv) throws SQLException;
	/**
	 * Id에 대응하는 회원정보 조회 메서드
	 * @param smc
	 * @param cv
	 * @return
	 * @throws SQLException
	 */
	public CommBoardVO getBoard(SqlMapClient smc, String userId) throws SQLException;
	
	
}
