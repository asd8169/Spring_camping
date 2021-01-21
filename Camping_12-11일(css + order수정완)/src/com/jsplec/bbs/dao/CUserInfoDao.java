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
import com.jsplec.bbs.dto.CUserInfoDto;



public class CUserInfoDao {
	
	//DAO 데이터베이스 관련 작업을 수행--------------------------
	
	////외부에서 생성을 못하도록 Default생성자는 private으로 선언
	DataSource dataSource;
	
	
	public CUserInfoDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");

		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	
	//instance 생성
	//객체(Object)가 값을 갖을 경우에, 이를 인스턴스(Instance)라고 함
	private static CUserInfoDao instance = new CUserInfoDao();

	public static CUserInfoDao getInstance() {
		return instance;

	}
	
	
	// 게시판의 전체 글 수를 가져오는 메서드
	public int getBoardCount() {
		String sql = "select count(*) from userinfo ";

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
	
	public int getBoardSearchCount(String select, String content) {
		String sql = "select count(*) from userinfo where " + select + " like '%" + content + "%'";

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

	
	
	
	//회원 정보 읽어오기 page=현재 페이지  pageSize=페이지당 글 개수
	public ArrayList<CUserInfoDto> selectUserInfo(int page, int pageSize) {

		int startNum=((page-1)*pageSize)+1;//전체 페이지 개수
		
		
		ArrayList<CUserInfoDto> lists = new ArrayList<CUserInfoDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {
			conn = dataSource.getConnection();
			
			//ROWNUM 게시글에 번호 부여
			String query = "select @ROWNUM := @ROWNUM + 1 as rno, u.* from userinfo u, (select @rownum :=0) tmp ORDER BY rno LIMIT ?, 4";
//			"where " + select + " like '%" + content + "%'"
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startNum);
			
			
			rs = pstmt.executeQuery();

			
			while (rs.next()) {
				
				
				String userId = rs.getString("userId");
				String userPw = rs.getString("userPw");
				String userName = rs.getString("userName");
				String userTelno = rs.getString("userTelno");
				String zipNo = rs.getString("zipNo");
				String roadAddrPart1 = rs.getString("roadAddrPart1");
				String addrDetail = rs.getString("addrDetail");
				String userEmail = rs.getString("userEmail");
			

				CUserInfoDto cUserInfoDto = new CUserInfoDto(userId, userPw, userName, userTelno, zipNo, roadAddrPart1, addrDetail, userEmail);
				lists.add(cUserInfoDto);
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
	
	
	//CUserInfoDeleteCommand-----------------
	//등록된 회원 삭제
	
	public int deleteUserInfo(String userId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int delete = 0;
		

		String query = "delete from userinfo where userId = ? ";

		
		try {
			connection = dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, userId);
			
			//삭제되면 1을 반환
			delete = preparedStatement.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {		//finally 에러가 걸리거나 안걸리거나 다 여기로 온다.
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}System.out.println(delete);
		return delete;
		
	}
	
	public String findId(String userName, String userTelno, String userEmail) {

		String sql = "select userId from userinfo where userName = ? and userTelno = ? and userEmail = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String findId = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userTelno);
			pstmt.setString(3, userEmail);

			rs = pstmt.executeQuery();

			// id와 pw값이 모두 같으면 1을 리턴

			if (rs.next()) {

				findId = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// 에러코드 호출
				e.printStackTrace();
			}
		}
		return findId;
		// id부터 다르면 -1을 리턴
	}

	//아이디 찾기
	public String findPw(String userId, String userTelno ,String userEmail) {
			
			
			
			String sql = "select userPw from userinfo where userId = ? and userTelno = ? and userEmail = ? ";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String findPw = null;
			
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, userTelno);
				pstmt.setString(3, userEmail);
				
				rs = pstmt.executeQuery();
				
				
				//id와 pw값이 모두 같으면 1을 리턴
				
				if (rs.next()) {
					
					findPw = rs.getString(1);
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
			return findPw;
			//id부터 다르면 -1을 리턴
		}
	
	public CUserInfoDto findUserInfo(String sessionuserId) {

		String sql = "select * from userinfo where userId = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CUserInfoDto CUserInfoDto = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sessionuserId);

			rs = pstmt.executeQuery();

			// id와 pw값이 모두 같으면 1을 리턴

			if (rs.next()) {

				 String userNo = rs.getString(1);
				 String userId = rs.getString(2);
				 String userPw = rs.getString(3);
				 String userName = rs.getString(4);
				 String userTelno = rs.getString(5);
				 String userEmail = rs.getString(6);
				 String zipNo = rs.getString(7);
				 String roadAddrPart1 = rs.getString(8);
				 String addrDetail = rs.getString(9);
			 
			 
			 CUserInfoDto = new CUserInfoDto(userNo, userId, userPw, userName, userTelno, zipNo, roadAddrPart1, addrDetail, userEmail);
			 
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// 에러코드 호출
				e.printStackTrace();
			}
		}
		return CUserInfoDto;
		
	}
	
	
	//회원 정보 읽어오기 page=현재 페이지  pageSize=페이지당 글 개수
		public ArrayList<CUserInfoDto> search (int page, int pageSize, String select, String content) {

			int startNum=((page-1)*pageSize);//전체 페이지 개수
			ArrayList<CUserInfoDto> lists = new ArrayList<CUserInfoDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = dataSource.getConnection();
				//ROWNUM 게시글에 번호 부여
				String query = "select @ROWNUM := @ROWNUM + 1 as rno, u.* from userinfo u, (select @rownum :=0) tmp where " + select + " like '%" + content + "%'" + " ORDER BY rno LIMIT ?, 5 ";
//				"where " + select + " like '%" + content + "%'"
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startNum);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String userId = rs.getString("userId");
					String userPw = rs.getString("userPw");
					String userName = rs.getString("userName");
					String userTelno = rs.getString("userTelno");
					String zipNo = rs.getString("zipNo");
					String roadAddrPart1 = rs.getString("roadAddrPart1");
					String addrDetail = rs.getString("addrDetail");
					String userEmail = rs.getString("userEmail");
					CUserInfoDto cUserInfoDto = new CUserInfoDto(userId, userPw, userName, userTelno, zipNo, roadAddrPart1, addrDetail, userEmail);
					lists.add(cUserInfoDto);
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
		
	
		// 회원정보 수정 
		public void userInfoUpdate(String userPw, String userName, String userTelno, String zipNo, String roadAddrPart1, String addrDetail, String userEmail ,String sessionuserId) {
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			try {
				conn = dataSource.getConnection();
				String query = "update userinfo set userPw = ?, userName = ?, userTelno = ? , zipNo = ?, roadAddrPart1 = ?, addrDetail = ?,userEmail = ? where userId = ?";
				preparedStatement = conn.prepareStatement(query);
//				preparedStatement.setString(1, userId);
				preparedStatement.setString(1, userPw);
				preparedStatement.setString(2, userName);
				preparedStatement.setString(3, userTelno);
				preparedStatement.setString(4, zipNo);
				preparedStatement.setString(5, roadAddrPart1);
				preparedStatement.setString(6, addrDetail);
				preparedStatement.setString(7, userEmail);
				preparedStatement.setString(8, sessionuserId);
				preparedStatement.executeUpdate();
				
				System.out.println("sessionuserId : " + sessionuserId);
				} catch(Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(rs != null) rs.close();
						if(preparedStatement != null) preparedStatement.close();
						if(conn != null) conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		}
		
		//예진합치기----------------------------------------------------------------------
		
		// id	 
		public boolean checkId(String userId) {
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			boolean result = false;
			try {
				conn = dataSource.getConnection();
				String query = "select * from userinfo where userId = ?";
//				String query = "select * from userinfo where userId = '" + userId + "'";
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, userId);
				rs = preparedStatement.executeQuery();
				
				if(rs.next()) {
					result = true; // id있을 때 ,
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(preparedStatement != null) preparedStatement.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result; // �뜲�씠�꽣踰좎씠�뒪 �삤瑜�
		}
		
		// 회원가입 정보 저장
		public void register(String userId, String userPw, String userName, String userTelno, String zipNo, String roadAddrPart1, String addrDetail,String userEmail) {
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			try {
				conn = dataSource.getConnection();
				String query = "insert into userinfo (userId, userPw, userName, userTelno, zipNo, roadAddrPart1, addrDetail, userEmail) values (?, ?, ?, ?, ?, ?, ?, ?)";
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, userId);
				preparedStatement.setString(2, userPw);
				preparedStatement.setString(3, userName);
				preparedStatement.setString(4, userTelno);
				preparedStatement.setString(5, zipNo);
				preparedStatement.setString(6, roadAddrPart1);
				preparedStatement.setString(7, addrDetail);
				preparedStatement.setString(8, userEmail);
				preparedStatement.executeUpdate();
				} catch(Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(rs != null) rs.close();
						if(preparedStatement != null) preparedStatement.close();
						if(conn != null) conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		}
}
	
	
