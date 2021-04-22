package kr.or.ddit.commBoard.service;

import java.util.List;

import kr.or.ddit.commBoard.vo.CommBoardVO;

/**
 * 게시판 정보 처리를 수행하는 서비스
 * @author PC-08
 *
 */
public interface ICommBoardService {
	
	/**
	 * 게시판을 등록하는 메서드
	 * @param cv DB에 insert할 자료가 저장된 CommBoardVO객체
	 * @return 성공하면 1이상의 값. 실패하면 0 반환
	 */
	public int insertBoard(CommBoardVO cv);
	
	/**전체 게시판 조회 메서드
	 * 
	 * @return
	 */
	public List<CommBoardVO> getAllBoardList();
	
	
	/**게시판 정보를 수정하는 메서드 
	 * 
	 * @param cv
	 * @return
	 */
	public int updateBoard(CommBoardVO cv);
	/**
	 * 특정 유저의 게시판을 삭제하는 메서드 
	 * @param uerId
	 * @return
	 */
	public int deleteBoard(String userId);
	
	/**
	 * CommBoardVO 자료를 이용하여 회원을 검색하는 메서드
	 * @param cv
	 * @return
	 */
	public List<CommBoardVO> getSearchBoard(CommBoardVO cv);
	
	/**
	 * 주어진 ID에 해당하는 정보를 조회하는 메서드
	 * @param userId
	 * @return
	 */
	public CommBoardVO getBoard(String userId);
	
	
	
}
