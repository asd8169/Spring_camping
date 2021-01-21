package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CCartDao;
import com.jsplec.bbs.dao.COrderDao;
import com.jsplec.bbs.dao.CReviewDao;
import com.jsplec.bbs.dto.CCartDto;
import com.jsplec.bbs.dto.COrderDto;
import com.jsplec.bbs.dto.CReviewDto;



public class COrderListCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

			
		int userNo =  (int) session.getAttribute("sessionuserNo");
		
		COrderDao cOrderDao = new COrderDao();
		
		ArrayList<COrderDto> dtos = cOrderDao.orderlist(userNo);
		
		request.setAttribute("orderlist", dtos);

					
		}



}
