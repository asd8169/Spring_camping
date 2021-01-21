package com.jsplec.bbs.dto;

import java.sql.Timestamp;

public class CQnaDto {

	int userNo;
	int pNo;
	int qnaNo;
	String qnaSecret;
	String pName;
	String qnaTitle;
	String qnauserId;
	String qnaContent;
	String qnaDate;
	String qnaComment;

	public CQnaDto() {
	}

	public String getQnauserId() {
		return qnauserId;
	}

	public void setQnauserId(String qnauserId) {
		this.qnauserId = qnauserId;
	}

	// qnaList
	public CQnaDto(int qnaNo, String qnaSecret, String pName, String qnaTitle, String qnauserId, String qnaDate) {
		super();
		this.qnaNo = qnaNo;
		this.qnaSecret = qnaSecret;
		this.pName = pName;
		this.qnaTitle = qnaTitle;
		this.qnauserId = qnauserId;
		this.qnaDate = qnaDate;
	}

	public CQnaDto(String qnaSecret, String qnaTitle, String qnaDate) {
		super();
		this.qnaSecret = qnaSecret;
		this.qnaTitle = qnaTitle;
		this.qnaDate = qnaDate;
	}

	// qnaView2
	public CQnaDto(int userNo, int qnaNo, String qnaTitle, String qnauserId, String qnaContent, String qnaComment) {
		super();
		this.userNo = userNo;
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnauserId = qnauserId;
		this.qnaContent = qnaContent;
		this.qnaComment = qnaComment;
	}

	// qnaView
	public CQnaDto(int userNo, String qnauserId, String qnaTitle, String qnaContent) {
		super();
		this.userNo = userNo;
		this.qnauserId = qnauserId;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getUserName() {
		return qnauserId;
	}

	public void setUserName(String userName) {
		this.qnauserId = userName;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public void setQnaContent(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaComment() {
		return qnaComment;
	}

	public void setQnaComment(String qnaComment) {
		this.qnaComment = qnaComment;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaSecret() {
		return qnaSecret;
	}

	public void setQnaSecret(String qnaSecret) {
		this.qnaSecret = qnaSecret;
	}

	// get set

}
