package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CDao;
import com.jsplec.bbs.dao.CReviewDao;
import com.jsplec.bbs.dto.CDto;


public class CDeleteCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		String reviewNo = request.getParameter("reviewNo");
		CReviewDao dao = new CReviewDao();
	
		dao.deleteReview(reviewNo);
		
	}

	
}
