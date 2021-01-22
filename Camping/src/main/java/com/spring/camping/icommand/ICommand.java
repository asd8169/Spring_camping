package com.spring.camping.icommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;


//import com.mysql.cj.Session;

public interface ICommand {

	public void execute(SqlSession sqlSession, HttpServletRequest request, Model model, HttpSession session) throws ServletException, IOException;
	

	
}
