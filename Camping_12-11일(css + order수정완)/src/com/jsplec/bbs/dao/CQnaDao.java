package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.CQnaDto;

public class CQnaDao {

	DataSource dataSource;

	public CQnaDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 201201 인우---------------------------------------------
	
	//instance 생성
		//객체(Object)가 값을 갖을 경우에, 이를 인스턴스(Instance)라고 함
		private static CQnaDao instance = new CQnaDao();

		public static CQnaDao getInstance() {
			return instance;

		}
		
		
	// 게시판의 전체 글 수를 가져오는 메서드
		public int getBoardCount(String productNo) {
			String sql = "select count(*) from qna where product_pNo = ?";

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int boardCount=0;
			
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, productNo);
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
	
		
		public int getAdminBoardCount() {
			String sql = "select count(*) from qna";
			
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
		

	public ArrayList<CQnaDto> list(int page, int pageSize, String productNo) {
		
		//
		int startNum=((page-1)*pageSize);//전체 페이지 개수
		
		
		ArrayList<CQnaDto> qnadtos = new ArrayList<CQnaDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			connection = dataSource.getConnection();
//			String query = "select @ROWNUM := @ROWNUM + 1 as rno, q.* from qna q, (select @rownum :=0) tmp where order_product_pNo = ? ORDER BY rno LIMIT ?, 10 ";
			String query = "select @ROWNUM := @ROWNUM + 1 as rno, qnaNo, pName, qnaTitle, qnauserId, qnaDate, qnaSecret from qna q, product p, ";
			String A = "(select @rownum :=0) tmp where product_pNo = pNo and product_pNo = ? ORDER BY rno LIMIT ?, 3";
			preparedStatement = connection.prepareStatement(query + A);
			preparedStatement.setString(1, productNo);
			preparedStatement.setInt(2, startNum);
			
			resultSet = preparedStatement.executeQuery();
			

			while (resultSet.next()) {
				
//				CQnaDto qnadto = new CQnaDto();
				
//				qnadto.setQnaNo(resultSet.getInt("qnaNo"));
//				qnadto.setpName(resultSet.getString("product_pNo"));
//				qnadto.setQnaTitle(resultSet.getString("qnaTitle"));
//				
//				qnadto.setUserNo(resultSet.getString("userinfo_userNo"));
//				qnadto.setQnaSecret(resultSet.getString("qnaSecret"));
//				qnadto.setQnaDate(resultSet.getString("qnaDate"));
				int qnaNo = resultSet.getInt("qnaNo");
				String pName = resultSet.getString("pName");
				String qnaTitle = resultSet.getString("qnaTitle");
				String qnauserId = resultSet.getString("qnauserId");
				String qnaDate = sdf.format(resultSet.getTimestamp("qnaDate"));
				String qnaSecret = resultSet.getString("qnaSecret");
				
			
				
				CQnaDto qnadto = new CQnaDto(qnaNo, qnaSecret, pName, qnaTitle, qnauserId, qnaDate);
				qnadtos.add(qnadto);

				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // finally 에러가 걸리거나 안걸리거나 다 여기로 온다.
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return qnadtos;
	}
	
	
	public ArrayList<CQnaDto> listAll(int page, int pageSize) {
		
		//
		int startNum=((page-1)*pageSize);//전체 페이지 개수
		
		
		ArrayList<CQnaDto> qnadtos = new ArrayList<CQnaDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			connection = dataSource.getConnection();
//			String query = "select @ROWNUM := @ROWNUM + 1 as rno, q.* from qna q, (select @rownum :=0) tmp where order_product_pNo = ? ORDER BY rno LIMIT ?, 10 ";
			String query = "select @ROWNUM := @ROWNUM + 1 as rno, qnaNo, pName, qnaTitle, qnauserId, qnaDate, qnaSecret from qna q, product p, ";
			String A = "(select @rownum :=0) tmp where product_pNo = pNo ORDER BY rno LIMIT ?, 4";
			preparedStatement = connection.prepareStatement(query + A);
			preparedStatement.setInt(1, startNum);
			
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				
//				CQnaDto qnadto = new CQnaDto();
				
//				qnadto.setQnaNo(resultSet.getInt("qnaNo"));
//				qnadto.setpName(resultSet.getString("product_pNo"));
//				qnadto.setQnaTitle(resultSet.getString("qnaTitle"));
//				
//				qnadto.setUserNo(resultSet.getString("userinfo_userNo"));
//				qnadto.setQnaSecret(resultSet.getString("qnaSecret"));
//				qnadto.setQnaDate(resultSet.getString("qnaDate"));
				int qnaNo = resultSet.getInt("qnaNo");
				String pName = resultSet.getString("pName");
				String qnaTitle = resultSet.getString("qnaTitle");
				String qnauserId = resultSet.getString("qnauserId");
				String qnaDate = sdf.format(resultSet.getTimestamp("qnaDate"));
				String qnaSecret = resultSet.getString("qnaSecret");
				
				
				
				CQnaDto qnadto = new CQnaDto(qnaNo, qnaSecret, pName, qnaTitle, qnauserId, qnaDate);
				qnadtos.add(qnadto);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // finally 에러가 걸리거나 안걸리거나 다 여기로 온다.
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return qnadtos;
	}
	
	
	// 201128 세미------------
		public void qnawrite(String qnaTitle, String qnaContent, String qnauserId, String product_pNo, String userNo, String qnaSecret) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "insert into qna (userinfo_userNo, qnauserId, product_pNo, qnaTitle, qnaContent, qnaSecret, qnaDate) values (?, ?, ?, ?, ?, ?, now())";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userNo);
				preparedStatement.setString(2, qnauserId);
				preparedStatement.setString(3, product_pNo);
				preparedStatement.setString(4, qnaTitle);
				preparedStatement.setString(5, qnaContent);
				preparedStatement.setString(6, qnaSecret);
				preparedStatement.execute();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {		//finally 에러가 걸리거나 안걸리거나 다 여기로 온다.
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	// 201130 세미------------
		public CQnaDto qnaView(String strqnaNo) {
			CQnaDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select qnaNo, userinfo_userNo, qnauserId, qnaTitle, qnaContent, qnaComment from qna where qnaNo = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(strqnaNo));
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int qnaNo = Integer.parseInt(resultSet.getString("qnaNo"));
					int userNo = Integer.parseInt(resultSet.getString("userinfo_userNo"));
					String qnauserId = resultSet.getString("qnauserId");
					String qnaTitle = resultSet.getString("qnaTitle");
					String qnaContent = resultSet.getString("qnaContent");
					String qnaComment = resultSet.getString("qnaComment");
					
					dto = new CQnaDto(userNo, qnaNo, qnaTitle, qnauserId, qnaContent, qnaComment);
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {		//finally 에러가 걸리거나 안걸리거나 다 여기로 온다.
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return dto;
		}
	
//	// 201201 세미------------
//	public void qnaModify(String userName, String qnaContent) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "update qna set qnaContent = ? where userinfo_userNo = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, qnaContent);
//			preparedStatement.setInt(2, Integer.parseInt(userName));
//			
//			preparedStatement.execute();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {		//finally 에러가 걸리거나 안걸리거나 다 여기로 온다.
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//				
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

	// 201201 세미------------
			public void qnaModify(String qnauserId, String qnaContent, String qnaTitle) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				try {
					connection = dataSource.getConnection();
					String query = "update qna set qnaContent = ? where qnaNo = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, qnaContent);
					preparedStatement.setString(2, qnauserId);
					
					preparedStatement.execute();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {		//finally 에러가 걸리거나 안걸리거나 다 여기로 온다.
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
						
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			
			public void qnadelete(String userNo) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				try {
					connection = dataSource.getConnection();
					String query = "delete from qna where qnaNo = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, Integer.parseInt(userNo));
					preparedStatement.execute();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {		//finally 에러가 걸리거나 안걸리거나 다 여기로 온다.
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
						
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			// 201203 세미 qna댓글기능 ------------
					public void qnaComment(String qnaComment, String qnaNo) {
						Connection connection = null;
						PreparedStatement preparedStatement = null;
						System.out.println("qnaComment :" + qnaComment);
						
						try {
							connection = dataSource.getConnection();
							String query = "update qna set qnaComment = ? where qnaNo= ?";
							preparedStatement = connection.prepareStatement(query);
							preparedStatement.setString(1, qnaComment);
							preparedStatement.setInt(2, Integer.parseInt(qnaNo));
							
							preparedStatement.executeUpdate();
						}catch (NumberFormatException e) {
							System.out.println("오류남");
							System.out.println(e);
						}
						catch(Exception e) {
							e.printStackTrace();
						}finally {		//finally 에러가 걸리거나 안걸리거나 다 여기로 온다.
							try {
								if(preparedStatement != null) preparedStatement.close();
								if(connection != null) connection.close();
								
							}catch (Exception e) {
								
								e.printStackTrace();
								System.out.println(e);
							}
						}
					}

	// ----------------------

}
