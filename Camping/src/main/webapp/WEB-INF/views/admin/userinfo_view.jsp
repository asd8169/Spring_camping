<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
	margin: 0px auto;
	width: 70%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

h2 {
	width: 38%;
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

.search_wrap {
	margin: 50px auto;
	text-align: center;
}
</style>

<body>
<%@include file="../header/header.jsp"%>

	<c:if test="${delete == 0 }">
		<script>
			alert("회원정보 삭제 실패.");
		</script>
	</c:if>

	<c:if test="${delete == 1}">
		<script>
			alert("회원정보 삭제 완료.");
		</script>
	</c:if>

	<div class="search_wrap">
		<form action="userinfoSearch">


			검색 선택 : <select name="select">

				<option value="USERID" selected="selected">ID</option>
				<option value="USERNAME">Name</option>
				<option value="USERTELNO">Tel</option>
				<!-- <option value="Address">Address</option> -->
				<option value="USEREMAIL">Email</option>

			</select>&nbsp;&nbsp;&nbsp; <input type="text" name="content" size="30" /> <input
				type="submit" value="검색">

		</form>

	</div>

	<h2>회원관리 페이지</h2>

	<table>
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>Name</th>
			<th>Telno</th>
			<th colspan="1">Address</th>
			<th>Email</th>
			<th>회원관리</th>
		</tr>

		<c:forEach items="${userInfoList }" var="user">

			<tr>


				<td>${user.userId}</td>
				<td>${user.userPw}</td>
				<td>${user.userName}</td>
				<td>${user.userTelno}</td>
				<td>${user.zipNo}${user.roadAddrPart1}${user.addrDetail}</td>
				<td>${user.userEmail}</td>

				<td><a href="userInfoDelete.do?userId=${user.userId}">삭제</a></td>


			</tr>

		</c:forEach>
	</table>


	<!-- 페이징 -->
<br><br>
	<table>

		<tr>
			<!-- startPage가 1이 아닐때  -->
			<c:if test="${startPage!=1}">

				<!-- 이전 버튼만들기 -->
				<a href="./userinfo.do?&page=${startPage-1}">[이전]</a>
			</c:if>

			<!-- for문으로 번호 생성 -->
			<c:forEach var="i" begin="${startPage}" end="${endPage}"
				varStatus="cnt">
				<a href="./userinfo.do?&page=${i}">[ <font color="#000000" /> <c:if
						test="${currentPage == i}">
						<font color="#bbbbbb"/>
					</c:if> ${i} </font>]
				</a>
			</c:forEach>

			<!-- endPage가 totalPage와 값이 다를때 -->
			<c:if test="${endPage!=totalPage}">
				<a href="./userinfo.do?&page=${endPage+1}">다음 ▶</a>
			</c:if>

		</tr>

	</table>





</body>
</html>