package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CUserInfoDao;
import com.jsplec.bbs.dto.CUserInfoDto;


public class CUserInfoUpdateCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userTelno = request.getParameter("tel1") + request.getParameter("tel2") + request.getParameter("tel3");
		String zipNo = request.getParameter("zipNo") + "  ";
		String roadAddrPart1 = request.getParameter("roadAddrPart1") + "  " ;
		String addrDetail = request.getParameter("addrDetail");
		String userEmail = request.getParameter("emailId") + "@" + request.getParameter("textEmail");
		
		System.out.println("roadAddrPart1" +request.getParameter("roadAddrPart1"));
		System.out.println("addrDetail" + request.getParameter("addrDetail"));
		
		
		CUserInfoDao dao = new CUserInfoDao();
		
		String sessionuserId = (String) session.getAttribute("sessionuserId");
		
		
		System.out.println("command sessionuserId : " +session.getAttribute("sessionuserId"));
		
		System.out.println("command sessionuserId : " +session.getAttribute("sessionuserId"));
		
		// 회원가입 정보를 DB에 저장하기
		dao.userInfoUpdate(userPw,userName,userTelno,zipNo,roadAddrPart1,addrDetail,userEmail,sessionuserId);
		
		
		
	}

}
