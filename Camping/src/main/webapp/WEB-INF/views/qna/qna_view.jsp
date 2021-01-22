<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q & A VIEW</title>
</head>

<style>
table {
	margin: 0px auto;
	width: 60%;
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


<body>

	<table>
		<%@include file="../header/header.jsp"%>
		<!-- post,get 상관없이 action.do가 실행 -->
		<form action="qnamodify.do" method="get">
			<input type="hidden" value="${qna_view.qnaNo }" name="qnaNo">
			<tr>

				<td style="width: 30%;">ID</td>
				<td><input type="text" name="qnauserId" size="10"
					value="${qna_view.qnauserId }" readonly="readonly"
					style="width: 200px; height: 20px; border: 1px solid #E6E6E6;"></td>

			</tr>

			<tr>

				<td>제목</td>
				<td><input type="text" name="qnaTitle"
					value="${qna_view.qnaTitle }" readonly="readonly"
					style="width: 200px; height: 20px; border: 1px solid #E6E6E6;"></td>

			</tr>

			<tr>

				<td>내용</td>
				<td><textarea rows="10" cols="50" name="qnaContent"
						style="border: 1px solid #E6E6E6;">${qna_view.qnaContent}</textarea>
				</td>

			</tr>

			<tr>

				<!-- sessionuserId가 listName이 같다면 수정,삭제,목록 버튼 나오기 -->
				<%
					if (session.getAttribute("sessionuserId").equals(session.getAttribute("listName"))) {
				%>
				<td colspan="2"><input type="submit" value="수정하기" style="background-color: white;border: white;font-size:12px;">&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="qnadelete.do?qnaNo=${qna_view.qnaNo }">삭제</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="product.do">목록보기</a></td>

				<!-- sessionuserId가 null이 아니고 sessionuserId와 listName이 같다면 수정,삭제,목록 버튼 나오기 -->
				<%
					} else {
				%>
				<td colspan="2"><a href="qnaAdmin.do">목록보기</a></td>
				<%
					}
				%>
			</tr>
		</form>

	</table>
	
	
	<!-- 1207 세미 admin 답변 추가 -->
	
	<table>
		<form action="qnaComment.do" method="get">
		<input type="hidden" value="${qna_view.qnaNo }" name="qnaNo2">
			<tr>
				<td style="width: 30%; border-top: 1px solid #FFF;">문의 답변</td>
				
				<%
							//관리자 로그인 시 댓글 등록 가능
								if (session.getAttribute("sessionuserId") != null
										&& session.getAttribute("sessionuserId").equals("admin")) {
						%>
				
				<td style="border-top: 1px solid #FFF;"><input type="text" name="qnaComment" value="${qna_view.qnaComment}" style="border: 1px solid #E6E6E6;width: 500px; height: 20px;">&nbsp;&nbsp;
					<%
							}
						%>
						
						
						
						
						<%
							//일반 사용자는 댓글 읽기만 가능
								if (session.getAttribute("sessionuserId") != null
										&& !session.getAttribute("sessionuserId").equals("admin")) {
						%>
				
				<td style="border-top: 1px solid #FFF;"><input type="text" name="qnaComment" value="${qna_view.qnaComment}" readonly="readonly" style="border: 1px solid #E6E6E6;width: 500px; height: 20px;">&nbsp;&nbsp;
					<%
							}
						%>
						
						
				
				<%
							//관리자 로그인 시 등록 버튼나옴
								if (session.getAttribute("sessionuserId") != null
										&& session.getAttribute("sessionuserId").equals("admin")) {
						%>
				<input type="submit" value="등록" style="background-color: white;border: white;font-size:12px;"></td>
				<%
							}
						%>
		</tr>
		</form>

	</table>
	
	
	
	
	
	
	
	
	

</body>
</html>