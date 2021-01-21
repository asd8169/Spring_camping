package com.jsplec.bbs.dto;

public class CWishDto {

		int WishNo;
		
		int pNo;
		String pFile;
		String pName;
		String pPrice;
		
		
		
		
		public CWishDto(int pNo, String pFile, String pName, String pPrice) {
			super();
			this.pNo = pNo;
			this.pFile = pFile;
			this.pName = pName;
			this.pPrice = pPrice;
		}
		
		
		
		public int getpNo() {
			return pNo;
		}



		public void setpNo(int pNo) {
			this.pNo = pNo;
		}
		public int getWishNo() {
			return WishNo;
		}
		public void setWishNo(int wishNo) {
			WishNo = wishNo;
		}
		public String getpFile() {
			return pFile;
		}
		public void setpFile(String pFile) {
			this.pFile = pFile;
		}
		public String getpName() {
			return pName;
		}
		public void setpName(String pName) {
			this.pName = pName;
		}
		public String getpPrice() {
			return pPrice;
		}
		public void setpPrice(String pPrice) {
			this.pPrice = pPrice;
		}
		
		
		
		
}
