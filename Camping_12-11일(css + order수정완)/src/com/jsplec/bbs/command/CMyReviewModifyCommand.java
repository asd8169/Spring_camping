package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CMyReviewDao;



public class CMyReviewModifyCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		
//		String userId = request.getParameter("userId");
//		String reviewNo = request.getParameter("reviewNo");
//		String orderNo = request.getParameter("orderNo");
		
//		String productNo = request.getParameter("productNo");
		
		String reviewNo = request.getParameter("reviewNo"); 
		String reviewContent = request.getParameter("reviewContent"); 
		System.out.println("너 넘어옴?" + reviewNo);
//		String userNo = request.getParameter("reviewNo"); 
		
		
//		String file = request.getParameter("file");
		CMyReviewDao dao = new CMyReviewDao();
		dao.myreviewModify(reviewNo, reviewContent);


	}
}