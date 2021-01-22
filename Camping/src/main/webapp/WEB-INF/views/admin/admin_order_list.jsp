<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>ORDER LIST</title>
</head>
<style>
table {
	margin: 20px auto;
	width: 70%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

h2 {
	/* margin: 0px auto; */
	width: 10%;
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
</style>
	
<body>
    <%@include file="../header/header.jsp"%> 
	<div>
		<form id="checklist">
			<div class="detail_title">
				<h2>ORDER LIST</h2>
			</div>
			<table>
				<tr>
					<th>NO.</th>
					<th style="width: 20%;">PRODUCT</th>
					<th >QUANTITY</th>
					<th >PRICE</th>
					<th style="width: 20%;">NAME</th>
					<th>USER</th>
					<th>DATE</th>
				</tr>
				
				<c:forEach items="${orderlist}" var="orderlist">
					<tr>
						<td>${orderlist.orderNo}</td>
						<%-- <input type="hidden" name="pNo" value="${orderlist.pNo}"> --%>
						<td>${orderlist.pName}</td>
						<td>${orderlist.orderQuantity}</td>
					 	<td>${orderlist.price}</td> 
						<td>${orderlist.orderAddress}</td>
						<td>${orderlist.userId}</td>
						<td>${orderlist.orderDate}</td>
					</tr>
				</c:forEach>
				
			</table>

		</form>
	</div>

	
</body>
</html>