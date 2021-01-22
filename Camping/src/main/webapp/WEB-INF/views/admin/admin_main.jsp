
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Main</title>
</head>

<style>
.admin_menu_wrap {

	margin: 20% auto;
	width: 17%;
}

.menu_wrap a {
	color: white;
	text-decoration: none;
}

.admin_menu {
	background-color: black;
	width: 300px;
	height: 40px;
	margin: 20px;
	font-size: 25px;
	text-align: center;
	padding-top: 15px;
}
</style>
<body>

<div class="admin_menu_wrap">
	<h2 style="text-align: center;">L U M O S . A D M I N</h2>

	<div class="menu_wrap">

		<a href="userinfo.do"><div class="admin_menu">LUMOS MEMBERS</div></a> 
		<a href="product_list.do"><div class="admin_menu">PRODUCT</div></a> 
		<a href="admin/order_list"><div class="admin_menu">ORDER LIST</div></a>
		<a href="qnaAdmin.do"><div class="admin_menu">Q & A</div></a> 
		<a href="#"><div class="admin_menu">GO LUMOS</div></a>

	</div>
</div>
</body>
</html>