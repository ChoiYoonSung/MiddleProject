package kr.or.ddit.qna.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.qna.vo.QnABoardVO;

public interface IQnABoardDao {
	public int insertQnABoard(SqlMapClient smc, QnABoardVO qna) throws SQLException;
		
	public int updateQnABoard(SqlMapClient smc, QnABoardVO qna)throws SQLException;;
	
	public int deleteQnABoard(SqlMapClient smc, QnABoardVO qna)throws SQLException;
	
	public List<QnABoardVO> getAllQnABoard(SqlMapClient smc) throws SQLException;
	
	public List<QnABoardVO> getQnABoard(SqlMapClient smc, QnABoardVO qna)throws SQLException;
	
	public QnABoardVO getQnA(SqlMapClient smc, String userId) throws SQLException;
	
}
