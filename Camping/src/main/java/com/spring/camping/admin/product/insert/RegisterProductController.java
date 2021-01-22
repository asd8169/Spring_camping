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
//
//	HttpServletRequest request;
//	HttpSession session =request.getSession();
//	
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
		
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.registerProductDao(request.getParameter("pName"), request.getParameter("pCategory"), request.getParameter("pPrice"), request.getParameter("pFile"), request.getParameter("pSubFile"), request.getParameter("pStock"));
		
		
		return "redirect:admin/admin_product_list";
		}
	}
	
	
	
} // END ---------------------------------------------------