<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Product</title>
</head>
<style>
table {
	margin: 20px auto;
	width: 70%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

h2 {
	/* margin: 0px auto; */
	width: 7%;
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
	width: 70%;
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
input{
text-align: center;
}
</style>
<body>

	<!-- AdminPage Product 클릭시 화면 -->

<%@include file="../header/header.jsp"%>
<div>
		<form id="checklist">
			<div class="detail_title">
				<h2>PRODUCT LIST</h2>
			</div>

		<table>
		
			
			<tr>
				<th style="width:5%; text-align: center;">NO.</th>
				<th style="width:15%;"> </th><!-- 상품 이미지 -->
				<th>Product</th>
				<th>Category</th>
				<th>Stock</th>
				<th>Price</th>
			</tr>
			
						
			<c:forEach items="${productlist}" var="productdto">
			<!-- <form action="plist_modify.do?" method="get"> -->
			<tr>
			<td><input type="text" readonly="readonly" name="pNo" value="${productdto.pNo}" style = "border: none;"></td>
			<td><img src="${pageContext.request.contextPath}/productimage/${productdto.pFile}" width="50"/></td><!-- 상품 이미지 -->
			<td><input type="text" name="pName" value="${productdto.pName }"style = "border: none;"> </td>
			<td><input type="text" name="pCategory" value="${productdto.pCategory }" style = "border: none;"></td>
			<td><input type="text" name="pStock" value="${productdto.pStock }" style = "border: none;"></td>
			<td><input type="text" name="pPrice" value="${productdto.pPrice }" style = "border: none;"></td>
			<%-- <td><a href="plist_delete.do?pNo=${productdto.pNo }">삭제</a></td> --%>
			</tr>
			<!-- </form> -->
			</c:forEach>


			

		


		</table>
			

		<div align = "center">
		<a href="product_write.do">제품 등록</a>
		</div>


</body>
</html>