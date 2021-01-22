<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>메인</title>
</head>
<style>

table {
	margin: 0px auto;
	width: 70%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

.item_wrap .item_list .item_thumb {
	margin: 0 auto 10px;
	/* text-align: center; */
	position: relative;
}

.item_wrap {
	width: 85%;
	display: block;
	line-height: 0;
}

.item_wrap ul li {
	border: 1px solid #black;
}

a {
	color: black;
	text-decoration: none;
}

.item_list li {
	float: right;
	list-style: none;
	margin-bottom: 80px;
	width: 33.33%;
	padding: 0 1%;
}
</style>
<body>



	<%-- <%
				//관리자 로그인 시 checkbox 나옴
				if (session.getAttribute("sessionuserId") != null
						&& session.getAttribute("sessionuserId").equals("admin")) {
			%>
			<tr>
				<td colspan="5"><a href="write_view.do">글작성</a>
			</tr>
			<%
				}
			%></table>

			<form action="product_view.jsp">
				<input type="submit" value="제품 상세정보로 이동">
			</form>
	</div>  --%>



	<%-- <c:if test="${loginResult == 1}">
			<script>
				alert("로그인 성공.");
			</script>
	</c:if>  --%>

<%@include file="../header/header.jsp"%>


	<script>
		function 함수이름() {
			location.reload();
		}
	</script>
	
	
	
	

	<div>
		<table>
			<!-- 상품 목록 list -->
			<div class="item_wrap">

				<ul class="item_list">
				

					<c:forEach items="${mainList }" var="main">
						<li style="width: 400px;">
							<div class="item-box">
								<!-- 상품이미지 -->
								<div class="item_thumb">
								<a href="product0.do?pNo=${main.pNo}"><img src="${pageContext.request.contextPath}/pimage/${main.pFile}" width="250" height="250"/></a>
									<a></a>
								</div>
								<div class="item_info">
									<!-- <p class="item_img"> -->
									<p class="item_name">상품명 ${main.pName}</p>
									<p class="item_price">가격 ${main.pPrice}</p>
								</div>

							</div>


						</li>

					</c:forEach>

				</ul>

			</div>

			<div>
			</table>
			

				<table>

					<tr>
						<!-- startPage가 1이 아닐때  -->
						<c:if test="${startPage!=1}">

							<!-- 이전 버튼만들기 -->
							<a href="./main.do?&page=${startPage-1}">[이전]</a>
						</c:if>

						<!-- for문으로 번호 생성 -->
						<c:forEach var="i" begin="${startPage}" end="${endPage}"
							varStatus="cnt">
							<a href="./main.do?&page=${i}">[ <font color="#000000" /> <c:if
									test="${currentPage == i}">
									<font color="#bbbbbb" />
								</c:if> ${i} </font>]
							</a>
						</c:forEach>

						<!-- endPage가 totalPage와 값이 다를때 -->
						<c:if test="${endPage!=totalPage}">
							<a href="./main.do?&page=${endPage+1}">다음 ▶</a>
						</c:if>

					</tr>

				</table>

			</div>






			<%-- <table border="1">
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>상품종류</th>
			<th>가격</th>
		</tr>
		<c:forEach items="${mainList }" var="main">

			<tr>

				<td>${main.pNo}</td>
				<td>${main.pName}</td>
				<td>${main.pCategory}</td>
				<td>${main.pPrice}</td>

			</tr>

		</c:forEach>
	</table>
 --%>

			<!-- 페이징 -->

</body>
</html>