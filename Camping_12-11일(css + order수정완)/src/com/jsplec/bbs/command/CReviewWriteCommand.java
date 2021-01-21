package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CReviewDao;
import com.jsplec.bbs.dto.CReviewDto;



public class CReviewWriteCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

			
			
		String userId = (String)session.getAttribute("userId");
		String reviewNo = String.valueOf(session.getAttribute("reviewNo"));
		String orderNo = String.valueOf(session.getAttribute("orderNo"));
		String productNo = String.valueOf(session.getAttribute("productNo"));
		String userNo = String.valueOf(session.getAttribute("sessionuserNo"));
		
		
		String reviewContent = (String)session.getAttribute("reviewContent");
		String reviewFile = (String) session.getAttribute("reviewFile");
		System.out.println(reviewContent);
		System.out.println("애는 뜨나!?" + productNo );
		String reviewDate = "";
		
		// DAO를 불러서 위에 불러온 값과 이미지를 저장 시킴
		CReviewDao dao = new CReviewDao();
		dao.registerReview(userNo, reviewNo, orderNo, productNo, reviewContent, reviewFile, reviewDate);
	}



}
