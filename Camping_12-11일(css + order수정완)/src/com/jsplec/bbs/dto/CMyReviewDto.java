package com.jsplec.bbs.dto;

import java.sql.Timestamp;

public class CMyReviewDto {

	
	int userNo;
	int pNo;
	int reviewNo;
	int orderNo;
	String pName;
	String userId;
	String reviewFile;
	String reviewContent;
	Timestamp reviewDate;
	
	
	public CMyReviewDto() {

	}


	public CMyReviewDto(int userNo, int pNo, int reviewNo, int orderNo, String userId, String reviewFile,
			String reviewContent, Timestamp reviewDate) {
		super();
		this.userNo = userNo;
		this.pNo = pNo;
		this.reviewNo = reviewNo;
		this.orderNo = orderNo;
		this.userId = userId;
		this.reviewFile = reviewFile;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}

	
	public CMyReviewDto(int reviewNo, int orderNo, String pName, String reviewFile, String reviewContent,
			Timestamp reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.orderNo = orderNo;
		this.pName = pName;
		this.reviewFile = reviewFile;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}


	public CMyReviewDto(int userNo, int pNo, int reviewNo, int orderNo, String reviewFile, String reviewContent,
			Timestamp reviewDate) {
		super();
		this.userNo = userNo;
		this.pNo = pNo;
		this.reviewNo = reviewNo;
		this.orderNo = orderNo;
		this.reviewFile = reviewFile;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}


	// getter setter
	
	
	public int getUserNo() {
		return userNo;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
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


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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
	
	
	
	
}
