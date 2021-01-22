<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제완료 페이지</title>
</head>
<style>
.success_wrap {
	width: 400px;
	margin-top: 25%;
	margin-left: 40%;
	border: 1px solid #e6e6e6;
}

h2 {
	text-align:center;
	font-weight: normal;
	font-size: 30px;
	color: #1c1c1c;
	line-height: 1.25;
	font-family: Montserrat, 'Lato', '나눔고딕', "Nanum Gothic", "Malgun Gothic",
		"맑은 고딕", Dotum, "돋움", DotumChe, "돋움체", Verdana, monospace, Corbel,
		AppleGothic, Helvetica, sans-serif;
}


</style>
<body>

	<div class="success_wrap">
		<h2>결제가 완료되었습니다.</h2>
		<%
			session.setAttribute("orderAddress", "");
		%>
		<form action="main.do" style="text-align:center;margin-bottom:20px;">
			<input type="submit" value="확인" style="width:50px; height: 30px;">
		</form>

	</div>
</body>
</html>