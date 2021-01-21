package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CDao;
import com.jsplec.bbs.dto.CDto;


public class CListCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// Table에서 전체 검색을 하여 ArrayList에 넣기
		// 1) Dao(SQL Statement) (jaav swing에서 DbAction부분)
		// 2) DTO (java Bean)
		CDao dao = new CDao();
		ArrayList<CDto>dtos = dao.list();
		request.setAttribute("list", dtos);
		
	}
	
	
}
