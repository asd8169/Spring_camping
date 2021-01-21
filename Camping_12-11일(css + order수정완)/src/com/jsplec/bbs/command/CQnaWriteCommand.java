package com.jsplec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CQnaDao;


public class CQnaWriteCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 201128 세미------------

		// qna 글저장

		CQnaDao dao = new CQnaDao();
		// String name = request.getParameter("name");
		String qnaTitle = request.getParameter("qnaTitle");
		String product_pNo = String.valueOf(session.getAttribute("sessionpNo"));
		String qnaContent = request.getParameter("qnaContent");
		String qnauserId = request.getParameter("name");
		String userNo = request.getParameter("userNo");
		String qnaSecret = request.getParameter("qnaSecret");

		System.out.println("$$$$$$$4qnauserId : " + qnauserId);
		System.out.println("$$$$$$$$product_pNo : " + product_pNo);
		System.out.println("$$$$$$$$qnaContent : " + qnaContent);

		dao.qnawrite(qnaTitle, qnaContent, qnauserId, product_pNo, userNo, qnaSecret);

		// ----------------------
		
	}


}
