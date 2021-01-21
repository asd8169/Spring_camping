package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CDao;
import com.jsplec.bbs.dao.CMainDao;
import com.jsplec.bbs.dao.CQnaDao;
import com.jsplec.bbs.dao.CUserInfoDao;
import com.jsplec.bbs.dto.CMainDto;
import com.jsplec.bbs.dto.CQnaDto;
import com.jsplec.bbs.dto.CUserInfoDto;


public class CUserInfoDeleteCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String userId = request.getParameter("userId");
		
		CUserInfoDao cUserInfoDao = CUserInfoDao.getInstance();
		
		
		int delete = cUserInfoDao.deleteUserInfo(userId);
		
		//("" <-- view로 전달하는변수명, 값)
		request.setAttribute("delete", delete);
	}



}
