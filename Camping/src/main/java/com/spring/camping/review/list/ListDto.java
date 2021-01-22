package com.spring.camping.review.list;

public class ListDto {

	int reviewNo;
	int userNo;
	int pNo;
	int orderNo;
	String userId;
	String reviewFile;
	String reviewSubFile;
	String reviewContent;
	String reviewDate;
	
	public ListDto() {
		// TODO Auto-generated constructor stub
	}

	// 
	public ListDto(int reviewNo, int pNo, int orderNo, String userId, String reviewFile, String reviewContent,
			String reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.pNo = pNo;
		this.orderNo = orderNo;
		this.userId = userId;
		this.reviewFile = reviewFile;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}

	public ListDto(int reviewNo, int userNo, int pNo, int orderNo, String userId, String reviewFile,
			String reviewSubFile, String reviewContent, String reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.pNo = pNo;
		this.orderNo = orderNo;
		this.userId = userId;
		this.reviewFile = reviewFile;
		this.reviewSubFile = reviewSubFile;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}

	// getter setter
	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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

	public String getReviewFile() {
		return reviewFile;
	}

	public void setReviewFile(String reviewFile) {
		this.reviewFile = reviewFile;
	}

	public String getReviewSubFile() {
		return reviewSubFile;
	}

	public void setReviewSubFile(String reviewSubFile) {
		this.reviewSubFile = reviewSubFile;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	

	
} // END
