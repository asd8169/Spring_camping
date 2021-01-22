package com.spring.camping.admin.userinfosearch;


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
public class UserInfoSearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoSearchController.class);
	
	
	
	//xml과 java연결
	@Autowired
	private SqlSession sqlSession;
		
	
	//회원리스트
	@RequestMapping("userinfoSearch")
	public String userinfo(Model model,String select, String content) {
		System.out.println(select);
		System.out.println(content);
		CUserInfoSearchDao dao = sqlSession.getMapper(CUserInfoSearchDao.class);
		model.addAttribute("userInfoList", dao.search(select,content));
		return "admin/userinfo_view";		
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
}
 