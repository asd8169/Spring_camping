<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login View</title>
<style>
/* 201207 세미 변경 */
body {
	background-image: url('./image/homecamping.png');
	background-repeat: no-repeat;
	background-size: cover;
}

table {
	margin-top: 20%;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
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
	top: 50%;
	left: 50%;
	transform: translateX(-50%) translateY(-50%);
	opacity: 1;
	z-index: 999;
}

a {
	text-decoration: none;
}

#userId {
	width: 384px;
	height: 58px;
}


</style>

</head>
<body class="align">
	<%@include file="../header/header2.jsp"%>
	<%-- <c:if test="${sessionID eq userId }">
		<script>
			alert("이미 로그인 중입니다.");
			location.href = "main.do";
		</script>
	</c:if> --%>


	<c:if test="${loginResult eq 1 }">
		<script>
			alert("이미 로그인 중입니다.");
			
			location.href = "main.do";
		</script>
	</c:if>
	

	<%-- <c:if test="${loginResult eq 0}">
			<script>
				alert("비밀번호가 틀렸습니다.");
			</script>
	</c:if>  --%>
	
	<c:if test="${loginResult eq 0 }">
			<script>
			var retVal = confirm("비밀번호가 틀렸습니다, 비밀번호찾기를 하시겠습니까?");
			  if( retVal == true ){

				    location.href = "findPw_view.jsp";
			   }else{

				   location.href =	"login_view.jsp";
				   <%session.invalidate();%> 
			  
			   }
			</script>
	</c:if> 
	
	
<%-- 	<c:if test="${loginResult eq -1}">
			<script>
				alert("아이디가 틀렸습니다.");
			</script>
	</c:if>  --%>
	
	<c:if test="${loginResult eq -1 }">
			<script>
			var retVal = confirm("아이디가 틀렸습니다, 아이디찾기를 하시겠습니까?");
			  if( retVal == true ){

			      location.href = "findId_view.jsp";
			   }else{
				   location.href = "login_view.jsp";
				   <%session.invalidate();%> 
			   }
			</script>
	</c:if> 
	
	

	<!-- 
	<div class="site__container">
	<div class="grid__container">
	 -->
	
	<form action="login">

	<table>

			<tr>

				<td><input type="text" name="userId" placeholder="Id"
					style="width: 300px; height: 50px; border: 1px solid #E6E6E6;"></td>
			</tr>

			<tr>

				<td><input type="password" name="userPw" placeholder="Password"
					style="width: 300px; height: 50px; border: 1px solid #E6E6E6;"></td>
			</tr>

			<tr>

				<td><input type="submit" name="LoginBtn" value="Login"
					style="width: 300px; height: 50px; background: black; color: #fff; font-weight: bold;"></td>
			</tr>
			<tr>

				<td><p style="font-weight: bold; color:gray;">
						Not a member? <a href="signup_view.jsp" style="color:#fff">Sign up now</a></td>
			</tr>

		</table>


		<div class="form__field"></div>




	</form>
	

	<!--  </div>

  </div> -->



</body>
</html>