package com.spring.camping.admin.userinfoselect;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);
	
	
	
	//xml과 java연결
	@Autowired
	private SqlSession sqlSession;
		
	
	
	//회원리스트
	@RequestMapping("/userinfo")
	public String login(Model model) {
		
		
		
		return "admin/userinfo_view";		
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
