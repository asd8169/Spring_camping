package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CMyReviewDao;
import com.jsplec.bbs.dao.CReviewDao;
import com.jsplec.bbs.dto.CReviewDto;



public class CMyReviewDeleteCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		String reviewNo = request.getParameter("reviewNo");
		CMyReviewDao dao = new CMyReviewDao();
	
		dao.deleteMyReview(reviewNo);
	}



}
