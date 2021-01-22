<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Review LIST</title>
</head>
<style>
table {
	margin: 0px auto;
	width: 70%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

 h2 {
	margin: 0px auto;
	width: 70%;
	font-weight: normal;
	font-size: 13px;
	color: #1c1c1c;
	line-height: 1.25;
	font-family: Montserrat, 'Lato', '나눔고딕', "Nanum Gothic", "Malgun Gothic",
		"맑은 고딕", Dotum, "돋움", DotumChe, "돋움체", Verdana, monospace, Corbel,
		AppleGothic, Helvetica, sans-serif;
} 

.detail_title{
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
</style>

<body>
<%@include file="../header/header.jsp"%>
	
	<div>
	<form id="checklist">
	<div class="detail_title">
		
	</div>
		<table>
			<tr>
			
		
				<th>NO.</th>
				<th style="width: 30%;">PRODUCT</th>
				<th style="width: 30%;">REVIEW</th>
				<th style="width: 20%;">WRITER</th>
				<th>DATE</th>
			</tr>
			<c:forEach items="${CReviewDto}" var="CReviewDto">
				<tr>
					<td>${CReviewDto.reviewNo}</td>
					<td>${CReviewDto.pNo}</td>
					<td><a href="review_view.do?reviewNo=${CReviewDto.reviewNo}&userNo=${CReviewDto.userNo}&reviewContent=${CReviewDto.reviewContent}&reviewFile=${CReviewDto.reviewFile}">${fn:substring(CReviewDto.reviewContent,0,10)}...</a></td>
					<td>${CReviewDto.userNo}</td>
					<td>${CReviewDto.reviewDate}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><a href="review_write.jsp">WRITE</a></td>
			</tr>

		</table>

	</form>
	</div>
	
	
	
	<!-- 페이징 -->

	<table>

		<tr>
			<!-- startPage가 1이 아닐때  -->
			<c:if test="${startPage!=1}">

				<!-- 이전 버튼만들기 -->
				<a href="./product.do?&page=${startPage-1}">[이전]</a>
			</c:if>

			<!-- for문으로 번호 생성 -->
			<c:forEach var="i" begin="${startPage}" end="${endPage}"
				varStatus="cnt">
				<a href="./product.do?&page=${i}">[ <font color="#000000" /> <c:if
						test="${currentPage == i}">
						<font color="#bbbbbb" />
					</c:if> ${i} </font>]
				</a>
			</c:forEach>

			<!— endPage가 totalPage와 값이 다를때 —>
			<c:if test="${endPage!=totalPage}">
				<a href="./product.do?&page=${endPage+1}">다음 ▶</a>
			</c:if>

		</tr>

	</table>
	

</body>
</html>