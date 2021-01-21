package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.CMyReviewDto;
import com.jsplec.bbs.dto.CReviewDto;

public class CMyReviewDao {

	DataSource dataSource;
	
	public CMyReviewDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
	
	
	// 싱글 객체 선언
		private static CMyReviewDao instance = new CMyReviewDao();

		public static CMyReviewDao getInstance() {
			return instance;

		}
		
	// My reivew list 불러오기 + 리뷰 보기 // + 인우씨 페이징
		public ArrayList<CMyReviewDto> myreviewList(int userNo, int page, int pageSize){
			//paging
			
			int startNum=((page-1)*pageSize);//전체 페이지 개수
			
			
			ArrayList<CMyReviewDto> dtos = new ArrayList<CMyReviewDto>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select @ROWNUM := @ROWNUM + 1 as rno, reviewNo, order_orderNo, pName, reviewFile, reviewContent, reviewDate from product, review, ";
				String A = "(select @rownum :=0) tmp where order_userinfo_userNo = ? and order_product_pNo = pNo ORDER BY rno LIMIT ?, 4";
				
				preparedStatement = connection.prepareStatement(query+A);
				preparedStatement.setInt(1, userNo);
				preparedStatement.setInt(2, startNum);
		
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int reviewNo = resultSet.getInt("reviewNo");
					int orderNo = resultSet.getInt("order_orderNo");
					String pName = resultSet.getString("pName");
					String reviewContent = resultSet.getString("reviewContent");
					String reviewFile = resultSet.getString("reviewFile");
					Timestamp reviewDate = resultSet.getTimestamp("reviewDate");
					
					CMyReviewDto dto = new CMyReviewDto(reviewNo, orderNo, pName, reviewFile, reviewContent, reviewDate);
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
	
		
		
		
		// 인우씨 -------------------------------------------------------------------------
		// 게시판의 전체 글 수를 가져오는 메서드
		
		public int getBoardCount() {
			String sql = "select count(*) from review ";

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
		
		// 리뷰 수정
		public void myreviewModify(String reviewNo, String reviewContent) {
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
		public void deleteMyReview(String reviewNo) {
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
		
		
		
		
		
}// 끝
