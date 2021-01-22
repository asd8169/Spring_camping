package com.spring.camping.admin.orderlist;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin/")
public class AdminOrderListController {

	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 
	 */
	@RequestMapping("order_list")
	public String admin_product_list(Model model) {
		System.out.println("admin_order_list()");
		AdminOrderList_IDao dao = sqlSession.getMapper(AdminOrderList_IDao.class);
		model.addAttribute("orderlist", dao.listDao());
		
		
		return "admin/admin_order_list";
	}
	
	
	
	
	
} //----
