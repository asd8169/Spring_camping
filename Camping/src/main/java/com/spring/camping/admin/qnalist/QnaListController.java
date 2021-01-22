package com.spring.camping.admin.qnalist;


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
@RequestMapping("qna")
public class QnaListController {
	
	private static final Logger logger = LoggerFactory.getLogger(QnaListController.class);

	
	//xml과 java연결
		@Autowired
		private SqlSession sqlSession;

	//로그인화면 연결
	@RequestMapping("/qna_list")
	public String qnalist(Model model) {
		return "qna_list";		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
