package com.jsplec.bbs.dto;

import java.sql.Timestamp;

public class CReviewDto {
	
	int reviewNo;
	int userNo;
	int pNo;
	int orderNo;
	String userId;
	String reviewFile;
	String reviewSubFile;
	String reviewContent;
	Timestamp reviewDate;
	
	public CReviewDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CReviewDto(int reviewNo, int pNo, int orderNo, String userId, String reviewFile, String reviewContent,
			Timestamp reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.pNo = pNo;
		this.orderNo = orderNo;
		this.userId = userId;
		this.reviewFile = reviewFile;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}



	public CReviewDto(int reviewNo, int userNo, int pNo, int orderNo, String reviewFile, String reviewContent,
			Timestamp reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.pNo = pNo;
		this.orderNo = orderNo;
		this.reviewFile = reviewFile;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}

	
	
	
	
	
	

	// get set
	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewFile() {
		return reviewFile;
	}

	public void setReviewFile(String reviewFile) {
		this.reviewFile = reviewFile;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Timestamp getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public int getpNo() {
		return pNo;
	}


	public void setpNo(int pNo) {
		this.pNo = pNo;
	}


	public int getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
}
