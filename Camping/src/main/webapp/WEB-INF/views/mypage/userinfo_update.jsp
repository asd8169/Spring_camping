<%@page import="com.jsplec.bbs.dao.CUserInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="width=device-width, initial-scale =1">
<link rel="stylesheet" href="css/custom.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<title>회원정보 수정</title>

<!-- 체크박스 스타일 -->
<style>
.container {
	width: 28%;
	margin: 0 auto;
	border: 1px solid #E6E6E6;
	text-align: left;
	padding: 10px 30px;
	margin-bottom: 200px;
}

input {
	border: 1px solid #E6E6E6;
}

#signupimg {
	float: right;
}

.signupimg2 {
	float: right;
	width: 100px;
	/* background-image: url('./image/signup.png'); */
	padding-top: 20px;
}

#callBackDiv {
	margin-bottom: 100px;
}
</style>





<!-- 주소 API script -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

$(function() {
    $('#select').change(function() {
        if ($('#select').val() == 'directly') {
            $('#textEmail').attr("disabled", false);
            $('#textEmail').val("");
            $('#textEmail').focus();
        } else {
            $('#textEmail').val($('#select').val());
        }
    })
});


function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("jusoPopup.jsp","pop","width=50,height=50, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadAddrPart1, addrDetail, zipNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.form.roadAddrPart1.value = roadAddrPart1;
	document.form.addrDetail.value = addrDetail;
	document.form.zipNo.value = zipNo;
	
}



</script>


</head>



<!-- 폼 입력 체크하는 곳-->
<script type="text/javascript">

window.onload = function(){
	
	document.getElementById('form').onsubmit = function(){
	
	var userId = document.getElementById('userId');
	var userPw = document.getElementById('userPw');
	var userPw2 = document.getElementById('userPw2');
	var userName = document.getElementById('userName');
	var telNo = document.getElementById('telNo');
	var addrDetail = document.getElementById('addrDetail');
	var textEmail = document.getElementById('textEmail');
	
	if(userId.value == ""){
		alert("아이디를 입력하세요.");
		userId.focus();
		return false;
	}
	
	/* if(form.idDuplication.value != "idCheck"){
		alert("아이디 중복체크를 해주세요.");
		return false;
	} */
	
	if(userPw.length == 0){
		alert("비밀번호를 입력해하세요");
		userPw.focus();
		return false;
	}
	
	if(userPw2.value == ""){
		alert("비밀번호 확인을 위해 다시 한번 입력해주세요.");
		userPw.focus();
		return false;
	}
	
	if(userName.value == ""){
		alert("이름을 입력하세요");
		userName.focus();
		return false;
	}

	if(telNo.value == ""){
		alert("연락 가능한 번호를 입력하세요");
		telNo.focus();
		return false;
	}

	if(addrDetail.value == ""){
		alert("주소를 입력하세요");
		addrDetail.focus();
		return false;
	}
	
	if(textEmail.length== 0){
		alert("이메일을 입력하세요");
		emailId.focus();
		return false;
	}
	
	else{
		alert("입력이 완료되었습니다.")
	}
		
	};
	
};

// 아이디 중복 체크
function confirmId(){
	if(document.form.id.value == ""){
		alert("ID를 입력하세요");
		return false;
	}
	else if((document.form.userId.value < "0" || document.form.userId.value > "9") && (document.form.userId.value < "A" || document.form.userId.value > "Z") && (document.form.userId.value < "a" || document.form.userId.value > "z")){
		alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
		return false;
	} else {
	url = "confirmId.jsp?userId=" + document.form.userId.value;
	open(url,"confirm","toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
	}
}




// 비밀번호 체크
 function check_pw(){

            var pw = document.getElementById('userPw').value;
            var pw2 = document.getElementById('userPw2').value;
            var SC = ["!","@","#","$","%"];
            var check_SC = 0;
            console.log("pw : " + pw);
            console.log("pw2 : " + pw2);
        
 
            if(pw.length < 6 || pw2.length>16){
                window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('userPw').value='';
            }
            
/*             for(var i=0;i<SC.length;i++){
                if(pw.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }
            
            if(check_SC == 0){
                window.alert('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
                document.getElementById('userPw').value='userPw';
            } 
             */
            if(document.getElementById('userPw').value !='' && document.getElementById('userPw2').value!=''){
                if(document.getElementById('userPw').value==document.getElementById('userPw2').value){
                  document.getElementById('check').innerHTML='비밀번호가 일치합니다.';
                  document.getElementById('check').style.color='blue';
                }
                else{
                  document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                  document.getElementById('check').style.color='red';
                }
              }
              if(pw.length == 0 || pw2.length == 0){
                  document.getElementById('check').innerHTML='';
            
	}           
}           
      
 /*  //비밀번호 일치 여부 체크
      $(function(){ $("#checkOk").hide();
      $("#checkFail").hide();
      	$("input").keyup(function(){ var pwd1=$("#userPw").val();
      	
      	
      	var pwd2=$("#userPw2").val();
      		if(pwd1 != "" || pwd2 != ""){
      		if(pwd1 == pwd2){
      			$("#checkOk").show();
      			$("#checkFail").hide();
      			$("#submit").removeAttr("disabled");
      		}else{ $("#checkOk").hide();
      			$("#checkFail").show();
      			$("#submit").attr("disabled", "disabled");
      			}
      		}
      	});
      });  */


	

  			 /*   if(document.getElementById('userPw').value !='' && document.getElementById('userPw2').value!=''){
	               if(document.getElementById('userPw').value==document.getElementById('userPw2').value){
	                   document.getElementById('checkOk').innerHTML='비밀번호가 일치합니다.'
	                   document.getElementById('checkOk').style.color='blue';
	               }
	               else{
	                   document.getElementById('checkFail').innerHTML='비밀번호가 일치하지 않습니다.';
	                   document.getElementById('checkFail').style.color='red'; 
	               }
	           }
        }  */







function inputIdChk(){
	document.userInfo.idDuplication.value ="idUncheck";
}
 function gotohome(home){ 
	 home.action='main.do'; 
	 home.submit(); 
return true; }

       
</script>


<!-- ID 중복체크 -->




<body>
	<%@include file="../header/header.jsp"%>
	<h2 style="text-align: center; margin-top: 100px;">MYPAGE EDIT</h2>
	<div class="container">
	
	<div id="signupimg">

			<div class="signupimg2">
				<img src="./image/signup.png" width="100px;">
				<!-- img추가  -->

			</div>

		</div>

		<form action="userinfoUpdate.do" name="form" id="form" method="get">
			<div id="list"></div>
			<div id="callBackDiv">
				<table>
					<tr>
						<td style="height: 55px;"><input placeholder="ID" type="text"
							name="userId" id="userId" value="${findUserInfo.userId}"
							readonly="readonly" maxlength="20"
							style="height: 25px; width: 110px;"></td>
						<!-- &nbsp; <input style="height:30px; width:80px;" type="button" class ="btn btn=primary" value="중복확인" onclick="confirmId(this.form);"></td> -->
					</tr>
					<tr>
						<td style="height: 55px;"><input placeholder="PW"
							type="password" name="userPw" id="userPw"
							style="width: 250px; height: 25px;" onchange="check_pw()"></td>
					</tr>
					<tr>
						<td style="height: 55px;"><input placeholder="PW Check"
							type="password" name="userPw2" id="userPw2" onchange="check_pw()"
							style="width: 250px; height: 25px;"> &nbsp; <span
							id="check"></span></td>
					</tr>
					<tr>
						<td style="height: 55px;"><input placeholder="이름" type="text"
							name="userName" value="${findUserInfo.userName}"
							readonly="readonly" id="userName" style="height: 25px;"></td>
					</tr>
					<%-- <c:set var="userTelNo" value="${findUserInfo.userTelno}"/> 	   --%>
					<tr>
						<td style="height: 55px;"><select name='tel1'
							style="height: 30px; width: 60px; border: 1px solid #E6E6E6;" size='1'>


								<option>010</option>
								<option>011</option>
								<option>017</option>
								<option>018
						</select> - <input type="text" name="tel2"
							value="${fn:substring(findUserInfo.userTelno,3,7)}" size='10'
							id="telNo" style="height: 20px;"> - <input type="text"
							name="tel3" value="${fn:substring(findUserInfo.userTelno,7,12)}"
							size='10' id="telNo" style="height: 20px;"></td>
					</tr>



					<tr>
						<td style="height: 55px;"><input placeholder="우편번호"
							type="text" style="width: 50px; height: 20px;" id="zipNo"
							name="zipNo" value="${findUserInfo.zipNo}" onclick="goPopup();" />
							&nbsp; <input type="button" onClick="goPopup();" value="우편번호 찾기" style="width: 100px; height: 30px;"/>
						</td>
					</tr>

					<tr>
						<td><input placeholder="도로명 주소" type="text"
							style="width: 500px; height: 20px;" id="roadAddrPart1"
							name="roadAddrPart1" value="${findUserInfo.roadAddrPart1}"
							readonly="readonly" /></td>
					</tr>

					<tr>
						<td style="height: 55px;"><input placeholder="고객입력 상세주소"
							type="text" style="width: 500px; height: 20px;" id="addrDetail"
							name="addrDetail" value="${findUserInfo.addrDetail}" /></td>
					</tr>


					<tr>
						<td style="height: 55px;"><input style="height: 20px;"
							type="text" name="eamilId" id="emailId"
							value="${fn:substringBefore(findUserInfo.userEmail,'@')}"
							placeholder="example"> <span>@</span> <input
							style="height: 20px;" name="textEmail" id="textEmail"
							value="${fn:substringAfter(findUserInfo.userEmail,'@')}"
							placeholder="example.com"> <select
							style="height: 30px; width: 110px; border: 1px solid #E6E6E6;" id="select">
								<option value="" disabled selected>email선택</option>
								<option value="directly" id="textEmail">직접 입력</option>
								<option value="naver.com" id="naver.com">naver.com</option>
								<option value="gmail.com" id="gmail.com">gmail.com</option>
								<option value="hanmail.net" id="hanmail.net">hanmail.net</option>
						</select></td>
					</tr>
					<tr>
						<td style="text-align: center;"><input
							class="btn btn-primary pull-right" style="width: 100px; height: 30px;margin-top:30px;" type="submit" value="저장"
							style="border-radius: 5px; width: 100px; height: 30px;" /> <input
							type="reset" value="다시입력"
							style="border-radius: 5px; width: 100px; height: 30px;" /> <input
							type='button' value='홈으로' onclick='return gotohome(this.form);'
							style="border-radius: 5px; width: 100px; height: 30px;" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>