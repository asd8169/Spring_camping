package com.spring.camping.admin.product.list;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminProductListController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminProductListController.class);
	
	
	//xml과 java연결
		@Autowired
		private SqlSession sqlSession;
	
	//Admin Product List 연결
	@RequestMapping("admin/admin_Product_list")
	public String admin_product_list(Model model) {
		return "admin/admin_Product_list";		
	}
	
	
}