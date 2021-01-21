package com.jsplec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CQnaDao;
import com.jsplec.bbs.dto.CQnaDto;


public class CQnaCommentCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 201130 세미------------
		
				String qnaComment = request.getParameter("qnaComment");
				String qnaNo = request.getParameter("qnaNo2");
				System.out.println("qnaNo : "+qnaNo);
				
				CQnaDao dao = new CQnaDao();
				dao.qnaComment(qnaComment, qnaNo);
				//----------------------ß
		
		
		
		//----------------------
		
	}


}
