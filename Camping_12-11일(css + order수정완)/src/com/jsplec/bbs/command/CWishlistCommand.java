package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CCartDao;
import com.jsplec.bbs.dao.CDao;
import com.jsplec.bbs.dao.CProductDao;
import com.jsplec.bbs.dao.CWishlistDao;
import com.jsplec.bbs.dto.CDto;
import com.jsplec.bbs.dto.CProductDto;
import com.jsplec.bbs.dto.CWishDto;


public class CWishlistCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// TODO Auto-generated method stub
		int userNo =  (int) session.getAttribute("sessionuserNo");
		
		CWishlistDao wishDao = new CWishlistDao();
		ArrayList<CWishDto> dtos = wishDao.wishlist(userNo);
		request.setAttribute("wishlist", dtos);
	}
	
	
}
