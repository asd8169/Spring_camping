<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위시리스트 화면</title>
</head>
<body>
	<form name="form" method="get">
	<table border="1">
		<tr>
			<th>사진</th>
			<th>상품명</th>
			<th>금액</th>
			<th>처리</th>
		
		</tr>
		<c:forEach items="${wishlist }" var="dto"> <!-- 변수가 필요 dto -->
		
		<tr>
			<td><img src="${pageContext.request.contextPath}/pimage/${dto.pFile }" width="150"/></td>
			<td>${dto.pName }</td>
			<td>${dto.pPrice }</td>
			
			
			<td><a href="deletewish.do?pNo=${dto.pNo }" >X</a></td>
		
		</tr>
			</c:forEach>
		
	</table>
	</form>
</body>
</html>