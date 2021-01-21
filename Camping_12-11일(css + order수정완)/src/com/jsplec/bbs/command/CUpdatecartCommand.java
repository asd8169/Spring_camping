package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CCartDao;
import com.jsplec.bbs.dao.CDao;
import com.jsplec.bbs.dao.CProductDao;
import com.jsplec.bbs.dao.CWishlistDao;
import com.jsplec.bbs.dto.CDto;
import com.jsplec.bbs.dto.CProductDto;


public class CUpdatecartCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		int chk = Integer.parseInt(request.getParameter("chk"));
		int cartQuantity = 0;
		
		switch (chk) {
		case 0:
			if (Integer.parseInt(request.getParameter("cartQuantity")) == 1) {
				cartQuantity = 1;
			}else {
				cartQuantity = Integer.parseInt(request.getParameter("cartQuantity")) - 1;
				
			}
			
			break;
		case 1:
			 cartQuantity = Integer.parseInt(request.getParameter("cartQuantity")) + 1;
			
			break;

		}
		
		
		System.out.println("cartNo = " + cartNo + ", cartQuantity = " + cartQuantity);
		
		CCartDao cartDao = new CCartDao();
		cartDao.cartUpdate(cartNo, cartQuantity);
	}
	
	
}
