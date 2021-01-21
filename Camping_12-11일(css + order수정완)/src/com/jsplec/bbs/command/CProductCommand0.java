package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CCartDao;

import com.jsplec.bbs.dao.CProductDao;
import com.jsplec.bbs.dao.CWishlistDao;

import com.jsplec.bbs.dto.CProductDto;


public class CProductCommand0 implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		
		session.setAttribute("sessionpNo", request.getParameter("pNo"));
		
		
		}
	
		
}
