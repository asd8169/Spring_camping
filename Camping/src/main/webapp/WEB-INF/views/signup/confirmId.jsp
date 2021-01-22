<%@page import="com.jsplec.bbs.dao.CUserInfoDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String userId = request.getParameter("userId");
	CUserInfoSearchDao dao = CUserInfoSearchDao.getInstance();
	boolean result = dao.checkId(userId);
	
	if(result){
%>
		<center>
		<br><br>
		</center>
		<h4> 이미 사용중인 ID입니다. </h4>
	<% } else { %>
		<center>
		<br><br>
		<h4> 입력하신 <%=userId%>는 사용하실 수 있는 ID입니다. </h4>
		</center>
	<% } %>
	<input type="button" id="close" value="확인">


<script>
	document.getElementById("close").onclick = function(){
	close();
}


</script>	
