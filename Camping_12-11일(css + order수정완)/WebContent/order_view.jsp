<%@page import="com.jsplec.bbs.dto.CCartDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역</title>

<script type="text/javascript">
	function chk() {
		var chk = document.form.agree.checked;

		var Name = document.getElementById('userName_1');
		var Telno1 = document.getElementById('telNo_2');
		var Telno2 = document.getElementById('telNo_3');
		var zipNo = document.getElementById('zipNo');
		var Add1 = document.getElementById('roadAddrPart1');
		var Add2 = document.getElementById('addrDetail');

		if (Name.value == "") {
			alert("성명을 입력하세요");
			Name.focus();
			return false;
		}

		if (Telno1.value == "") {
			alert("연락처를 입력하세요");
			Telno1.focus();
			return false;
		}

		if (Telno2.value == "") {
			alert("연락처를 입력하세요");
			Telno2.focus();
			return false;
		}
		if (zipNo.value == "") {
			alert("우편번호를 입력하세요");
			zipNo.focus();
			return false;
		}

		if (Add1.value == "") {
			alert("주소를 입력하세요");
			Add1.focus();
			return false;
		}

		if (Add2.value == "") {
			alert("주소를 입력하세요");
			Add2.focus();
			return false;
		}
		if (!chk) {
			alert("약관에 동의하셔야 결제를 진행하실 수 있습니다.");
			return false;
		} else {
			return true;
		}
	}

	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("jusoPopup.jsp", "pop",
				"width=50,height=50, scrollbars=yes, resizable=yes");

		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}

	function jusoCallBack(roadAddrPart1, addrDetail, zipNo) {
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadAddrPart1.value = roadAddrPart1;
		document.form.addrDetail.value = addrDetail;
		document.form.zipNo.value = zipNo;

	}

	function copy() {

		if (document.getElementById('copyInfo').checked) {
			document.getElementById('userName_1').value = "${findUserInfo.userName}";
			document.getElementById('telNo_2').value = "${fn:substring(findUserInfo.userTelno,3,7)}";
			document.getElementById('telNo_3').value = "${fn:substring(findUserInfo.userTelno,7,12)}";
		} else {
			document.getElementById('userName_1').value = "";
			document.getElementById('telNo_2').value = "";
			document.getElementById('telNo_3').value = "";

		}

	}

	function getAdd() {

		if (document.getElementById('chkAdd').checked) {
			document.getElementById('zipNo').value = "${findUserInfo.zipNo}";
			document.getElementById('roadAddrPart1').value = "${findUserInfo.roadAddrPart1}";
			document.getElementById('addrDetail').value = "${findUserInfo.addrDetail}";
		} else {
			document.getElementById('zipNo').value = "";
			document.getElementById('roadAddrPart1').value = "";
			document.getElementById('addrDetail').value = "";

		}

	}
</script>
</head>

<style>
table {
	margin: 0px auto;
	width: 90%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

h2 {
	width: 17%;
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
	width: 75%;
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

.mt100 {
	margin-top: 100px;
}

li {
	float: right;
}

.cart_Buy_btn {
	border: 1px solid #E6E6E6;
	background-color: black;
	color: #fff;
	width: 130px;
	height: 35px;
}

.cart_Buy_btn a {
	color: #fff;
	line-height: 35px;
}
</style>
<body>

	<%@include file="./header/header.jsp"%>
		<form name="form" name="form" id="form" onsubmit="return chk()"
			action="kakaopay.jsp" method="get">
	<div class="detail_title">
		<h2>주문리스트</h2>
			<table>
				<tr>
					<th>사진</th>
					<th>상품명</th>
					<th>수량</th>
					<th>금액</th>

				</tr>
				<c:forEach items="${cartlist }" var="dto">
					<!-- 변수가 필요 dto -->

					<tr>
						<td><img src="${pageContext.request.contextPath}/pimage/${dto.pFile }" width="300"/></td>
						<td>${dto.pName }</td>
						<td><input type=hidden name="sell_price" value="sum">
							<input type="text" name="cartQuantity" id="quantity" style="border: 1px solid #fff;"
							class="quantity" value="${dto.cartQuantity }" size="3"
							readonly="readonly"></td>
						<td><input type="text" name="sum" class="price"
							value="${dto.sum }" size="11" readonly="readonly" style="border: 1px solid #fff; text-align: right;">원</td>

					</tr>
				</c:forEach>




			</table>
	</div>

	<div class="detail_title mt100">
		<h2>주문자 정보</h2>
		<div id="list"></div>
		<div id="callBackDiv">
			<table>

				<tr style="border-top: 1px solid black;">
					<td style="width: 30%; font-weight: bold;">이름</td>
					<td style="height: 55px; text-align: left;"><input
						placeholder="이름" type="text" style="border: 1px solid #fff;"
						name="userName" value="${findUserInfo.userName}"
						readonly="readonly" id="userName" style="height: 25px;"></td>

				</tr>

				<tr>
					<td style="width: 30%; font-weight: bold;">전화번호</td>
					<td style="height: 55px; text-align: left;"><select
						name='tel1' style="height: 30px; width: 60px;" size='1'>
							<option>010</option>
							<option>011</option>
							<option>017</option>
							<option>018
					</select> - <input type="text" name="tel2"
						value="${fn:substring(findUserInfo.userTelno,3,7)}" size='10'
						id="telNo2" style="height: 20px;"> - <input type="text"
						name="tel3" value="${fn:substring(findUserInfo.userTelno,7,12)}"
						size='10' id="telNo3" style="height: 20px;"></td>
				</tr>
				<tr>

					<td style="width: 30%; font-weight: bold;">EMAIL</td>
					<td style="height: 55px; text-align: left;"><input
						style="height: 20px;" type="text" name="eamilId" id="emailId"
						value="${fn:substringBefore(findUserInfo.userEmail,'@')}"
						placeholder="example"> <span>@</span> <input
						style="height: 20px;" name="textEmail" id="textEmail"
						value="${fn:substringAfter(findUserInfo.userEmail,'@')}"
						placeholder="example.com"> <select
						style="height: 30px; width: 110px;" id="select">
							<option value="" disabled selected>email선택</option>
							<option value="directly" id="textEmail">직접 입력</option>
							<option value="naver.com" id="naver.com">naver.com</option>
							<option value="gmail.com" id="gmail.com">gmail.com</option>
							<option value="hanmail.net" id="hanmail.net">hanmail.net</option>
					</select></td>
				</tr>
			</table>
		</div>
	</div>


	<div class="detail_title mt100">
		<h2>배송 정보</h2>
		<div style="margin-bottom: 20px; font-size: 13px; color: #1c1c1c;">
			<input type="checkbox" id="copyInfo" name="copyInfo"
				onclick="return copy()"> 위 정보와 같음
		</div>
		<table>
			<tr style="border-top: 1px solid black;">
				<td style="width: 30%; font-weight: bold;">이름</td>
				<td style="height: 55px; text-align: left;"><input
					placeholder="이름" type="text" name="userName" id="userName_1"
					style="height: 25px;"></td>
			</tr>
			<%-- <c:set var="userTelNo" value="${findUserInfo.userTelno}"/> 	   --%>
			<tr>
				<td style="width: 30%; font-weight: bold;">전화번호</td>
				<td style="height: 55px; text-align: left;"><select name='tel1'
					style="height: 30px; width: 60px;" size='1'>
						<option>010</option>
						<option>011</option>
						<option>017</option>
						<option>018
				</select> - <input type="text" name="tel2" size='10' id="telNo_2"
					style="height: 20px;"> - <input type="text" name="tel3"
					size='10' id="telNo_3" style="height: 20px;"></td>
			</tr>
			<tr>
				<td style="width: 30%; font-weight: bold;" rowspan="3">주소</td>
				<td
					style="height: 55px; border-bottom: 1px solid #fff; text-align: left;"><input
					placeholder="우편번호" type="text" style="width: 50px; height: 20px;"
					id="zipNo" name="zipNo" onclick="goPopup();" /> &nbsp; <input
					type="button" onClick="goPopup();" value="우편번호 찾기" style="width: 100px; height: 30px;" /> <input
					type="checkbox" id="chkAdd" name="chkAdd" onclick="return getAdd()">
					주문자 주소 입력</td>
			</tr>
			<tr>
				<td style="border-bottom: 1px solid #fff; text-align: left;"><input
					placeholder="도로명 주소" type="text"
					style="width: 500px; height: 20px;" id="roadAddrPart1"
					name="roadAddrPart1" readonly="readonly" /></td>
			</tr>
			<tr>
				<td style="height: 55px; text-align: left;"><input
					placeholder="고객입력 상세주소" type="text"
					style="width: 500px; height: 20px;" id="addrDetail"
					name="addrDetail" /></td>
			</tr>

		</table>
	</div>



	<div class="detail_title mt100">
		<h2>결제 정보</h2>
		<table>
			<tr style="border-top: 1px solid black;">
				<td><input type="radio" checked="checked">KAKAO PAY</td>
				<td><input type="radio">SAMSUNG PAY</td>
				<td><input type="radio">일반결제</td>
			</tr>


		</table>
	</div>

	<div class="detail_title mt100">
		<h2>주문자 동의</h2>
		<table>
			<tr style="border-top: 1px solid black;">
				<td style="font-weight: bold;">주문 동의</td>
				<td style="text-align: left;"><input type="checkbox"
					name="agree"> 상기 결제정보를 확인하였으며, 구매진행에 동의합니다.</td>
			</tr>
			<tr>
				<td style="font-weight: bold;">최종 결제 금액</td>
				<td>
					<h2 style="font-weight: bold; text-align: left;"><%=request.getAttribute("totalPrice")%>원
					</h2>
				</td>
			</tr>
			
			<tr>
				<td style="font-weight: bold;">주문 확인</td>
				<td style="text-align: left;">
					<%
			ArrayList<CCartDto> list = (ArrayList<CCartDto>) request.getAttribute("cartlist");
			int size = list.size();
			for (CCartDto cartlist : list) {
				out.println( cartlist.getpName() + "&nbsp;&nbsp;");
			}
			 out.println(list.get(0).getpName());
			out.println("총 " +  size + " 개");
		%>
				</td>
			</tr>
			
		</table>
		<br><br>
		<input type="hidden" name="productname"
			value="<%=list.get(0).getpName()%>"> 
			<input type="hidden" name="size" value="<%=size%>"> 
			<input type="hidden" name="totalPrice" value="<%=request.getAttribute("totalPrice")%>"> 
			
			<input type="submit" value="주문하기" style="width:100px; height:30px;"> 
			<input type="button" value=주문취소 style="width:100px; height:30px;" onClick="location.href='cartlist.do';">

	</div>
		</form>

	
</body>
</html>