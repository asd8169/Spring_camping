package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CDao;


public class CModifyCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		CDao dao = new CDao();
		dao.modify(bId, bName, bTitle, bContent);
		
		
	}
	
	public void executeSession(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
	}

}
