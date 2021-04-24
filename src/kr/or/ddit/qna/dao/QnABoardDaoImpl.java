package kr.or.ddit.qna.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.qna.vo.QnABoardVO;

public class QnABoardDaoImpl implements IQnABoardDao{
	private static IQnABoardDao qnaDao;
	
	private SqlMapClient smc;
	
	private QnABoardDaoImpl() {
	}
	
	public static IQnABoardDao getInstance() {
		if(qnaDao == null) {
			qnaDao = new QnABoardDaoImpl();
		}
		return qnaDao;
	}
	
	@Override
	public int insertQnABoard(SqlMapClient smc, QnABoardVO qna) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("qna.insertQnABoard", qna);
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateQnABoard(SqlMapClient smc, QnABoardVO qna) throws SQLException {
		int cnt = (int)smc.update("qna.updateQnABoard", qna);
		return cnt;
	}

	@Override
	public int deleteQnABoard(SqlMapClient smc, QnABoardVO qna) throws SQLException {
		int cnt = (int)smc.delete("qna.deleteQnABoard", qna);
		return cnt;
	}
	

	@Override
	public List<QnABoardVO> getAllQnABoard(SqlMapClient smc) throws SQLException {
		List<QnABoardVO> list = smc.queryForList("qna.getAllQnABoard");
		return list;
	}
	
	@Override
	public List<QnABoardVO> getQnABoard(SqlMapClient smc, QnABoardVO qna) throws SQLException {
		List<QnABoardVO> list = smc.queryForList("qna.getQnABoard", qna);
		return list;
	}

	@Override
	public QnABoardVO getQnA(SqlMapClient smc, String boardSeq) throws SQLException {
		QnABoardVO qna = (QnABoardVO) smc.queryForObject("qna.getQnA", boardSeq);
		return qna;
	}

	@Override
	public int countHitsQnABoard(SqlMapClient smc, String boardSeq) throws SQLException {
		int cnt = (int)smc.update("qna.countHitsQnABoard", boardSeq);
		return cnt;
	}
	
}
