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
	
	//
	
	
	
	
	
	
	
} // END
