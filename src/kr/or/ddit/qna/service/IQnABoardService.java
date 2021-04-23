package kr.or.ddit.qna.service;

import java.util.List;

import kr.or.ddit.qna.vo.QnABoardVO;

public interface IQnABoardService {
	public int insertQnABoard(QnABoardVO qna);
	
	public int updateQnABoard(QnABoardVO qna);
	
	public int deleteQnABoard(QnABoardVO qna);
	
	public List<QnABoardVO> getAllQnABoard();
	
	public List<QnABoardVO> getQnABoard(QnABoardVO qna);
	
	public QnABoardVO getQnA(String boardSeq);
	
	public int countHitsQnABoard(String boardSeq);
}
