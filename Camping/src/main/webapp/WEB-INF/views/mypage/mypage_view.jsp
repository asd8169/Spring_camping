<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지 화면</title>
</head>

<style>
h2 {
	width: 10%;
	font-weight: normal;
	font-size: 13px;
	color: #1c1c1c;
	line-height: 1.25;
	font-family: Montserrat, 'Lato', '나눔고딕', "Nanum Gothic", "Malgun Gothic",
		"맑은 고딕", Dotum, "돋움", DotumChe, "돋움체", Verdana, monospace, Corbel,
		AppleGothic, Helvetica, sans-serif;
}

.mypage_wrap {
	width: 80%;
	margin: 0 auto;
	position: relative;
	overflow: hidden;
	border: 0px solid #000;
}

.aside {
	position: relative;
	overflow: hidden;
	border: 0px solid #000;
}

.lnb-wrap {
	position: relative;
	overflow: hidden;
	border: 0px solid #000;
}

.lnb-bx {
	margin-left: -1px;
	padding-left: 39px;
	float: left;
	width: 30%;
	min-height: 250px;
	border-left: 1px solid #e2e2e2;
	overflow: hidden;
}

.mypageimgwrap {

	margin: 50px 100px;
}

.mypageimg {
	position: absolute;
	width: 200px;
	height: 200px;
	/* background-image: url('./image/signup.png'); */
}
</style>
<body>
	<%@include file="./header/header.jsp"%>

	<div class="mypage_wrap">
		<div class="aside">
			<h2>MY PAGE</h2>
			<hr>
			<br><br>
		</div>
		<div class="lnb-wrap">
			<div class="lnb-bx">
				<a href="userinfoLoad.do">MYPAGE EDIT</a>
				<div class="mypageimgwrap">

					<div class="mypageimg"><a href="userinfoLoad.do"><img src="./image/signup.png" style="width:100px;"></a></div>

				</div>
			</div>
			<div class="lnb-bx">
				<a href="orderlist.do">ORDER LIST</a>
				<div class="mypageimgwrap">

					<div class="mypageimg"><a href="orderlist.do"><img src="./image/orderlist.png" style="width:100px;"></a></div>

				</div>

			</div>
			<div class="lnb-bx">
				<a href="myreviewlist.do">MY REVIEW LIST</a>
				<div class="mypageimgwrap">

					<div class="mypageimg"> <a href="myreviewlist.do"><img src="./image/reviewimg.png" style="width:100px;"></a></div>

				</div>

			</div>
		</div>









	</div>



	<!-- 

	<div class="mypage_rightwrap"></div>

	<a href="userinfoLoad.do">MYPAGE</a>
	//---------------------------------------------------------
	<br>
	<br> include.orderlist
	<br>

	<a href="orderlist.do">MYPAGE</a>
	//---------------------------------------------------------
	<br> //---------------------------------------------------------
	<br> include.review_view
	<br>

	<a href="myreviewlist.do">MY REVIEW LIST</a>
	//---------------------------------------------------------
	<br>
	<br> //---------------------------------------------------------
	<br> include.wish_view
	<br> //---------------------------------------------------------
	<br>

 -->


</body>
</html>