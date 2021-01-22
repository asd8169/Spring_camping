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
	@RequestMapping("userinfo")
	public String userinfo(Model model) {
		
		CUserInfoDao dao = sqlSession.getMapper(CUserInfoDao.class);
		model.addAttribute("userInfoList", dao.selectUserInfo());
		return "admin/userinfo_view";		
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
}
