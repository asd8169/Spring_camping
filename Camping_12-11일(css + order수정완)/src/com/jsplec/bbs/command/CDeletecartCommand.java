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


public class CDeletecartCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		
		CCartDao cartDao = new CCartDao();
		cartDao.cartDelete(cartNo);
	}
	
	
}
