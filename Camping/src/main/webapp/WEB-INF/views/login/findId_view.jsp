<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Id</title>
<script type="text/javascript">
	function confirmId() {
		/* 	var id = document.myForm;
		
		 if(!id){
		 alert("ID를 입력하세요");
		 return false;
		 }
		 else if((document.form.userId.value < "0" || document.form.userId.value > "9") && (document.form.userId.value < "A" || document.form.userId.value > "Z") && (document.form.userId.value < "a" || document.form.userId.value > "z")){
		 alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
		 return false;
		 } else { */

		url = "findId.do?userName=" + document.form.userName.value
				+ "&userTelno=" + document.form.userTelno.value + "&userEmail="
				+ document.form.userEmail.value;
		open(
				url,
				"confirm",
				"toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");

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
			<h2>ID 찾기</h2>

		</div>
		<form action="login_view.jsp" name="form" id="form">

			<input type="text" name="userName" placeholder="이름을 입력하세요">
			<P>
				<input type="text" name="userTelno" placeholder="전화번호를 입력하세요">
			<P>
				<input type="text" name="userEmail" placeholder="E-mail을 입력하세요">
			<P>

				<input type="button" name="findIdBtn" value="ID찾기"
					style="width: 150px; height: 40px;" onclick="confirmId(this.form)">
				<input type="submit" style="width: 150px; height: 40px;"
					name="gotologinBtn" value="로그인하러가자!">
		</form>
	</div>
</body>
</html>