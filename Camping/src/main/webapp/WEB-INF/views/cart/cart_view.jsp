<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 화면</title>
</head>
<style>
table {
	margin: 0px auto;
	width: 90%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

h2 {
	width: 17%;
	font-weight: normal;
	font-size: 13px;
	color: #1c1c1c;
	line-height: 1.25;
	font-family: Montserrat, 'Lato', '나눔고딕', "Nanum Gothic", "Malgun Gothic",
		"맑은 고딕", Dotum, "돋움", DotumChe, "돋움체", Verdana, monospace, Corbel,
		AppleGothic, Helvetica, sans-serif;
}

.detail_title {
	display: block;
	letter-spacing: 1px;
	margin: 0px auto;
	width: 75%;
	font-weight: normal;
}

th {
	border-top: 1px solid #000;
	height: 50px;
	font-size: 17px;
}

td {
	height: 40px;
	font-size: 12px;
	color: rgb(28, 28, 28);
}

th, td {
	border-bottom: 1px solid #E6E6E6;
	text-align: center;
}

a {
	color: black;
	text-decoration: none;
}

.mt100 {
	margin-top: 100px;
}

li{
float: right;

}

.cart_Buy_btn {
	border: 1px solid #E6E6E6;
	background-color: black;
	color: #fff;
	width: 130px;
	height: 35px;
}

.cart_Buy_btn a {
	color: #fff;
	line-height: 35px;
}
</style>
<body>
	<%@include file="../header/header.jsp"%>


<div class="detail_title">
	<h2 style="width: 20%;">SHOPPING CART</h2>
	<form name="form1" method="get">
		<table>
			<tr>
				<th>번호</th>
				<th>사진</th>
				<th>상품명</th>
				<th>수량</th>
				<th>금액</th>
				<th>취소</th>

			</tr>
			<c:forEach items="${cartlist }" var="dto">
				<!-- 변수가 필요 dto -->
				<tr>
					<td>${dto.cartNo }</td>
					<td><img src="${pageContext.request.contextPath}/pimage/${dto.pFile }" width="300"/></td>
					<td>${dto.pName }</td>
					<td><input type=hidden name="sell_price" value="sum">
						<input type="text" name="cartQuantity" id="quantity"
						class="quantity" value="${dto.cartQuantity }" size="3" style="border: 1px solid #fff;"
						onchange="change();" > <a
						href="updatecart.do?cartNo=${dto.cartNo }&cartQuantity=${dto.cartQuantity }&chk=1">+</a>
						<a
						href="updatecart.do?cartNo=${dto.cartNo }&cartQuantity=${dto.cartQuantity }&chk=0">-</a>
						<input type="hidden" name="cartNo" value="${dto.cartNo }">

					</td>
					<td><input type="text" name="sum" class="price"
						value="${dto.sum }" size="8" readonly style="border:1px solid #fff;text-align:right;">원
					</td>
					<td><a href="deletecart.do?cartNo=${dto.cartNo }">X</a></td>

				</tr>
			</c:forEach>

		</table>
	</form>
	<br>
	<ul style="width: 91%;">
	<li class = "cart_Buy_btn"><a href="deleteAllcart.do">장바구니 비우기</a></li>
	<li class = "cart_Buy_btn"><a href="order.do">주문하기</a></li>
	<li class = "cart_Buy_btn"><a href="main.do">계속쇼핑하기</a></li>
	</ul>
</div>


<div class="detail_title mt100">
	<h2>WISH LIST</h2>
	<form name="form2" method="get">
		<table>
			<tr>
				<th>사진</th>
				<th>상품명</th>
				<th>금액</th>
				<th>처리</th>

			</tr>
			<c:forEach items="${wishlist }" var="dto">
				<!-- 변수가 필요 dto -->

				<tr>
					<td><img src="${pageContext.request.contextPath}/pimage/${dto.pFile }" width="150"/></td>
					<td>${dto.pName }</td>
					<td>${dto.pPrice }</td>


					<td><a href="deletewish.do?pNo=${dto.pNo }">X</a></td>

				</tr>
			</c:forEach>

		</table>
	</form>

</div>

</body>
</html>