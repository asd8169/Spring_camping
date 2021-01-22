package com.spring.camping.admin.qnalist;

import java.sql.Timestamp;

public class QnalistDto {

	int qnaNo;
	String qnaSecret;
	String pName;
	String qnaTitle;
	String qnauserId;
	String qnaDate;

	public QnalistDto() {
	}

	public QnalistDto(int qnaNo, String qnaSecret, String pName, String qnaTitle, String qnauserId, String qnaDate) {
		super();
		this.qnaNo = qnaNo;
		this.qnaSecret = qnaSecret;
		this.pName = pName;
		this.qnaTitle = qnaTitle;
		this.qnauserId = qnauserId;
		this.qnaDate = qnaDate;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaSecret() {
		return qnaSecret;
	}

	public void setQnaSecret(String qnaSecret) {
		this.qnaSecret = qnaSecret;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnauserId() {
		return qnauserId;
	}

	public void setQnauserId(String qnauserId) {
		this.qnauserId = qnauserId;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}
	

}
