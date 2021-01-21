<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Q & A LIST</title>
</head>
<style>
table {
	margin: 20px auto;
	width: 70%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

h2 {
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
</style>

<body>

	<%@include file="./header/header.jsp"%>
<div>
		<form id="checklist">
			<div class="detail_title">
				<h2>Q&A LIST</h2>
			</div>
			<table>
				<!-- admin으로 로그인 시 체크박스 생성해야함  -->
				<tr>

					<%
						//관리자 로그인 시 checkbox 나옴
						if (session.getAttribute("sessionuserId") != null
								&& session.getAttribute("sessionuserId").equals("admin")) {
					%>
					<th><input type="checkbox" name="admincheckbox"> <%
 	}
 %>
					<th>NO.</th>
					<th style="width: 30%;">PRODUCT</th>
					<th style="width: 30%;">TITLE</th>
					<th style="width: 20%;">ID</th>
					<th>DATE</th>
				</tr>
				<c:forEach items="${list}" var="qnadto">
					<tr>
						<%
							//관리자 로그인 시 checkbox 나옴
								if (session.getAttribute("sessionuserId") != null
										&& session.getAttribute("sessionuserId").equals("admin")) {
						%>
						<td><input type="checkbox" name="admincheckbox"></td>
						<%
							}
						%>
						<td>${qnadto.qnaNo}</td>
						<td>${qnadto.pName}</td>

						<!-- <!— 비밀글 —> -->
						<c:choose>
							
							<c:when test="${(qnadto.userName eq sUser)}">
								<td><a href="qna_view.do?qnaNo=${qnadto.qnaNo }&userName=${qnadto.userName }">비밀글입니다.</a></td>
							</c:when>
							<c:when test="${(qnadto.qnaSecret eq 'y') && (sUser ne 'admin')}">
								<td><a href="javascript:alert('비밀글입니다');"
									onfocus="this.blur()">비밀글입니다.</a></td>
							</c:when>


							<c:otherwise>
								<td><a href="qna_view.do?qnaNo=${qnadto.qnaNo }&userName=${qnadto.userName }">${qnadto.qnaTitle}</a></td>
							</c:otherwise>

						</c:choose>




						<td>${qnadto.userName}</td>
						<td>${qnadto.qnaDate}</td>
					</tr>
				</c:forEach>
				<tr>
					<%
						//관리자 로그인 시 write 위치 변경
						if (session.getAttribute("sessionuserId") != null
								&& session.getAttribute("sessionuserId").equals("admin")) {
					%>
					<td colspan="6"><a href="qna_write.jsp">WRITE</a></td>
					<%
						}
					%>
					<%
						//관리자 로그인 시 write 위치 변경
						if (session.getAttribute("sessionuserId") != null
								&& !session.getAttribute("sessionuserId").equals("admin")) {
					%>
					<td colspan="5"><a href="qna_write.jsp">WRITE</a></td>
					<%
						}
					%>
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

	</table>


</body>
</html>