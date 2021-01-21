<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

.detail_title {
	display: block;
	letter-spacing: 1px;
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


	<head>
		<meta charset="UTF-8">
		<title>REVIEW</title>
	</head>
	
	<body>
		<div>
			<form action="review_modify.do" method="get" enctype="multipart/form-data">
				<table>
				<tr>
				<td colspan="2"><h2>REVIEW</h2></td>
				</tr>
				<tr>
				<td colspan="2"> NO : <input type="text" name="reviewNo" value="<%=request.getParameter("reviewNo")%>"></td>
				</tr>
				<tr>
					<td width="30%"> 작성자 : </td> <td><input type="text" value="<%=request.getParameter("userNo")%>"  name="userNo"></td>
				</tr>
				<tr>
					<td colspan="2"><img src="${pageContext.request.contextPath}/image/<%=request.getParameter("reviewFile")%>" width="300"/></td>
				</tr>
				<tr>
					<td> 내 용 : </td> <td><textarea rows="10" cols="40"  name="reviewContent"><%=request.getParameter("reviewContent") %></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정">
					&nbsp;&nbsp;<a href="product.do?pNo=${param.pNo}">목록</a>
					&nbsp;&nbsp;<a href ="review_delelte.do?reviewNo=<%=request.getParameter("reviewNo")%>">삭제</a></td>
					<td></td>
				</tr>
				</table>
			</form>
		</div>
		
<%

%>
	</body>
</html>