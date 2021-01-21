package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CCartDao;
import com.jsplec.bbs.dao.CDao;
import com.jsplec.bbs.dao.CProductDao;
import com.jsplec.bbs.dao.CWishlistDao;
import com.jsplec.bbs.dto.CCartDto;
import com.jsplec.bbs.dto.CDto;
import com.jsplec.bbs.dto.CProductDto;


public class CCartlistCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
		// 장바구니 불러오기
		
		int userNo =  (int) session.getAttribute("sessionuserNo");
		System.out.println(userNo);
		CCartDao cartDao = new CCartDao();
		ArrayList<CCartDto> dtos = cartDao.cartlist(userNo);
		request.setAttribute("cartlist", dtos);
		
		request.setAttribute("totalPrice",cartDao.totalPrice(userNo));
		
//		System.out.println("cartlist. = "+ dtos.get(0).getCartNo());

	}
	
	
}
