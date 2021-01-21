package com.jsplec.bbs.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CUserInfoDao;;

public class CSignUpCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userTelno = request.getParameter("tel1") + request.getParameter("tel2") + request.getParameter("tel3");
		String zipNo = request.getParameter("zipNo") + "  " ;
		String roadAddrPart1 = request.getParameter("roadAddrPart1") + "  " ;
		String addrDetail = request.getParameter("addrDetail") + "  " ;
		String userEmail = request.getParameter("emailId") + "@" + request.getParameter("textEmail");
		System.out.println(request.getParameter("roadAddrPart1"));
		System.out.println(request.getParameter("addrDetail"));
		
		// 회원가입 정보를 DB에 저장하기
		CUserInfoDao dao = new CUserInfoDao();
		dao.register(userId,userPw,userName,userTelno,zipNo,roadAddrPart1,addrDetail,userEmail);
	}

}
