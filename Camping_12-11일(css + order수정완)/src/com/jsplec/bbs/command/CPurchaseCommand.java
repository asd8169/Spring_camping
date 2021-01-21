package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CCartDao;
import com.jsplec.bbs.dao.COrderDao;
import com.jsplec.bbs.dto.CCartDto;



public class CPurchaseCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		//-----------------------------------------------------
		// 배송지 주소 받아오기 (form 으로)
		String orderAddress = (String) session.getAttribute("orderAddress");
		//-----------------------------------------------------
		
		
		System.out.println("결제창입니다");
		// 카트정보 가져오기
		//-----------------------------------------------------
		int userNo =  (Integer) session.getAttribute("sessionuserNo");
		CCartDao cartDao = new CCartDao();
		ArrayList<CCartDto> dtos = cartDao.getCartInfo(userNo);
		//-----------------------------------------------------
		
		
		System.out.println("cartlist. = "+ dtos.get(0).getCartQuantity());
		System.out.println("cartlist. = "+ dtos.get(0).getProduct_pNo());
		
		// 정보 합쳐서 order테이블에 insert
		//-----------------------------------------------------
		COrderDao orderDao = new COrderDao();
		
		for (int i = 0; i < dtos.size(); i++) {
			orderDao.orderInsert(userNo, dtos.get(i).getProduct_pNo(), orderAddress, dtos.get(i).getCartQuantity());
		}
	
	}


}
