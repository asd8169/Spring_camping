package com.spring.camping.admin.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMainController {

	@RequestMapping("admin_main")
	public String list() {		
	
		return "admin/admin_main";
	}
}
