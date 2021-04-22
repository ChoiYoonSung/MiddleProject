package kr.or.ddit.common.dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.common.vo.AtchFileVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class AtchFileDaoImpl implements IAtchFileDao {
	private static IAtchFileDao dao;
	private SqlMapClient smc;

	private AtchFileDaoImpl() {
		smc = SqlMapClientUtil.getInstance();
	}

	public static IAtchFileDao getInstance() {
		if(dao == null) {
			dao = new AtchFileDaoImpl();
		}

		return dao;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO fileVO) throws SQLException {

		List<AtchFileVO> atchFileList = Collections.EMPTY_LIST; //immutable? 변경불가 리스트
		//static final 느낌이다. 
		atchFileList = smc.queryForList("atchFile.getAtchFileList", fileVO);

		return atchFileList;
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO fileVO) throws SQLException {
		AtchFileVO atchFileVO = (AtchFileVO) smc.queryForObject("atchFile.getAtchFileDetail", fileVO);
		return atchFileVO;
	}

	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) throws SQLException {

		int cnt = 0;

		Object obj = smc.insert("atchFile.insertAtchFile", atchFileVO);

		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int insertAtchFileDetail(AtchFileVO atchFileVO) throws SQLException {

		int cnt = 0;

		Object obj = smc.insert("atchFile.insertAtchFileDetail", atchFileVO);

		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

}