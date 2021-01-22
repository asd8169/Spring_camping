<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>MY REVIEW LIST</title>
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
	width: 20%;
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
</style>

<body>
<%@include file="../header/header.jsp"%>
	<div>
		<form action="myreviewlist.do" id="checklist">
			<div class="detail_title">
				<h2>MY REVIEW LIST</h2>
			</div>
			<table>
			
				<tr>
					<th style="width:5%;">NO.</th>
					<th colspan="2" style="width:30%;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PRODUCT</th>
					<th>REVIEW</th>
					<th style="width: 20%;">DATE</th>
				</tr>
				
				<c:forEach items="${myreviewList}" var="myreviewList">
					<tr>
						<td>${myreviewList.reviewNo}</td>
						<td><img src="${pageContext.request.contextPath}/image/${myreviewList.reviewFile }" width="80"/></td>
						<td>${myreviewList.pName}</td>
						<td><a href="myreview_view.do?reviewNo=${myreviewList.reviewNo}&reviewContent=${myreviewList.reviewContent}&reviewFile=${myreviewList.reviewFile}">${fn:substring(myreviewList.reviewContent,0,10)}...</a></td>
						<td>${myreviewList.reviewDate}</td>
						
					</tr>
				</c:forEach>
			
				
			</table>

		</form>
	</div>

	<!-- 페이징 -->

	<%-- <table>

		<tr>
			<!-- startPage가 1이 아닐때  -->
			<c:if test="${startPage!=1}">

				<!-- 이전 버튼만들기 -->
				<a href="./qna.do?&page=${startPage-1}">[이전]</a>
			</c:if>

			<!-- for문으로 번호 생성 -->
			<c:forEach var="i" begin="${startPage}" end="${endPage}"
				varStatus="cnt">
				<a href="./qna.do?&page=${i}">[ <font color="#000000" /> <c:if
						test="${currentPage == i}">
						<font color="#bbbbbb" />
					</c:if> ${i} </font>]
				</a>
			</c:forEach>

			<!— endPage가 totalPage와 값이 다를때 —>
			<c:if test="${endPage!=totalPage}">
				<a href="./qna.do?&page=${endPage+1}">다음 ▶</a>
			</c:if>

		</tr>

	</table> --%>

	<%-- <% <%@include file="./footer/footer.jsp"%>  --%>
</body>
</html>