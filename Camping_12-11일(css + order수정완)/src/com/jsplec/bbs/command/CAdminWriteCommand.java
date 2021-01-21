package com.jsplec.bbs.command;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CCartDao;

import com.jsplec.bbs.dao.CProductDao;
import com.jsplec.bbs.dao.CWishlistDao;

import com.jsplec.bbs.dto.CProductDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class CAdminWriteCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// TODO Auto-generated method stub
//		String pNo = request.getParameter("pNo");
		
		String pName = (String)session.getAttribute("pName");
		String pCategory = (String)session.getAttribute("pCategory");
		String pPrice = (String)session.getAttribute("pPrice");
//		String pHashtag = request.getParameter("pHashtag");
		String pFile = (String)session.getAttribute("pFile");
		String pSubFile = (String)session.getAttribute("pSubFile");
		String pStock = (String)session.getAttribute("pStock");
		// 리뷰를 DB에 저장하기
		CProductDao dao = new CProductDao();
		dao.registerProduct(pName, pCategory, pPrice, pFile, pSubFile, pStock);
		
	}
		
}
