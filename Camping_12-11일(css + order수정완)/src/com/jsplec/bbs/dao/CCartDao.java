package com.jsplec.bbs.dao;

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

public class CCartDao {

	DataSource dataSource;
	
	public CCartDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	// Method
		// cart에 존재하는지 검사
			public int cartCheck(int userNo, int pNo){
				int result = 0;
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				int id = userNo;
				int no = pNo;
				System.out.println(id +"  " + no);
				try {
					connection = dataSource.getConnection();
					String query = "select count(*) from cart where userinfo_userNo = ? and product_pNo = ?";
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
			
			
			
			
			
			// cart 최초 추가
			public void cartInsert(int userNo, int pNo, int cartQuantity){
				
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				try {
					connection = dataSource.getConnection();
					String query = "insert into cart (userinfo_userNo, product_pNo, cartQuantity) values (?, ?, ?)";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, userNo);
					preparedStatement.setInt(2, pNo);
					preparedStatement.setInt(3, cartQuantity);
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
			
			// cart 수정
			public void cartUpdate(int userNo, int pNo, int cartQuantity) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				try {
					connection = dataSource.getConnection();
					String query = "update cart set cartQuantity = cartQuantity + ? where userinfo_userNo = ? and product_pNo = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, cartQuantity);
					preparedStatement.setInt(2, userNo);
					preparedStatement.setInt(3, pNo);
//					preparedStatement.setString(3, bContent);
//					preparedStatement.setInt(4, Integer.parseInt(bId));
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
			
			
			
			// cart 제거
			public void cartDelete(int cartNo){
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				try {
					connection = dataSource.getConnection();
					
					
					String query = "delete from cart where cartNo = ?";
					preparedStatement = connection.prepareStatement(query);
					
					preparedStatement.setInt(1, cartNo);
					
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
			
			// 해당 아이디의 cart 전체 제거
			public void cartAllDelete(int userNo){
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				try {
					connection = dataSource.getConnection();
					
					
					String query = "delete from cart where userinfo_userNo = ?";
					preparedStatement = connection.prepareStatement(query);
					
					preparedStatement.setInt(1, userNo);
					
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
			
			// cart 수정
			public void cartUpdate(int cartNo, int cartQuantity){
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				try {
					connection = dataSource.getConnection();
					
					
					String query = "update cart set cartQuantity = ? where cartNo = ?";
					preparedStatement = connection.prepareStatement(query);
					
					preparedStatement.setInt(1, cartQuantity);
					preparedStatement.setInt(2, cartNo);
					
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
			
			public ArrayList<CCartDto> cartlist(int userNo) {
				ArrayList<CCartDto> dtos = new ArrayList<CCartDto>();
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				try {
					connection = dataSource.getConnection();
					String query = "select cartNo, pFile, pName, cartQuantity, cartQuantity*pPrice " + 
									"from product p, cart c " + 
										"where product_pNo = pNo and userinfo_userNo = ?";
					preparedStatement = connection.prepareStatement(query);
					System.out.println(query);
					preparedStatement.setInt(1, userNo);
					resultSet = preparedStatement.executeQuery();
					
					/*불러올 데이터가 있으면 while문 실행*/
					while(resultSet.next()) {
						int cartNo = resultSet.getInt("cartNo");
						String pFile = resultSet.getString("pFile");
						String pName = resultSet.getString("pName");
						int cartQuantity = Integer.parseInt(resultSet.getString("cartQuantity"));
						int sum = resultSet.getInt("cartQuantity*pPrice");
						
						CCartDto dto = new CCartDto(cartNo, cartQuantity, pFile, pName, sum);
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
			
			
			
			
			public int totalPrice(int userNo) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				int totalPrice = 0;
				
				try {
					connection = dataSource.getConnection();
					String query = "select userinfo_userNo, sum(cartQuantity*pPrice) " + 
							"from product p, cart c " + 
							"where product_pNo = pNo and userinfo_userNo = ? " + 
							"group by userinfo_userNo";
					preparedStatement = connection.prepareStatement(query);
					System.out.println(query);
					preparedStatement.setInt(1, userNo);
					resultSet = preparedStatement.executeQuery();
					
					/*불러올 데이터가 있으면 while문 실행*/
					if(resultSet.next()) {
						totalPrice = resultSet.getInt("sum(cartQuantity*pPrice)");
						
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
				
				return totalPrice;
				
			}
			
			public ArrayList<CCartDto> getCartInfo(int userNo) {
				ArrayList<CCartDto> dtos = new ArrayList<CCartDto>();
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				try {
					connection = dataSource.getConnection();
					String query = "select * from cart where userinfo_userNo = ?";
					preparedStatement = connection.prepareStatement(query);
					System.out.println(query);
					preparedStatement.setInt(1, userNo);
					resultSet = preparedStatement.executeQuery();
					
					/*불러올 데이터가 있으면 while문 실행*/
					while(resultSet.next()) {
						int pNo = resultSet.getInt("product_pNo");
						int cartQuantity = Integer.parseInt(resultSet.getString("cartQuantity"));
						
						CCartDto dto = new CCartDto(pNo, cartQuantity);
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
			
			
			
	
	
}
