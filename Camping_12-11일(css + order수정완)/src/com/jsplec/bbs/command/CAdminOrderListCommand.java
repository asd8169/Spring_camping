package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.COrderDao;
import com.jsplec.bbs.dto.COrderDto;



public class CAdminOrderListCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		
		
		// 201204 세미——————
		
				// order list 출력
				COrderDao dao = new COrderDao();
				ArrayList<COrderDto>orderdtos = dao.adminorderlist();
				request.setAttribute("orderlist", orderdtos);
		
		
		
		
		
	}

	

}
