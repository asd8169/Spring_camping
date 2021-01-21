<%@page import="com.jsplec.bbs.dto.CCartDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세정보 화면입니다</title>


<script language="JavaScript">
	// 위시리스트에 추가하기 누르면 나오는 알림
	function like() {
		switch (
<%=session.getAttribute("wishcheck")%>
	) {
		case 0:
			alert("위시리스트에 반영되었습니다.");
			break;
		case 1:
			alert("위시리스트에서 삭제되었습니다.");

			break;
		default:
			break;
		}
	}
	// 장바구니에 추가하기 누르면 나오는 알림
	function addcart() {
		switch (
<%=session.getAttribute("cartcheck")%>
	) {
		case 0:
			alert("장바구니에 성공적으로 추가되었습니다.");
			break;
		case 1:
			alert("장바구니에 이미 존재합니다. 수량은 장바구니에서 수정 가능합니다.");

			break;
		default:
			break;
		}
	}

	//-----------------------------------------------------------
	// 수량에 따른 가격 변화
	//-----------------------------------------------------------

	var sell_price;
	var cartQuantity;

	function init() {
		sell_price = document.form.sell_price.value;
		cartQuantity = document.form.cartQuantity.value;
		document.form.sum.value = sell_price;
		change();
	}

	function add() {
		hm = document.form.cartQuantity;
		sum = document.form.sum;
		hm.value++;

		sum.value = parseInt(hm.value) * sell_price;
	}

	function del() {
		hm = document.form.cartQuantity;
		sum = document.form.sum;
		if (hm.value > 1) {
			hm.value--;
			sum.value = parseInt(hm.value) * sell_price;
		} else {
			alert("수량체크를 다시 해주세요");
		}
	}

	function change() {
		hm = document.form.cartQuantity;
		sum = document.form.sum;

		if (hm.value < 0) {
			hm.value = 0;
		}
		sum.value = parseInt(hm.value) * sell_price;
	}
	//-----------------------------------------------------------
	/* window.onload = function(){
	
	 document.getElementById('target').onsubmit = function(){
	
	 var bName = document.getElementById('bName');
	 var bTitle = document.getElementById('bTitle');
	 var bContent = document.getElementById('bContent');
	
	 if(bName.value == ""){
	 alert("성명을 입력하세요");
	 bName.focus();
	 return false;
	 }
	
	 if(bTitle.value == ""){
	 alert("제목을 입력하세요");
	 bTitle.focus();
	 return false;
	 }
	
	 if(bContent.value == ""){
	 alert("내용을 입력하세요");
	 bContent.focus();
	 return false;
	 }
	 else{
	 alert("입력이 완료되었습니다.")
	 }
	
	 };
	
	 }; */
</script>



</head>
<style>

/* 201207 세미 변경 */
table {
	margin: 20px auto;
	width: 70%;
	border-top: 1px solid #E6E6E6;
	border-collapse: collapse; /* table 간격 없애기 */
}

h2 {
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

.product_ptwrap {
	width: 80%;
	height: 500px;
	text-align: center;
	margin: 0 auto;
	margin-top: 50px;
}

.product_view_side {
	position: fixed;
	top: 200px;
	right: 50px;
	width: 20%;
}

.cart_Buy_btn {
	border: 1px solid #E6E6E6;
	background-color: black;
	color: #fff;
	width: 110px;
	height: 30px;
}

.cart_Buy_btn2 {
	display: inline-block;
	color: #231f20;
	text-align: center;
	border: 1px solid #231f20;
	background: #fff;
	width: 110px;
	height: 30px;
	font-size: 12px;
}
</style>
<body onload="init();">

	<%@include file="./header/header.jsp"%>
	<div class="product_ptwrap"><img src="${pageContext.request.contextPath}/pimage/${content_view.pFile}" width="300"/></div>
	<br>
	<div class="product_ptwrap"><img src="${pageContext.request.contextPath}/pimage/${content_view.pSubFile}" width="400"/></div>


	<div class="product_view_side">
			<form name="form" method="get">
			<table>
			
<tr>
					<td colspan="3"><input type="text" name="bName" size="10" style="font-weight: bold;font-size:15	px;border: 1px solid #fff; " value="${content_view.pName}"></td>
					
				</tr>
			<tr>
				<td>수량</td>
					<td><input type=hidden name="sell_price"
						value="${content_view.pPrice}"></td>
					<td><input type="text" name="cartQuantity" value="1" size="3"
						onchange="change();" style="border: 1px solid #E6E6E6;"> <input
						type="button" value=" + " onclick="add();"
						style="border: 1px solid #E6E6E6; background-color: black; color: #fff;">
						<input type="button" value=" - " onclick="del();"
						style="border: 1px solid #E6E6E6; background-color: #fff; color: black;">
				
					</td>
				</tr>

				<tr>
					<td>금액</td>
					<td colspan="2"><input type="text" name="sum" size="11"
						style="border: 1px solid #fff; text-align: right;" readonly>원</td>

				</tr>
				<tr>
					<td colspan="1"><input type="hidden" name="pNo"
						value=<%=request.getParameter("pNo")%>> <input
						type="submit" formaction="addcart.do" value="ADD TO CART"
						class="cart_Buy_btn" onclick="addcart()"></td>
					<td colspan="2"><input type="submit" formaction="cart.do"
						value="BUY IT NOW" onclick="addcart()" class="cart_Buy_btn">
					</td>
				</tr>

				<tr>
					<td>
						<input type="submit" id="rec_update" formaction="recUpdate.do" value="LIKE" onclick="like()" class="cart_Buy_btn2">
					</td>

					<td colspan="2">
							<input type="submit" formaction="wishlist.do" id="rec_update" value="WISH LIST" class="cart_Buy_btn2">
						</td>
				</tr>

			</table>
</form>
	
		<br>

	</div>

	<div>
		<form id="checklist">
			<div class="detail_title">
				<h2>REVIEW LIST</h2>
			</div>
			<table>
				<tr>


					<th>NO.</th>
					<th style="width: 30%;">PRODUCT</th>
					<th style="width: 30%;">REVIEW</th>
					<th style="width: 20%;">WRITER</th>
					<th>DATE</th>
				</tr>
				<c:forEach items="${CReviewDto}" var="CReviewDto">
					<tr>
						<td>${CReviewDto.reviewNo}</td>
						<td>${CReviewDto.pNo}</td>
						<td><a
							href="review_view.do?pNo=${CReviewDto.pNo}&reviewNo=${CReviewDto.reviewNo}&userNo=${CReviewDto.userNo}&reviewContent=${CReviewDto.reviewContent}&reviewFile=${CReviewDto.reviewFile}">${fn:substring(CReviewDto.reviewContent,0,10)}...</a></td>
						<td>${CReviewDto.userNo}</td>
						<td>${CReviewDto.reviewDate}</td>
					</tr>
				</c:forEach>

			</table>

		</form>
	</div>


	<!-- 페이징 -->

	<table>

		<tr>
			<!-- startPage가 1이 아닐때  -->
			<c:if test="${startPage!=1}">

				<!-- 이전 버튼만들기 -->
				<a href="./product.do?&page=${startPage-1}">[이전]</a>
			</c:if>

			<!-- for문으로 번호 생성 -->
			<c:forEach var="i" begin="${startPage}" end="${endPage}"
				varStatus="cnt">
				<a href="./product.do?&page=${i}">[ <font color="#000000" /> <c:if
						test="${currentPage == i}">
						<font color="#bbbbbb" />
					</c:if> ${i} </font>]
				</a>
			</c:forEach>

			<!— endPage가 totalPage와 값이 다를때 —>
			<c:if test="${endPage!=totalPage}">
				<a href="./product.do?&page=${endPage+1}">다음 ▶</a>
			</c:if>

		</tr>

	</table>



	<!-- 상세페이지 QnA -->
	<div>
		<form id="checklist">
			<div class="detail_title">
				<h2>Q&A LIST</h2>
			</div>
			<table>
				<!-- admin으로 로그인 시 체크박스 생성해야함  -->
				<tr>

					<%
						//관리자 로그인 시 checkbox 나옴
						if (session.getAttribute("sessionuserId") != null
								&& session.getAttribute("sessionuserId").equals("admin")) {
					%>
					<th><input type="checkbox" name="admincheckbox"> <%
 	}
 %>
					<th>NO.</th>
					<th style="width: 30%;">PRODUCT</th>
					<th style="width: 30%;">TITLE</th>
					<th style="width: 20%;">ID</th>
					<th>DATE</th>
				</tr>
				<c:forEach items="${list}" var="qnadto">
					<tr>
						<%
							//관리자 로그인 시 checkbox 나옴
								if (session.getAttribute("sessionuserId") != null
										&& session.getAttribute("sessionuserId").equals("admin")) {
						%>
						<td><input type="checkbox" name="admincheckbox"></td>
						<%
							}
						%>
						<td>${qnadto.qnaNo}</td>
						<td>${qnadto.pName}</td>

						<!-- <!— 비밀글 —> -->
						<c:choose>
							<c:when test="${session.sessionuserId eq 'admin'}">
								<td><a href="qna_view.do?qnaNo=${qnadto.qnaNo }">${qnadto.qnaTitle}</a></td>
							</c:when>


							<c:when
								test="${(qnadto.userName eq sUser)} && ${(qnadto.qnaSecret eq 'y')} ">
								<td><a
									href="qna_view.do?qnaNo=${qnadto.qnaNo }&userName=${qnadto.userName }">비밀글입니다.</a></td>
							</c:when>
							<c:when test="${(qnadto.qnaSecret eq 'y') && (sUser ne 'admin')}">
								<td><a href="javascript:alert('비밀글입니다');"
									onfocus="this.blur()">비밀글입니다.</a></td>
							</c:when>


							<c:otherwise>
								<td><a
									href="qna_view.do?qnaNo=${qnadto.qnaNo }&userName=${qnadto.userName }">${qnadto.qnaTitle}</a></td>
							</c:otherwise>

						</c:choose>




						<td>${qnadto.userName}</td>
						<td>${qnadto.qnaDate}</td>
					</tr>
				</c:forEach>

				<tr>
					<%
						//관리자 로그인 시 write 위치 변경
						if (session.getAttribute("sessionuserId") != null
								&& session.getAttribute("sessionuserId").equals("admin")) {
					%>
					<td colspan="6"><a href="qna_write.jsp">WRITE</a></td>
					<%
						}
					%>
					<%
						//관리자 로그인 시 write 위치 변경
						if (session.getAttribute("sessionuserId") != null
								&& !session.getAttribute("sessionuserId").equals("admin")) {
					%>
					<td colspan="5"><a href="qna_write.jsp">WRITE</a></td>
					<%
						}
					%>
				
			</table>

		</form>
	</div>

	<!-- 페이징 -->

	<table>

		<tr>
			<!-- startPage가 1이 아닐때  -->
			<c:if test="${startPage!=1}">

				<!-- 이전 버튼만들기 -->
				<a href="./product.do?&page=${startPage-1}">[이전]</a>
			</c:if>

			<!-- for문으로 번호 생성 -->
			<c:forEach var="i" begin="${startPage}" end="${endPage}"
				varStatus="cnt">
				<a href="./product.do?&page=${i}">[ <font color="#000000" /> <c:if
						test="${currentPage == i}">
						<font color="#bbbbbb" />
					</c:if> ${i} </font>]
				</a>
			</c:forEach>

			<!— endPage가 totalPage와 값이 다를때 —>
			<c:if test="${endPage!=totalPage}">
				<a href="./product.do?&page=${endPage+1}">다음 ▶</a>
			</c:if>

		</tr>

	</table>

</body>
</html>