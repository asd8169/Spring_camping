package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CCartDao;

import com.jsplec.bbs.dao.CProductDao;
import com.jsplec.bbs.dao.CWishlistDao;

import com.jsplec.bbs.dto.CProductDto;


public class CProductCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// TODO Auto-generated method stub
		int userNo = (Integer) session.getAttribute("sessionuserNo");
		
		int pNo = Integer.valueOf((String) session.getAttribute("sessionpNo")); 
		
//		int pNo = Integer.parseInt(request.getParameter("pNo"));
		
//		session.setAttribute("sessionpNo", request.getParameter("pNo"));
		
		System.out.println("pno : " + pNo);
		
		CProductDao dao = new CProductDao();
		CProductDto dto = dao.contentView(Integer.toString(pNo));
		
		// wish, 장바구니에 들어있는지 체크
		CCartDao cartDao = new CCartDao();
		CWishlistDao wishDao = new CWishlistDao();
		
		
		int result1 = cartDao.cartCheck(userNo, pNo);
		int result2 = wishDao.recCheck(userNo, pNo);
		
		
		session.setAttribute("cartcheck", result1);
		session.setAttribute("wishcheck", result2);
		
		
		
		System.out.println("cartcheck : "+ result1);
		System.out.println("wishcheck : " + result2);
		
		
		
		request.setAttribute("content_view", dto);
		}
	
		
}
