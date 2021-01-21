<%@page import="com.jsplec.bbs.dao.CUserInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   
   
   <c:choose>

    <c:when test="${findPw ne null}">
  	<h3>${userId}님의 PASSWORD는 <strong>${fn:substring(findPw, 0, 3)}
    <c:forEach begin="1" end="${fn:length(findPw)-3}">
	*
	</c:forEach>
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