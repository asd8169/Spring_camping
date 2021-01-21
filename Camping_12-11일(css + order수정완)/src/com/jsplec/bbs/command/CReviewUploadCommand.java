package com.jsplec.bbs.command;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CReviewDao;
import com.jsplec.bbs.dto.CReviewDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class CReviewUploadCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String uploadPath = request.getServletContext().getRealPath("/image/");
		int max = 1024 * 1024 * 10;
		String encoding = "UTF-8";
		System.out.println(uploadPath);
				// upload는 폴더명 / 폴더의 경로를 구해옴
		/* out.print(uploadPath); */
		MultipartRequest multi;
		try {
			multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, 
					uploadPath, // 파일을 저장할 디렉토리 지정
					max, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					encoding, // 인코딩 방식 지정
					new DefaultFileRenamePolicy());// 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			
					String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());  //현재시간
					String filename = "";
					String rfile = multi.getFilesystemName("reviewFile");
					String f_ext = "";
					
					if(rfile != null){
						File file_copy = new File(uploadPath+"/"+rfile);
						if(file_copy.exists()) {
							f_ext = rfile.substring(rfile.length()-3,rfile.length());
							File file2 = new File(uploadPath+"/"+now+"."+f_ext);
							file_copy.renameTo(file2);
							filename = file2.getName();
							
					//넘아감
					String userId = multi.getParameter("userId");
					String reviewNo = multi.getParameter("reviewNo");
					String orderNo = multi.getParameter("orderNo");
					String productNo = multi.getParameter("pNo");
					
					//넘아감
					String reviewContent = multi.getParameter("reviewContent");
							
					
					session.setAttribute("userId", userId);
					session.setAttribute("orderNo", orderNo);
					session.setAttribute("productNo", productNo);
					session.setAttribute("reviewContent", reviewContent);
					session.setAttribute("reviewFile", filename);
					
					
					System.out.println("userId 이건가?" + userId);	
					System.out.println("reviewNo 이건가?" + reviewNo);
					System.out.println("orderNo 이건가?" + orderNo);
					System.out.println("productNo 이건가?" + productNo);
					System.out.println("reviewContent 이건가?" + reviewContent);
				}
					}
			
				} catch (IOException e) {
			e.getStackTrace();
			System.out.println(e);
		} // 업로드 종료
	}
}	