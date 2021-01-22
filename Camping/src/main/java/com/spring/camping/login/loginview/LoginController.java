package com.spring.camping.login.loginview;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	
	//xml과 java연결
		@Autowired
		private SqlSession sqlSession;

		
	
	//로그인화면 연결
	@RequestMapping("/login_view")
	public String login_view(Model model) {
		return "login/login_view";		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
