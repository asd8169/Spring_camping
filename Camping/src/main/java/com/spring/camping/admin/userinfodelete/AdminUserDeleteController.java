package com.spring.camping.admin.userinfodelete;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin/")
public class AdminUserDeleteController {

	@Autowired
	private SqlSession sqlSession;
	
	
	/**
	 * 
	 */
	@RequestMapping("userInfoDelete")
	public String admin_product_list(HttpServletRequest request, Model model) {
		System.out.println("admin_order_list()");
		
		AdminUserDelete_IDao dao = sqlSession.getMapper(AdminUserDelete_IDao.class);
		dao.adminuserdeletedao(request.getParameter("userId"));
				
		return "redirect:userinfo";
	}
	
	
	
	
	
} //----
