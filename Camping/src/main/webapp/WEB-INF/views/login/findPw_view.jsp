<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Id</title>
<script type="text/javascript">


function confirmPw(){

    url = "findPw.do?userId=" + document.form.userId.value +"&userTelno=" + document.form.userTelno.value +"&userEmail=" + document.form.userEmail.value;
    open(url,"confirm","toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
    
}


</script>

</head>

<style>

h2 {
	width: 35%;
	font-weight: normal;
	font-size: 13px;
	color: #1c1c1c;
	line-height: 1.25;
	font-family: Montserrat, 'Lato', '나눔고딕', "Nanum Gothic", "Malgun Gothic",
		"맑은 고딕", Dotum, "돋움", DotumChe, "돋움체", Verdana, monospace, Corbel,
		AppleGothic, Helvetica, sans-serif;
}

input {
	width: 300px;
	height: 40px;
}

.idfindwrap {
	text-align: center; 
	border : 1px solid #E6E6E6;
	width: 400px;
	margin-top: 20%;
	margin-left: 35%;
	border: 1px solid #E6E6E6;
}

</style>

<body>
	<div class="idfindwrap">
		<div>
			<h2>PW 찾기</h2>

		</div>
	
	<form action="login_view.jsp" name="form" id="form">	
	
	<input type="text" name = "userId" placeholder="Id를 입력하세요"><P>
	<input type="text" name = "userTelno" placeholder="전화번호를 입력하세요"><P>
	<input type="text" name = "userEmail" placeholder="E-mail을 입력하세요"><P>
	
	<input type="button" name="findPwBtn" value="PassWord찾기" onclick="confirmPw(this.form)" style="width: 150px; height: 40px;">
	
	<input type = "submit" name="gotologinBtn" value="로그인하러가자!" style="width: 150px; height: 40px;">
	
	
	</form>
		
</body>
</html>