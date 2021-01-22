package com.spring.camping.review.list;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("review")
public class ReviewListController {

	
	
	
	//xml과 java연결
	@Autowired
	private SqlSession sqlSession;

	
	@RequestMapping("review_list")
	public String reviewList(Model model) {
		
		
		
		return "review_list";
	}
	
	
	
	
	
	
} // END -------------------------------------------------------
