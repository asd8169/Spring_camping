package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CDao;
import com.jsplec.bbs.dto.CDto;


public class CContentCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String bId = request.getParameter("bId");
		CDao dao =  new CDao();
		CDto dto = dao.contentView(bId);
		request.setAttribute("content_view", dto);
		
		
	}
	
	
}
