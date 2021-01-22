package com.spring.camping.admin.product.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.camping.fileupload.ProductFileUploadCommand;
import com.spring.camping.icommand.ICommand;

@Controller
@RequestMapping("admin/")
public class RegisterProductController {
	
	//xml과 java연결
	@Autowired
	private SqlSession sqlSession;
	
	ICommand command = null;

//	// 상품 등록 폼 
	@RequestMapping("product_write")
	public String WriteForm() {
		
		return "admin/product_write";
	}
	
	
	// 상품 등록
	@RequestMapping("register")
	public String RegisterProduct(HttpServletRequest request, Model model, HttpSession session) throws ServletException, IOException { {

		session = request.getSession();
		
		command = new ProductFileUploadCommand();
		command.execute(sqlSession, request, model, session);
		
		System.out.println("업로드 커맨드 끝남 ");
		
		String pName = (String) session.getAttribute("pName");
		String pCategory = (String) session.getAttribute("pCategory");
		String pPrice = (String) session.getAttribute("pPrice");
		String pFile = (String) session.getAttribute("pFile");
		String pSubFile = (String) session.getAttribute("pSubFile");
		String pStock = (String) session.getAttribute("pStock");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.registerProductDao(pName, pCategory, pPrice, pFile, pSubFile, pStock);
	
		System.out.println(request.getParameter("pName"));
		
		return "redirect:admin_Product_list";
		}
	}
	
	
	
} // END ---------------------------------------------------