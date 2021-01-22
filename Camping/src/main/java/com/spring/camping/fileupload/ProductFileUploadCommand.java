package com.spring.camping.fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.spring.camping.icommand.ICommand;

public class ProductFileUploadCommand implements ICommand {

	@Override
	public void execute(SqlSession sqlSession, HttpServletRequest request, Model model, HttpSession session)
			throws ServletException, IOException {
		
		System.out.println("업로드 커맨드 들어옴 ");
		String uploadPath = request.getSession().getServletContext().getRealPath("/productimage/");
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
			
			System.out.println("멀티 잘 지나감");
					String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());  //현재시간
					String filename = "";
				    String filename2 = "";
				    String rfile = multi.getFilesystemName("pFile");
				    String rfile2 = multi.getFilesystemName("pSubFile");
				    String f_ext = "";
				    if(rfile != null){
				          File file_copy = new File(uploadPath+"/"+rfile);
				          File file_copy2 = new File(uploadPath+"/"+rfile2);
				          	if(file_copy.exists()) {
				          		f_ext = rfile.substring(rfile.length()-3,rfile.length());
				          		File file2 = new File(uploadPath+"/"+now+"."+f_ext);
				          		File file3 = new File(uploadPath+"/"+now+"detail."+f_ext);
				          
				          		file_copy.renameTo(file2);
				          		file_copy2.renameTo(file3);
				          		filename = file2.getName();
				          		filename2 = file3.getName();
				          	}
				    }
				
				    
				String pName = multi.getParameter("pName");
				String pCategory = multi.getParameter("pCategory");
				String pPrice = multi.getParameter("pPrice");			
				String pStock = multi.getParameter("pStock");	
				
				
				session.setAttribute("pFile", filename);
				System.out.println(filename);
				session.setAttribute("pSubFile", filename2);
				session.setAttribute("pName", pName);
				System.out.println(pName);
				session.setAttribute("pCategory", pCategory);
				session.setAttribute("pPrice", pPrice);
				session.setAttribute("pStock", pStock);
						
				} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
			System.out.println("멀티 실패");
			
		} // 업로드 종료

	}

}
