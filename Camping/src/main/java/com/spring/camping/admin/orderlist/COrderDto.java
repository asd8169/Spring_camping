package com.spring.camping.admin.orderlist;

import java.sql.Timestamp;

public class COrderDto {

	int orderNo;
	int pNo;
	String userinfo_userNo;
	String product_pNo;
	String orderAddress;
	int orderQuantity;
//	String orderDate;
	Timestamp orderDate;
//	String orderDate2;

	// ???
	String userId;

	// 주문자 이름
	String pName;

	// 세미 Dto
	String orderName;
	String orderPname;
	int orderPrice;

	// 주문내역 가격
	int price;
	
	public COrderDto() {
		// TODO Auto-generated constructor stub
	}

	public COrderDto(int orderNo, int pNo, String orderAddress, int orderQuantity, Timestamp orderDate, String userId,
			String pName, int price) {
		super();
		this.orderNo = orderNo;
		this.pNo = pNo;
		this.orderAddress = orderAddress;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
		this.userId = userId;
		this.pName = pName;
		this.price = price;
	}

//public COrderDto(int orderNo, int orderQuantity, Timestamp orderDate2, String orderName, String orderPname,
//		int orderPrice) {
//	super();
//	this.orderNo = orderNo;
//	this.orderQuantity = orderQuantity;
//	this.orderDate2 = orderDate2;
//	this.orderName = orderName;
//	this.orderPname = orderPname;
//	this.orderPrice = orderPrice;
//}

public COrderDto(int orderNo, String orderName, String orderPname, int orderPrice, int orderQuantity,
		String orderDate2) {
	// TODO Auto-generated constructor stub
}

//public Timestamp getOrderDate2() {
//	return orderDate2;
//}
//
//public void setOrderDate2(Timestamp orderDate2) {
//	this.orderDate2 = orderDate2;
//}

public COrderDto(int orderNo, int pNo, String orderAddress, int orderQuantity, Timestamp orderDate, String pName,
		int price) {
	super();
	this.orderNo = orderNo;
	this.pNo = pNo;
	this.orderAddress = orderAddress;
	this.orderQuantity = orderQuantity;
	this.orderDate = orderDate;
	this.pName = pName;
	this.price = price;
}

public COrderDto(int orderNo, String orderAddress, int orderQuantity, Timestamp orderDate, String pName,
		int price) {
	super();
	this.orderNo = orderNo;
	this.orderAddress = orderAddress;
	this.orderQuantity = orderQuantity;
	this.orderDate = orderDate;
	this.pName = pName;
	this.price = price;
}

//public COrderDto(int orderNo, String orderAddress, int orderQuantity, String orderDate, String pName, int price) {
//	super();
//	this.orderNo = orderNo;
//	this.orderAddress = orderAddress;
//	this.orderQuantity = orderQuantity;
//	this.orderDate = orderDate;
//	this.pName = pName;
//	this.price = price;
//}

//public String getOrderDate() {
//	return orderDate;
//}

//public void setOrderDate(String orderDate) {
//	this.orderDate = orderDate;
//}







public int getOrderNo() {
	return orderNo;
}

public int getpNo() {
	return pNo;
}

public void setpNo(int pNo) {
	this.pNo = pNo;
}

public void setOrderNo(int orderNo) {
	this.orderNo = orderNo;
}

public String getUserinfo_userNo() {
	return userinfo_userNo;
}

public void setUserinfo_userNo(String userinfo_userNo) {
	this.userinfo_userNo = userinfo_userNo;
}

public String getProduct_pNo() {
	return product_pNo;
}

public void setProduct_pNo(String product_pNo) {
	this.product_pNo = product_pNo;
}

public String getOrderAddress() {
	return orderAddress;
}

public void setOrderAddress(String orderAddress) {
	this.orderAddress = orderAddress;
}

public int getOrderQuantity() {
	return orderQuantity;
}

public void setOrderQuantity(int orderQuantity) {
	this.orderQuantity = orderQuantity;
}

public Timestamp getOrderDate() {
	return orderDate;
}

public void setOrderDate(Timestamp orderDate) {
	this.orderDate = orderDate;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getpName() {
	return pName;
}

public void setpName(String pName) {
	this.pName = pName;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getOrderName() {
	return orderName;
}

public void setOrderName(String orderName) {
	this.orderName = orderName;
}

public String getOrderPname() {
	return orderPname;
}

public void setOrderPname(String orderPname) {
	this.orderPname = orderPname;
}

public int getOrderPrice() {
	return orderPrice;
}

public void setOrderPrice(int orderPrice) {
	this.orderPrice = orderPrice;
}

}
