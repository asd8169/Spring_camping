<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>review_Write</title>
	</head>
	
	
	<style>
	
table {
	margin: 0px auto;
	width: 60%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

h2 {
	width: 20%;
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
	margin: 0px auto;
	width: 70%;
	font-weight: normal;
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
	<%    
    request.setCharacterEncoding("UTF-8");
    String orderNo = request.getParameter("orderNo");
	%>

</style>
	
	<body>
	<%@include file="./header/header.jsp"%>
		<form action="regiseter_review.do" method="post" enctype="multipart/form-data">
			<div>
			<div class="detail_title">
				<h2>REVIEW</h2>
				<input type="hidden" name="orderNo" value="<%=request.getParameter("orderNo")%>">
					<input type="hidden" name="pNo" value="<%=request.getParameter("pNo")%>">
					<input type="hidden" name="userNo" value="${sessionuserNo }">
			</div>
				<table>
					
					<tr>
					<td style="width:30%;font-weight:bold;">작성자</td>
						<td style="text-align: left;"><input type="text" name="userId" value="${sessionuserId}" readonly="readonly" style=" border: 1px solid #fff;"></td>
					</tr>	
					<tr>	
					<td style="width:30%;font-weight:bold;">내용</td>	
						<td style="text-align: left;"><textarea placeholder="리뷰를 10글자 이상 입력해주세요." rows="10" cols="30" name="reviewContent" style=" border: 1px solid #E6E6E6; margin:20px;"></textarea></td>
					</tr>
					<tr>
					<td style="width:30%;font-weight:bold;">파일첨부</td>
					<td style="text-align: left;"> <input type="file" name="reviewFile" >
					<input type="submit" value="작성" style=" border: 1px solid #E6E6E6; width:100px; height:30px;"></td>
					</tr>
				</table>
			</div>
			</form>
	</body>
</html>