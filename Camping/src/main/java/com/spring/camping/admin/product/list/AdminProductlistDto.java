package com.spring.camping.admin.product.list;

import java.sql.Timestamp;

public class AdminProductlistDto {

	int pNo;
	String pName;
	String pCategory;
	String pPrice;
	String pFile;
	int pStock;

	public AdminProductlistDto() {
	}

	public AdminProductlistDto(int pNo, String pName, String pCategory, String pPrice, String pFile, int pStock) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pCategory = pCategory;
		this.pPrice = pPrice;
		this.pFile = pFile;
		this.pStock = pStock;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpPrice() {
		return pPrice;
	}

	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}

	public String getpFile() {
		return pFile;
	}

	public void setpFile(String pFile) {
		this.pFile = pFile;
	}

	public int getpStock() {
		return pStock;
	}

	public void setpStock(int pStock) {
		this.pStock = pStock;
	}

	
}
