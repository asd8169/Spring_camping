package com.jsplec.bbs.dao;
/*class 파일*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.CCartDto;
import com.jsplec.bbs.dto.CWishDto;
import com.mysql.cj.Session;


public class CWishlistDao {
	//database 쓰는 곳 
	
	//Field
	DataSource dataSource;
	
	// Constructor
	public CWishlistDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Method
		// 게시글 추천여부 검사
			public int recCheck(int userNo, int pNo){
				int result = 0;
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				int id = userNo;
				int no = pNo;
				
				try {
					connection = dataSource.getConnection();
					String query = "select count(*) from wishlist where userinfo_userNo = ? and product_pNo = ?";
					preparedStatement = connection.prepareStatement(query);
					
					preparedStatement.setInt(1, id);
					preparedStatement.setInt(2, no);
					
					resultSet = preparedStatement.executeQuery();
					
					if (resultSet.next()) {
						result = resultSet.getInt(1);
						
					}
					
				}
				catch (Exception e) {
					System.out.println("recCheck : " + e);
					e.printStackTrace();
				}finally {	//에러가 걸리든 걸리지 않든 오는 곳 
					try {
						/*정보가 들어있으면 모두 지우라는 뜻 */
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
						
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
				return result;
			}
		
		// 게시글 추천
		public void recUpdate(int userNo, int pNo){
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "insert into wishlist (userinfo_userNo, product_pNo) values (?, ?)";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, userNo);
				preparedStatement.setInt(2, pNo);
				preparedStatement.executeUpdate();
				
				
			} catch (Exception e) {
				System.out.println("recUpdate : " + e);
				e.printStackTrace();
			}finally {	//에러가 걸리든 걸리지 않든 오는 곳 
				try {
					/*정보가 들어있으면 모두 지우라는 뜻 */
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		// 위시리스트 제거
		public void recDelete(int userNo, int pNo){
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = dataSource.getConnection();
				
				
				String query = "delete from wishlist where userinfo_userNo = ? and product_pNo = ?";
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt(1, userNo);
				preparedStatement.setInt(2, pNo);
				
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println("recDelete : " + e);
				e.printStackTrace();
			}finally {	//에러가 걸리든 걸리지 않든 오는 곳 
				try {
					/*정보가 들어있으면 모두 지우라는 뜻 */
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				}
			
			
		}
		
		// 위시리스트 리스트업
		public ArrayList<CWishDto> wishlist(int userNo) {
			ArrayList<CWishDto> dtos = new ArrayList<CWishDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select pNo, pFile, pName, pPrice " + 
								"from product p, wishlist w " + 
									"where product_pNo = pNo and userinfo_userNo = ?";
				preparedStatement = connection.prepareStatement(query);
				System.out.println(query);
				preparedStatement.setInt(1, userNo);
				resultSet = preparedStatement.executeQuery();
				
				/*불러올 데이터가 있으면 while문 실행*/
				while(resultSet.next()) {
					int pNo = resultSet.getInt(1);
					String pFile = resultSet.getString("pFile");
					String pName = resultSet.getString("pName");
					String pPrice = resultSet.getString("pPrice");
					
					CWishDto dto = new CWishDto(pNo, pFile, pName, pPrice);
					dtos.add(dto);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {	//에러가 걸리든 걸리지 않든 오는 곳 
				try {
					/*정보가 들어있으면 모두 지우라는 뜻 */
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtos;
			
		}
		
		
//		// 게시글 추천수
//		public int recCount(int no){
//			int count = 0;
//			try {
//				session = getSession();
//				count = (Integer) session.selectOne("board.rec_count", no);
//			} catch (Exception e) {
//				System.out.println("recCount : " + e);
//				e.printStackTrace();
//			}
//			return count;
//		}
//	
	
//	
//	
//	public ArrayList<BDto> list(){
//		ArrayList<BDto> dtos = new ArrayList<BDto>();
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
//			preparedStatement = connection.prepareStatement(query);
//			resultSet = preparedStatement.executeQuery();
//			
//			/*불러올 데이터가 있으면 while문 실행*/
//			while(resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				
//				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate);
//				dtos.add(dto);
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {	//에러가 걸리든 걸리지 않든 오는 곳 
//			try {
//				/*정보가 들어있으면 모두 지우라는 뜻 */
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//				
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}return dtos;
//	}	//list() method 끝 
//	
//	public int write(String bName,String bTitle,String bContent) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		int chk = 0;
//		try {
//			connection = dataSource.getConnection();
//			String query = "insert into mvc_board (bName, bTitle, bContent, bDate) values (?, ?, ?, now())";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, bName);
//			preparedStatement.setString(2, bTitle);
//			preparedStatement.setString(3, bContent);
//			preparedStatement.executeUpdate();
//			
//			chk = 1;
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {	//에러가 걸리든 걸리지 않든 오는 곳 
//			try {
//				/*정보가 들어있으면 모두 지우라는 뜻 */
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//				
//			}catch (Exception e) {
//				e.printStackTrace();
//				chk = 0;
//			}
//		}
//		return chk;
//	}
//	
//	public BDto contentView(String strbId) {
//		BDto dto = null;
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "select * from mvc_board where bId = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Integer.parseInt(strbId));
//			resultSet = preparedStatement.executeQuery();
//			
//			/*불러올 데이터가 있으면 while문 실행*/
//			if(resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				
//				dto = new BDto(bId, bName, bTitle, bContent, bDate);
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {	//에러가 걸리든 걸리지 않든 오는 곳 
//			try {
//				/*정보가 들어있으면 모두 지우라는 뜻 */
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//				
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}return dto; // 여러개 아니라 한개의 데이터만 꺼내니까
//	}
//	
	public void modify(String bId,String bName,String bTitle,String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bId));
			preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {	//에러가 걸리든 걸리지 않든 오는 곳 
			try {
				/*정보가 들어있으면 모두 지우라는 뜻 */
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
//
//	public void delete(String bId) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "delete from mvc_board where bId = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Integer.parseInt(bId));
//			preparedStatement.executeUpdate();
//			
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {	//에러가 걸리든 걸리지 않든 오는 곳 
//			try {
//				/*정보가 들어있으면 모두 지우라는 뜻 */
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//				
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	
}
