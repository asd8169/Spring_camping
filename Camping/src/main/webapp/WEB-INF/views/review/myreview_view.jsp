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
	width: 35%;
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
	<%@include file="./header/header.jsp"%>
		<div>
			<form action="myreview_modify.do" method="get">
			<div class="detail_title">
				<h2>REVIEW</h2>
			</div>
				<table>
				<tr>
				<td> NO. </td>
				<td> <input type="text" name="reviewNo" value="<%=request.getParameter("reviewNo") %>"></td>
				</tr>
				<tr>
					<td width="20%"> 작성자 </td> 
					<td><input type="text" value="${sessionuserId}" readonly="readonly"></td>
				</tr>
				<tr>
					<td colspan="2"><img src="${pageContext.request.contextPath}/image/<%=request.getParameter("reviewFile")%>" width="300"  style="margin-left:220px;" /></td>
				</tr>
				<tr>
					<td> 내 용 </td> 
					<td><textarea rows="10" cols="40"  name="reviewContent" style="margin:20px;"><%=request.getParameter("reviewContent") %></textarea></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right;"><a href="myreviewlist.do?&userNo=${sessionuserNo }">BACK TO LIST</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="REVISE" style="border:1px solid #fff; font-size:12px; background-color: #fff;"><a href="myreview_delelte.do?&reviewNo=<%=request.getParameter("reviewNo") %>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DELETE</a></td>
					<td></td>
				</tr>
				</table>
			</form>
		</div>
		
<%

%>
	</body>
</html>