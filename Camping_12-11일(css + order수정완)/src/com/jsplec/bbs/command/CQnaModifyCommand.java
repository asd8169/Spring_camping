package com.jsplec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CQnaDao;
import com.jsplec.bbs.dto.CQnaDto;


public class CQnaModifyCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		
		// 201201 세미------------
		
		String qnauserId = request.getParameter("qnauserId");
		String qnaNo = request.getParameter("qnaNo");
		String qnaContent = request.getParameter("qnaContent");
		String qnaTitle = request.getParameter("qnaTitle");
		
		CQnaDao dao = new CQnaDao();
		dao.qnaModify(qnaNo, qnaContent, qnaTitle);
		
		//----------------------
		
	}


}
