package com.jsplec.bbs.dto;

public class CCartDto {

		int cartNo;
		int cartQuantity;
		
		String pFile;
		String pName;
		int sum;
		
		int product_pNo;
		
		
		
		public CCartDto(int product_pNo , int cartQuantity ) {
			super();
			this.cartQuantity = cartQuantity;
			this.product_pNo = product_pNo;
		}


		public CCartDto(int cartNo, int cartQuantity, String pFile, String pName, int sum) {
			super();
			this.cartNo = cartNo;
			this.cartQuantity = cartQuantity;
			this.pFile = pFile;
			this.pName = pName;
			this.sum = sum;
		}


		public CCartDto() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		public int getProduct_pNo() {
			return product_pNo;
		}


		public void setProduct_pNo(int product_pNo) {
			this.product_pNo = product_pNo;
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


		public int getSum() {
			return sum;
		}


		public void setSum(int sum) {
			this.sum = sum;
		}


		


		public int getCartNo() {
			return cartNo;
		}


		public void setCartNo(int cartNo) {
			this.cartNo = cartNo;
		}


		public int getCartQuantity() {
			return cartQuantity;
		}


		public void setCartQuantity(int cartQuantity) {
			this.cartQuantity = cartQuantity;
		}
		
		
}
