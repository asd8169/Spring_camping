<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function() {
    $('#select').change(function() {
        if ($('#select').val() == 'directly') {
            $('#pStock').attr("disabled", false);
            $('#pStock').val("");
            $('#pStock').focus();
        } else {
            $('#pStock').val($('#select').val());
        }
    })
});

</script>	
	
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
		<div>
		<form action="register" method="post" enctype="multipart/form-data">
		<table>
			<tr>
			<td><H3>PRODUCT</H3></td>
			</tr>
			<tr>
			<td> 상품명 : <input type="text" name="pName" id="pName"></td>
			</tr>
			<tr>
			<td> 카테고리 : <select name="pCategory" style="height: 30px; width:70px;" size='1' >
					     <option> Tables </option> 
					     <option> Chairs </option>
					     <option> Stools </option>
					     <option> Storage </option>
					     <option> Collaboration </option>
					     </select></td>
			</tr>
			<tr>
			<td> 가격 : <input type="text" name="pPrice" id="pPrice"></td>
			</tr>
			<tr>
			<td> 재고량 : <input style="height:20px; width:40px;" name="pStock" id="pStock" placeholder="ex)10">
							<select style="height: 30px; width:90px;" id="select">
		            		<option value="" disabled selected>재고량 선택</option>
		            		<option value="directly" id="pStock">직접 입력</option>
		            		<option value="10" id="10">10</option>
		            		<option value="50" id="50">50</option>
		            		<option value="100" id="100">100</option>
		            		</select></td>
			</tr>
			<tr>
			<td>파일첨부(썸네일) : <input type="file" name="pFile"></td>
			</tr>
			<tr>
			<td>파일첨부(상세페이지) : <input type="file" name="pSubFile"></td>
			</tr>
			<!--  <tr>
			<td>해시태그 : # <input style="height:20px; width:300px;" type="text" name="pHashtag" id="pHashtag" placeholder="책상, 상, 테이블"></td>
			</tr>-->
			<!--  <tr>		
			<td><textarea placeholder="상품 설명을 입력해주세요." rows="10" cols="50" name="reviewContent"></textarea></td>
			</tr>-->
			<tr>
			<td><input type="submit" value="상품 등록"></td>
			</tr>
		</table>
			</form>
		</div>
	</body>
</html>
