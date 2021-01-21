package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CReviewDao;
import com.jsplec.bbs.dto.CReviewDto;



public class CReviewModifyCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		
//		String userId = request.getParameter("userId");
//		String reviewNo = request.getParameter("reviewNo");
//		String orderNo = request.getParameter("orderNo");
		
//		String productNo = request.getParameter("productNo");
		
		String reviewContent = request.getParameter("reviewContent"); 
		String reviewNo = request.getParameter("reviewNo"); 
//		String userNo = request.getParameter("reviewNo"); 
		
		
//		String file = request.getParameter("file");
		CReviewDao dao = new CReviewDao();
		dao.reviewModify(reviewNo, reviewContent);


	}



}
