package com.spring.camping.admin.userinfodelete;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.camping.admin.orderlist.AdminOrderList_IDao;


@Controller
@RequestMapping("admin/")
public class AdminUserDeleteController {

	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 
	 */
	@RequestMapping("user_delte")
	public String admin_product_list(Model model) {
		System.out.println("admin_order_list()");
		AdminOrderList_IDao dao = sqlSession.getMapper(AdminOrderList_IDao.class);
		model.addAttribute("orderlist", dao.listDao());
		
		
		return "admin/admin_order_list";
	}
	
	
	
	
	
} //----
