package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CUserInfoDao;
import com.jsplec.bbs.dto.CUserInfoDto;


public class CUserInfoLoadCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//		String userId = request.getParameter("userId");
//		String userId = request.getParameter("userId");
//		String userPw = request.getParameter("userPw");
//		String userName = request.getParameter("userName");
//		String userTelno = request.getParameter("tel1") + request.getParameter("tel2") + request.getParameter("tel3");
//		String userAddress = request.getParameter("zipNo") + "  " + request.getParameter("roadAddrPart1") + "  " + request.getParameter("addrDetail");
//		String userEmail = request.getParameter("emailId") + "@" + request.getParameter("textEmail");
		System.out.println(request.getParameter("roadAddrPart1"));
		System.out.println(request.getParameter("addrDetail"));
		
		String sessionuserId = (String) session.getAttribute("sessionuserId");
		
		CUserInfoDao dao = new CUserInfoDao();
		
		CUserInfoDto cUserInfoDto = dao.findUserInfo(sessionuserId);
		
		
		request.setAttribute("findUserInfo", cUserInfoDto);
		
//		String userTelNo1 = cUserInfoDto.getUserTelno();
		
		System.out.println("command sessionuserId : " +session.getAttribute("sessionuserId"));
		
	
		
		
		
	}

}
