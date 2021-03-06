package kr.or.ddit.groupCode.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.groupCode.vo.GroupCodeInfoVO;


/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 서비스에 전달하는 DAO 인터페이스
 */
public interface IGroupCodeInfoDao {
	
	/**
	 * 그룹코드 추가
	 * GroupCodeInfoVO 객체에 담겨진 자료를 DB에 insert하는 메서드
	 * @param smc SqlMapClient
	 * @param gv DB에 insert할 자료가 저장된 GroupCodeInfoVO객체
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고, 실패하면 0이 반환된다. 
	 * @throws SQLException JDBC관련 예외객체 발생
	 */
	public int insertGroupCode(SqlMapClient smc, GroupCodeInfoVO gv) throws SQLException; 
	
	/**
	 * 그룹코드 수정
	 * 하나의 그룹코드를 이용하여 DB를 update하는 메서드
	 * @param smc SqlMapClient
	 * @param gv 그룹코드
	 * @return 작업성공: 1, 작업실패: 0
	 * @throws SQLException JDBC 예외객체
	 */
	public int updateGroupCode(SqlMapClient smc, GroupCodeInfoVO gv) throws SQLException;
	
	/**
	 * 그룹코드 삭제
	 * 그룹코드를 매개변수로 받아서 그 그룹코드를 삭제하는 메서드
	 * @param smc SqlMapClient
	 * @param groupCode 삭제할 그룹코드
	 * @return 작업성공: 1, 작업실패: 0
	 * @throws SQLException JDBC관련 예외객체
	 */
	public int deleteGroupCode(SqlMapClient smc, String groupCode) throws SQLException;
	
	/**
	 * 전체 그룹코드 조회
	 * DB의 GroupCode테이블의 전체 레코드를 가져와서 List에 담아 반환하는 메서드
	 * @param smc SqlMapClient
	 * @return 그룹코드정보를 담고있는 List객체
	 * @throws SQLException JDBC관련 예외객체
	 */
	public List<GroupCodeInfoVO> getAllGroupCodeList(SqlMapClient smc) throws SQLException;

	/**
	 * 그룹코드정보 조회
	 * 주어진 그룹코드에 해당하는 그룹코드정보를 조회하는 메서드
	 * @param smc SqlMapClient
	 * @param groupCode 검색할 그룹코드
	 * @return
	 */
	public GroupCodeInfoVO getGroupCode(SqlMapClient smc, String groupCode) throws SQLException;
	
}
