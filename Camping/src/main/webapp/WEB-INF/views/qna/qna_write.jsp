<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q & A</title>
</head>
<style>
table {
	margin: 0px auto;
	width: 70%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

h2 {
	margin: 0px auto;
	width: 70%;
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

td {
	height: 20px;
	font-size: 12px;
	text-align: center;
	padding: 20px;
}

tr, td {
	border-bottom: 1px solid #E6E6E6;
	text-align: center;
}

a {
	color: black;
	text-decoration: none;
}

</style>

<body>

	<%@include file="./header/header.jsp"%>

	<form action="qna_write.do" method="get">
		<table>
			<tr>
				<td style="width: 20%;">ID</td>
				<td style="width: 30%;"><input type="text" name="name" value="${sessionuserId }" readonly="readonly" style="width: 200px; height: 20px; border: 1px solid #E6E6E6;"></td>
				<td>비밀글</td>
				<td><input type="checkbox" name="qnaSecret" value="y"></td>
			</tr>

			<tr>
				<td>제목</td>
				<td><select name="qnaTitle" style="width: 210px; height: 30px; border: 1px solid #E6E6E6;">
						<option>선택하세요.</option>
						<option>제품 문의</option>
						<option>배송 문의</option>
						<option>결제 문의</option>
						<option>기타 문의</option>


				</select></td>
				<td><input type="hidden" name="userNo" value="${sessionuserNo }"></td>
			</tr>

			<tr>
				<td>내용</td>
				<td colspan="3"><textarea rows="15" cols="70" name="qnaContent" style="border: 1px solid #E6E6E6;"></textarea></td>
			</tr>

			<tr>
				<td colspan=4"><input type="submit" value="등록하기">
				<button class="list_btn">
						<a href="qna.do">목록보기</a>
					</button></td>
			</tr>
		</table>

	</form>

</body>
<body>
</html>