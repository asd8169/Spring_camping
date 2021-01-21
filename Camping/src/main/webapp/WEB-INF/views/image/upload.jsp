<%@page import="java.io.IOException"%>
<%@page import="com.jsplec.bbs.dao.CReviewDao"%>
<%@page import="java.io.File"%>
<%@page import="javax.websocket.SendResult"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/* String id = request.getParameter("id");
	out.print(id); // request.getParameter() 사용 불가  */
	
	//사용자가 전송한 파일 'image'파일로 간다. %>
	
	<form action="uploadFinish01" method="post" enctype="multipart/form-data">
	이미지 찾기 :  <input type="file" name="reviewFile"><br><br>
	<input type="submit" value="업로드">
	</form>
<!-- 업로드 된 파일을 확인하는 폼으로 이동 / 위에서 구한 데이터를 hidden 방식으로 전송 -->

