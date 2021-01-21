package com.jsplec.bbs.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CUserInfoDao;


public class CUserIdCheckCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		
		
		// 아이디 중복 체크
		CUserInfoDao dao = new CUserInfoDao();
		boolean result = dao.checkId(userId);
		
		response.setContentType("text/html;charset=euc-kr");
	}

}
