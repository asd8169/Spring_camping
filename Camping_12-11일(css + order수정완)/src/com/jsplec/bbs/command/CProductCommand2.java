package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.jsplec.bbs.dao.CProductDao;


import com.jsplec.bbs.dto.CProductDto;


public class CProductCommand2 implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// TODO Auto-generated method stub
		CProductDao dao = new CProductDao();
		// productdto에 담아서 보내줌
		ArrayList<CProductDto> productdto = dao.productlist();
		request.setAttribute("productlist", productdto);
		}
	
		
}
