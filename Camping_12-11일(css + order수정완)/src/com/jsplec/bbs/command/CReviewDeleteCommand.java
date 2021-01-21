package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CReviewDao;
import com.jsplec.bbs.dto.CReviewDto;



public class CReviewDeleteCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		String reviewNo = request.getParameter("reviewNo");
		CReviewDao dao = new CReviewDao();
	
		dao.deleteReview(reviewNo);
	}



}
