package com.jsplec.bbs.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.jsplec.bbs.dao.CUserInfoDao;



public class CFindIdCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// Table에서 전체 검색을 하여 ArrayList에 넣기
		// 1) Dao(SQL Statement) (jaav swing에서 DbAction부분)
		// 2) DTO (java Bean)
		String userName = request.getParameter("userName");
		String userTelno = request.getParameter("userTelno");
		String userEmail = request.getParameter("userEmail");
		
		
		
		CUserInfoDao cUserInfoDao = CUserInfoDao.getInstance();

		String findId = cUserInfoDao.findId(userName, userTelno, userEmail);
		
		request.setAttribute("userName", userName); 
		request.setAttribute("findId", findId); 
		
		
		System.out.println(findId);
		
	}
	
	
}
