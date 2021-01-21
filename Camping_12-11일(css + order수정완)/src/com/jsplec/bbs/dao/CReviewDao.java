package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.CReviewDto;
import com.jsplec.bbs.dto.CUserInfoDto;

public class CReviewDao {
	
	DataSource dataSource;

	public CReviewDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//instance 생성
	//객체(Object)가 값을 갖을 경우에, 이를 인스턴스(Instance)라고 함
	private static CReviewDao instance = new CReviewDao();

	public static CReviewDao getInstance() {
		return instance;

	}
	
	
	// 게시판의 전체 글 수를 가져오는 메서드
				public int getBoardCount(String productNo) {
					String sql = "select count(*) from review where order_product_pNo = ?";
						
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
	
	// 리뷰 등록
	public void registerReview(String userId, String reviewNo, String orderNo, String productNo, String reviewContent, String reviewFile, String reviewDate) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "insert into review (order_orderNo, order_userinfo_userNo, order_product_pNo, reviewContent, reviewFile, reviewDate) values (?, ?, ?, ?, ?, now())";
			preparedStatement = conn.prepareStatement(query);
			
//			preparedStatement.setString(1, productNo);
			System.out.println("productNo :" + productNo);
			preparedStatement.setString(1, orderNo);
			preparedStatement.setString(2, userId);
			preparedStatement.setString(3, productNo);
			preparedStatement.setString(4, reviewContent);
			System.out.println(reviewContent);
			preparedStatement.setString(5, reviewFile);
			preparedStatement.executeUpdate();
			
			
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println(e);
				System.out.print("DB오류임");
			} finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.print(e);
					System.out.print("finally오류임");
				}
			}
	}
	
	
	// reivew 목록 불러오기 + 리뷰 보기 
		public ArrayList<CReviewDto> reviewList(int page, int pageSize,String productNo){
			
			
			//paging
			
			int startNum=((page-1)*pageSize);//전체 페이지 개수
			
			
			ArrayList<CReviewDto> dtos = new ArrayList<CReviewDto>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select @ROWNUM := @ROWNUM + 1 as rno, r.* from review r, (select @rownum :=0) tmp where order_product_pNo = ? ORDER BY rno LIMIT ?, 3";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, productNo);
				preparedStatement.setInt(2, startNum);
		
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int reviewNo = resultSet.getInt("reviewNo");
					int orderNo = resultSet.getInt("order_orderNo");
					int userNo = resultSet.getInt("order_userinfo_userNo");
					int pNo = resultSet.getInt("order_product_pNo");
					String reviewContent = resultSet.getString("reviewContent");
					String reviewFile = resultSet.getString("reviewFile");
					Timestamp reviewDate = resultSet.getTimestamp("reviewDate");
					
					CReviewDto dto = new CReviewDto(reviewNo, userNo, pNo, orderNo, reviewFile, reviewContent, reviewDate);
					dtos.add(dto);
					
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
			return dtos;
		}
	
	

	// 리뷰 수정하기
	
	public void reviewModify(String reviewNo, String reviewContent) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "update review set reviewContent = ? where reviewNo = ?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, reviewContent);
			preparedStatement.setInt(2, Integer.parseInt(reviewNo));
			preparedStatement.executeUpdate();
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	
	// 리뷰 삭제하기
	public void deleteReview(String reviewNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// DB와 연결하자 (server-context.xml에 다 정의해 놨으니까 불러쓰자~)
			connection = dataSource.getConnection();
			
			String query = "delete from review where reviewNo = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(reviewNo));
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 아래 3개는 에러가 걸리든 안걸리든 꼭 종료를 해주는 것이 좋다.
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
} // 끝
