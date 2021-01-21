<%@page import="java.io.IOException"%>
<%@page import="com.jsplec.bbs.dao.CReviewDao"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<% 

		String directory = request.getServletContext().getRealPath("/image/"); 
   		int maxSize = 10 * 1024*1024;
   		String encoding = "UTF-8";
   		
   		
   		
		try {
			System.out.println("multi전");
			MultipartRequest multi = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
			
			System.out.println("multi후");
			
			String userId = multi.getParameter("userId");
			String reviewNo = multi.getParameter("reviewNo");
			String orderNo = multi.getParameter("orderNo");
			String productNo = multi.getParameter("productNo");
			String reviewContent = multi.getParameter("reviewContent");
			String reviewDate = "";
			//file 이란 이름은 wineList.jsp에 있는 name ="file" / DB에 넣기위해 스트링 변환
			
			String reviewFile = multi.getOriginalFileName("reviewFile");         // 실제 파일 이름
			String orgfileName = multi.getFilesystemName ("reviewFile");      // 시스템상 파일 이름( 중복시 파일 명 자동 변경
			
			// 확장자 정해주기
			if(reviewFile.endsWith(".doc") && reviewFile.endsWith(".hwp") && 
					reviewFile.endsWith(".pdf") && reviewFile.endsWith(".xls")){
				File file = new File(directory + orgfileName);
				file.delete(); 
				
				System.out.println("업로드할 수 없는 확장자 입니다.");
			}else{
				
				// DAO를 불러서 위에 불러온 값과 이미지를 저장 시킴
				CReviewDao dao = new CReviewDao();
				dao.registerReview(userId, reviewNo, orderNo, productNo, reviewContent, reviewFile, reviewDate);
				System.out.println("파일명 : " + reviewFile + "<br>"); 
				System.out.println("실제 파일명 : " + orgfileName + "<br>"); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.setContentType("text/html);charset = utf-8");
		response.sendRedirect("check.jsp");
%>



