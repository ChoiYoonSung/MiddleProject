package kr.or.ddit.commBoard.vo;

import java.sql.Date;

public class CommBoardVO {

	private String code;
	private int boardSeqNum;
	private String userId;
	private String boardTitle;
	private Date boardDate;
	private String boardContent;
	private String atchFileId;
	private int boardHitsNumber;
	private String boardDelete;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getBoardSeqNum() {
		return boardSeqNum;
	}
	public void setBoardSeqNum(int boardSeqNum) {
		this.boardSeqNum = boardSeqNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}
	public int getBoardHitsNumber() {
		return boardHitsNumber;
	}
	public void setBoardHitsNumber(int boardHitsNumber) {
		this.boardHitsNumber = boardHitsNumber;
	}
	public String getBoardDelete() {
		return boardDelete;
	}
	public void setBoardDelete(String boardDelete) {
		this.boardDelete = boardDelete;
	}
	
	
}
