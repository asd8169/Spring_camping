package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CCartDao;



public class CAddcartCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		int userNo =  (int) session.getAttribute("sessionuserNo");
//		int pNo = (Integer) session.getAttribute("sessionpNo");
		int pNo = Integer.parseInt(request.getParameter("pNo"));
		System.out.println("addCart 에 들어가는 pNo = " + pNo);
		int cartQuantity = Integer.parseInt(request.getParameter("cartQuantity"));
		System.out.println("cartquantity = " + request.getParameter("cartQuantity"));
		CCartDao dao = new CCartDao();
		
		// 동일 제품에 대한 장바구니 존재여부 검색
		int result = dao.cartCheck(userNo, pNo);
		
		session.setAttribute("cartcheck", Integer.toString(result));
		
		if(result == 0){ // 추가하지 않았다면 추가
			dao.cartInsert(userNo, pNo, cartQuantity);
			session.setAttribute("cartcheck", 1);
		}else{ // 이미 장바구니에 있다면 장바구니에 수량만큼 추가
			dao.cartUpdate(userNo, pNo, cartQuantity);
		}
	}
	
	
}
