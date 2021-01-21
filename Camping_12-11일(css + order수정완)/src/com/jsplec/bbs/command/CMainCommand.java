package com.jsplec.bbs.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.CMainDao;
import com.jsplec.bbs.dto.CMainDto;



public class CMainCommand implements CCommand {
	 //controller로부터 받은 커맨드들을 각 커맨드에 맞게 클래스에서 수행한다. 각 클래스들은 인터페이스인 Action을 구현한다.
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws ServletException,IOException{

		
//		HttpSession session =request.getSession();

		
		
		//한 페이지당보여줄 글 갯수
		
		
		final int pageSize=6;
		
				
		//getInstance로
		CMainDao cDao = CMainDao.getInstance();
		ArrayList<CMainDto> lists = new ArrayList<CMainDto>();
		
		
		int currentPage = 1; 
		
		if(request.getParameter("page")!=null){ 
			currentPage = Integer.parseInt(request.getParameter("page")); //현재 페이지
			System.out.println("page : " + request.getParameter("page") + "페이지" );
		}
		

		//currentPage와 pageSize는 CMainDao/selectAllBoards메소드 매개변수
		lists = cDao.selectAllBoards(currentPage, pageSize);
		
		System.out.println("메인 사진 !!!!!@@@@@@@@@@@@@@@@@@@@@@@@"+ lists.get(0).getpFile());
		System.out.println("메인 사진 !!!!!@@@@@@@@@@@@@@@@@@@@@@@@"+ lists.get(0).getpCategory());
		System.out.println("메인 사진 !!!!!@@@@@@@@@@@@@@@@@@@@@@@@"+ lists.get(0).getpName());
		System.out.println("메인 사진 !!!!!@@@@@@@@@@@@@@@@@@@@@@@@"+ lists.get(0).getpPrice());
		System.out.println("@@@@@@Q"+lists.get(0).getpFile());
		//lists를 mainList에 담아 보낸다
		request.setAttribute("mainList", lists);  		
		
	
		
		// CMainDao/getBoardCount메소드로 전체 글 갯수 구해서 totalRow에 저장
		int totalRow = cDao.getBoardCount();
		
		
		//전체 페이지 갯수 (전체글 개수-1)/페이지당 글 수+1 구해서 totalPage에 저장 
		int totalPage = (totalRow-1)/pageSize+1;  
		
		
		//페이지 그룹화  [1][2][3] [4][5][6] [7][8][9]  =>3페이지가 한그룹
		int pagePerGroup = 3;
		
		
		//시작페이지	((현재페이지-1)/그룹당 보여줄 페이지)*그룹당 보여줄 페이지+1   [1] [4] [7]
		int startPage = ((currentPage-1)/pagePerGroup)*pagePerGroup+1;
		
		
		//끝페이지		시작페이지+그룹당 보여줄 페이지-1  [3] [6] [9]
		int endPage = startPage+pagePerGroup-1;
		
		
		//★만약 endPage가 totalPage보다 크면 endPage에 totalPage를 넣어준다.
		if(endPage>totalPage){
			
			endPage=totalPage;
			
			}
		
		System.out.println("startPage:"+startPage);
		System.out.println("endpage:"+endPage);
		System.out.println("totalPage:"+totalPage);
		System.out.println("totalRow:"+totalRow);
		System.out.println("currentPage:"+currentPage);
		System.out.println("-----------------------------------");
		
		
		//request에 setAttribute를 사용하여 모든 정보를 붙여 보낸다.
		request.setAttribute("currentPage",currentPage); 
		request.setAttribute("totalRow",new Integer(totalRow));  //총 글 갯수 생략 가능성?
		request.setAttribute("totalPage",new Integer(totalPage)); 
		request.setAttribute("startPage",new Integer(startPage)); 
		request.setAttribute("endPage",new Integer(endPage)); 
		
		
	}
	

	
	
}
