package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CDao;


public class CWriteCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		CDao dao = new CDao();
		dao.write(bName, bTitle, bContent);
	}
	
	public void executeSession(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	
	}
}
