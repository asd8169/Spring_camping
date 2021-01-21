package com.jsplec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CQnaDao;
import com.jsplec.bbs.dto.CQnaDto;


public class CQnaViewCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 201130 세미------------
		
		// 201130 세미------------

		// qna 글보기
		
		String userName = request.getParameter("qnaNo");
		
		CQnaDao dao = new CQnaDao();
		
		
		CQnaDto dto = dao.qnaView(userName);
		request.setAttribute("qna_view", dto);

		
		
		String listName = request.getParameter("userName");
		session.setAttribute("listName", listName);
		System.out.println(listName);
		
		
		
		//----------------------
		
	}


}
