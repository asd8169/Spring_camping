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


public class CRecUpdateCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// no와 id값을 map에 저장
		int userNo =  (Integer)  session.getAttribute("sessionuserNo");
		
		
		
		int pNo = Integer.valueOf((String)session.getAttribute("sessionpNo"));
		
		
//		int pNo = Integer.parseInt(request.getParameter("pNo"));
		System.out.println("업데이트할 때의 pNo = " + pNo);
		CWishlistDao dao = new CWishlistDao();
		
		// 동일 제품에 대한 위시리스트 존재여부 검색
		
		int result = dao.recCheck(userNo, pNo);
		
		if(result == 0){ // 추가하지 않았다면 추가
			dao.recUpdate(userNo, pNo);
			session.setAttribute("wishcheck", 1);
		}else{ // 이미 위시리스트에 있다면 위시리스트에서 삭제
			dao.recDelete(userNo, pNo);
			session.setAttribute("wishcheck", 0);
		}
		
			
	}
	
	
}
