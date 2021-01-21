package com.jsplec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CQnaDao;
import com.jsplec.bbs.dto.CQnaDto;


public class CQnaDeleteCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 201130 세미------------
		
		
		String userNo = request.getParameter("qnaNo");
		
		CQnaDao dao =  new CQnaDao();
		dao.qnadelete(userNo);
		
		
		
		//----------------------
		
	}


}
