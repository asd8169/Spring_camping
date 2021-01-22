package com.spring.camping.admin.userinfosearch;

import java.sql.Timestamp;

public class CUserInfoSearchDto {
	
	String userNo;
	String userId;
	String userPw; 
	String userName;
	String userTelno;
	String zipNo;
	String roadAddrPart1;
	String addrDetail;
	String userEmail;
	
	
	
	public CUserInfoSearchDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	public CUserInfoSearchDto(String userNo, String userId, String userPw, String userName, String userTelno, String zipNo,
			String roadAddrPart1, String addrDetail, String userEmail) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userTelno = userTelno;
		this.zipNo = zipNo;
		this.roadAddrPart1 = roadAddrPart1;
		this.addrDetail = addrDetail;
		this.userEmail = userEmail;
		
	}
	
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTelno() {
		return userTelno;
	}
	public void setUserTelno(String userTelno) {
		this.userTelno = userTelno;
	}
	public String getZipNo() {
		return zipNo;
	}
	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}
	public String getRoadAddrPart1() {
		return roadAddrPart1;
	}
	public void setRoadAddrPart1(String roadAddrPart1) {
		this.roadAddrPart1 = roadAddrPart1;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	

	
}
