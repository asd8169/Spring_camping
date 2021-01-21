<%@page import="com.jsplec.bbs.dao.CUserInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
	<c:choose>



    <c:when test="${findId ne null}">
        <h3> ${userName}님의 아이디는 ${findId}입니다.<strong>
    </c:when>

    <c:otherwise>
       <h3>	없는 user 정보입니다. <strong>
    </c:otherwise>


	</c:choose>

   

   
   
   
   
   
   
   
   
    <input type="button" id="close" value="확인">




	<script>


    document.getElementById("close").onclick = function(){
	close();
	}

    
	</script>