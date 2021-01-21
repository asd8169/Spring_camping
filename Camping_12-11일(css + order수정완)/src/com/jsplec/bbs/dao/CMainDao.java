package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.CMainDto;



public class CMainDao {
	
	//DAO 데이터베이스 관련 작업을 수행--------------------------
	
	////외부에서 생성을 못하도록 Default생성자는 private으로 선언
	DataSource dataSource;
	
	
	private CMainDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");

		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	
	//instance 생성
	//객체(Object)가 값을 갖을 경우에, 이를 인스턴스(Instance)라고 함
	private static CMainDao instance = new CMainDao();

	public static CMainDao getInstance() {
		return instance;

	}
	
	
	// 게시판의 전체 글 수를 가져오는 메서드
	public int getBoardCount() {
		String sql = "select count(*) from product ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int boardCount=0;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery();

			
			if (rs.next()) {
				boardCount=rs.getInt(1); // 전체 글 개수
			} // if

		} catch (SQLException e) {
			e.printStackTrace();
			
		//finally 안해주면 렉걸려!!!
		}finally {
			
			try {
				if (rs != null)  rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn != null) conn.close();
				
				
			} catch (Exception e) {
				//에러코드 호출
				e.printStackTrace();
			}
			}
		
		return boardCount;
	}
	
	// 선택된 게시판의 글수를 가져오는 메소드
	public int getBoardProductCount(String select) {
		String sql = "select count(*) from product where pCategory like '%" + select + "%'";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int boardCount=0;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) {
				boardCount=rs.getInt(1); // 전체 글 개수
			} // if
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			//finally 안해주면 렉걸려!!!
		}finally {
			
			try {
				if (rs != null)  rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn != null) conn.close();
				
				
			} catch (Exception e) {
				//에러코드 호출
				e.printStackTrace();
			}
		}
		
		return boardCount;
	}

	
	
	
	// 게시글 리스트 읽어오기 page=현재 페이지  pageSize=페이지당 글 개수
	public ArrayList<CMainDto> selectAllBoards(int page, int pageSize) {

		int startNum=((page-1)*pageSize);//전체 페이지 개수
		
		
		ArrayList<CMainDto> lists = new ArrayList<CMainDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {
			conn = dataSource.getConnection();
			//ROWNUM 게시글에 번호 부여
			String query = "select @ROWNUM := @ROWNUM + 1 as rno, p.* from product p, (select @rownum :=0) tmp ORDER BY rno LIMIT ?, 6 ";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startNum);
			System.out.println("startNum : " + startNum);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				
				CMainDto cMainDto = new CMainDto();
				
				//query문 데이터값 저장
				cMainDto.setpNo(rs.getInt("pNo"));
				cMainDto.setpName(rs.getString("pName"));
				cMainDto.setpCategory(rs.getString("pCategory"));
				cMainDto.setpFile(rs.getString("pFile"));
				cMainDto.setpPrice(rs.getString("pPrice"));
//				cMainDto.setpSubFile(rs.getString("pSubFile"));

				lists.add(cMainDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//finally 안해주면 렉걸려!!!	
		finally {
			try {
				if (rs != null)  rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn != null) conn.close();
				
				
			} catch (Exception e) {
				//에러코드 호출
				e.printStackTrace();
			}
			}
		return lists;
		
	}
	
	
	
	
	
	// 게시글 리스트 읽어오기 page=현재 페이지  pageSize=페이지당 글 개수
	public ArrayList<CMainDto> selectMenuBoards(int page, int pageSize, String select) {
		
		int startNum=((page-1)*pageSize);//전체 페이지 개수
		
		
		ArrayList<CMainDto> lists = new ArrayList<CMainDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = dataSource.getConnection();
			//ROWNUM 게시글에 번호 부여
			String query = "select @ROWNUM := @ROWNUM + 1 as rno, p.* from product p, (select @rownum :=0) tmp where pCategory like '%" + select + "%'" + " ORDER BY rno LIMIT ?, 6 ";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startNum);
			System.out.println("startNum : " + startNum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				
				CMainDto cMainDto = new CMainDto();
				
				//query문 데이터값 저장
				cMainDto.setpNo(rs.getInt("pNo"));
				cMainDto.setpName(rs.getString("pName"));
				cMainDto.setpCategory(rs.getString("pCategory"));
				cMainDto.setpPrice(rs.getString("pPrice"));
				cMainDto.setpFile(rs.getString("pFile"));
				cMainDto.setpSubFile(rs.getString("pSubFile"));
				
				lists.add(cMainDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//finally 안해주면 렉걸려!!!	
		finally {
			try {
				if (rs != null)  rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn != null) conn.close();
				
				
			} catch (Exception e) {
				//에러코드 호출
				e.printStackTrace();
			}
		}
		return lists;
		
	}
	
}
