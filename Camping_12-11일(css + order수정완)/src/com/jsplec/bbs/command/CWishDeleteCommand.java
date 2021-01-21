package com.jsplec.bbs.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CWishlistDao;

public class CWishDeleteCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// no와 id값을 map에 저장
				int userNo =  (Integer)  session.getAttribute("sessionuserNo");
				
				
				
				int pNo = Integer.parseInt(request.getParameter("pNo"));
				
				
//				int pNo = Integer.parseInt(request.getParameter("pNo"));
				CWishlistDao dao = new CWishlistDao();
				
				// 동일 제품에 대한 위시리스트 존재여부 검색
				
				dao.recDelete(userNo, pNo);
				
				
	}

}
