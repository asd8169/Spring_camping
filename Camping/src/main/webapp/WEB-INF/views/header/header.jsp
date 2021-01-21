<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	width: 100%;
	margin-top: 50px;
	padding: 0;
	text-align: center;
}

.top_menu_right .top_menu_li {
	list-style: none;
}

.header_top li {
	text-align: center;
	/* line-height: 50px; */
	/* margin-right: 10px; */
	width: 50px;
	height: 30px;
	float: right;
	font-size: 12px;
}

.header_top {
	margin-right: 20px;
	height: 30px;
}

a {
	color: black;
	text-decoration: none;
}

.header_title a {
	color: black;
	text-decoration: none;
}

.heaeder_title {
	width: 500px;
	height: 30px;
}

.main_menu_div li {
	list-style: none;
	width: 100px;
	height: 30px;
	font-size: 12px;
	margin: 0 0 0 0;
	padding: 0 0 0 0;
	border: 0;
	float: left;
}

.main_menu_div {
	padding-top: 5%;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	height: 100px;
	width: 35%;
}
</style>
<body>

	<nav class="header_top">
		<ul class="top_menu_right">
		<!-- <a href="javascript:alert('로그인 후 이용해주세요.');"
									onfocus="this.blur()">Q & A</a> -->
		
		<%
				// 로그인 전에 버튼 누르기 차단
				if (session.getAttribute("sessionuserId") == null)	{
			%>
			<li class="top_menu_li"><a href="javascript:alert('로그인 후 이용해주세요.');">Q & A</a></li>
			<li class="top_menu_li"><a href="javascript:alert('로그인 후 이용해주세요.');">MYPAGE</a></li>
			<li class="top_menu_li"><a href="javascript:alert('로그인 후 이용해주세요.');">CART</a></li>
			<li class="top_menu_li"><a href="signup_view.jsp">SIGN UP</a></li>
			<li class="top_menu_li"><a href="login_view.jsp">LOGIN</a></li>
			<%
				// 로그인 후에 버튼 활성화 및 변경
				}else{
		
		%>	
			
			<li class="top_menu_li"><a href="qna.do">Q & A</a></li>
			<li class="top_menu_li"><a href="mypage_view.jsp">MYPAGE</a></li>
			<li class="top_menu_li"><a href="cartlist.do">CART</a></li>
			<!-- <li class="top_menu_li"><a href="#">SIGN UP</a></li> -->
			<li class="top_menu_li"><a href="logout_view.jsp">LOGOUT</a></li>
			
			<%
				}
			%>
			
		</ul>
		<p style="float: left; margin-left: 20px; margin-top: 0px;">${sessionuserId}님
			환영합니다!</p>
	</nav>
		


	<div class="header_title">

		<h3>
			<a href="main.do">L &nbsp; U &nbsp; M &nbsp; O  &nbsp;S</a>
		</h3>

	</div>

	<div class="main_menu_div">
		<ul>
			<li class="main_menu_li"><a href="menu.do?select=TABLES">TABLES</a></li>
			<li class="main_menu_li"><a href="menu.do?select=CHAIRS">CHAIRS</a></li>
			<li class="main_menu_li"><a href="menu.do?select=STOOLS">STOOLS</a></li>
			<li class="main_menu_li"><a href="menu.do?select=STORAGE">STORAGE</a></li>
			<li class="main_menu_li"><a href="menu.do?select=SHELVING">COLLABORATION</a></li>

		</ul>
	</div>



</body>
</html>