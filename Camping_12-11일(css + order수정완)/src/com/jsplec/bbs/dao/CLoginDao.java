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

	//userinfo DB 저장하는곳


public class CLoginDao {
	
	//DAO 데이터베이스 관련 작업을 수행--------------------------
	
	////외부에서 생성을 못하도록 Default생성자는 private으로 선언
	DataSource dataSource;
	
	
	private CLoginDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	private static CLoginDao instance = new CLoginDao();

	public static CLoginDao getInstance() {
		return instance;

	}
	
	public int login(String id, String pw) {
		
		
		String sql = "select userPw from userinfo where userId = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userNo = null;
		
		
		System.out.println("daoid : " + id);
		System.out.println("daopw : " + pw);

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
	
			//id와 pw값이 모두 같으면 1을 리턴
			
			if (rs.next()) {
				if(rs.getString("userPw").equals(pw)) {
					return 1;
					
				} else {	
			//아이디만 같고 비밀번호가 다르면 0을 리턴
					return 0;
				}
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if (rs != null)  rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				//에러코드 호출
				e.printStackTrace();
			}
		}
		//id부터 다르면 -1을 리턴
		return -1;
	}
	

	public int findUserNo(String id) {
		
		String sql = "select userNo from userinfo where userId = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int findUserNo = 0;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				findUserNo =rs.getInt(1); // 전체 글 개수
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
		
		return findUserNo;
	}
	
	
	
}
