package com.jsplec.bbs.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.jsplec.bbs.dao.CUserInfoDao;


public class CFindPwCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// Table에서 전체 검색을 하여 ArrayList에 넣기
		// 1) Dao(SQL Statement) (jaav swing에서 DbAction부분)
		// 2) DTO (java Bean)
		String userId = request.getParameter("userId");
		String userTelno = request.getParameter("userTelno");
		String userEmail = request.getParameter("userEmail");

		CUserInfoDao cUserInfoDao = CUserInfoDao.getInstance();

		String findPw = cUserInfoDao.findPw(userId, userTelno, userEmail);

		request.setAttribute("userName", userId);
		request.setAttribute("findPw", findPw);

		System.out.println(findPw);

	}
	
}
