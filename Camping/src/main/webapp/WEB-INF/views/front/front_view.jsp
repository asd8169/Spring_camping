<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>대문, 첫 화면</title>
</head>
<style>
body {
	background-image: url('/camping/mainimage/homecamping.png');
	background-repeat: no-repeat;
	background-size: cover;
}

#title {
	text-align: center;
    color: #fff;
    font-size: 48px;
    font-weight: bold;
    margin-bottom: 5px;
}

.mainTexBut {
	cursor: pointer;
	padding: 10px 20px;
	margin: 30px auto 0;
	transition: all 0.2s ease-out;
	width: 200px;
	border: 1px solid #fff;
	text-align: center;
	color: #fff;
	font-size: 12px;
}

.main_btn {
	position: absolute;
	
	top: 45%;
	left: 50%;
	transform: translateX(-50%) translateY(-50%);
	opacity: 1;
	z-index: 999;
}

a {
	text-decoration: none;
}

</style>

<body>


	<%@include file="../header/header2.jsp"%>
	



	<!-- 로그인, 회원가입 하면 각각 따로 화면 바뀌게  -->
	<div class="main_btn">
	
	
		<p id="title">
			<a href="login_view" style="font-weight: bold; color: #fff;"> L&nbsp; U&nbsp; M&nbsp; O&nbsp; S</a>
		</p>
		
		<p class="mainTexBut">
			<a href="login_view" style="font-weight: bold; color: #fff;">Login</a>
		</p>
		
		<p class="mainTexBut">
			<a href="signup_view.jsp" style="font-weight: bold; color: #fff;">Sign
				Up</a>
		</p>
	</div>
	<form action="login.do"></form>
	
	<%-- <%@include file="./footer/footer.jsp"%>  --%>
</body>
</html>