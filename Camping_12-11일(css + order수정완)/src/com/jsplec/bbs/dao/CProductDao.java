package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.CProductDto;

public class CProductDao {

	DataSource dataSource;

	public CProductDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public CProductDto contentView(String strpNo) {
		CProductDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select pNo, pName, pCategory, pPrice, pFile, pSubFile from product where pNo = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strpNo));
			resultSet = preparedStatement.executeQuery();
			
			/*불러올 데이터가 있으면 while문 실행*/
			if(resultSet.next()) {
				int pNo = resultSet.getInt("pNo");
				String pName = resultSet.getString("pName");
				String pCategory = resultSet.getString("pCategory");
				String pPrice = resultSet.getString("pPrice");
				String pFile = resultSet.getString("pFile");
				String pSubFile = resultSet.getString("pSubFile");
				
				dto = new CProductDto(pNo, pName, pCategory, pPrice, pFile, pSubFile);
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
		}return dto; // 여러개 아니라 한개의 데이터만 꺼내니까
	}
	
	
	public void registerProduct(String pName, String pCategory, String pPrice,String pFile, String pSubFile, String pStock) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			conn = dataSource.getConnection();
			String query = "insert into product (pName, pCategory, pPrice, pFile, pSubFile, pStock) values (?, ?, ?, ?, ?, ?)";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, pName);
			preparedStatement.setString(2, pCategory);
			preparedStatement.setString(3, pPrice);
			preparedStatement.setString(4, pFile);
			preparedStatement.setString(5, pSubFile);
			preparedStatement.setString(6, pStock);
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
	
	
	
	public ArrayList<CProductDto> productlist() {
		
		
		//인우 int startNum=((page-1)*pageSize);//전체 페이지 개수
		
		ArrayList<CProductDto> productdtos = new ArrayList<CProductDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			connection = dataSource.getConnection();
			//인우 String query = "select @ROWNUM := @ROWNUM + 1 as rno, q.* from qna q, (select @rownum :=0) tmp ORDER BY rno LIMIT ?, 10";
			String query = "select pNo, pName, pCategory, pStock, pFile, pPrice from product pNo";
			preparedStatement = connection.prepareStatement(query);
			//인우 preparedStatement.setInt(1, startNum);
			resultSet = preparedStatement.executeQuery();
			

			while (resultSet.next()) {
				int pNo = resultSet.getInt("pNo");
				String pName = resultSet.getString("pName");
				String pCategory = resultSet.getString("pCategory");
				int pStock = resultSet.getInt("pStock");
				String pFile = resultSet.getString("pFile");
				String pPrice = resultSet.getString("pPrice");
				
			
				
				CProductDto productdto = new CProductDto(pNo, pName, pCategory, pPrice, pFile, pStock);
				productdtos.add(productdto);

				
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
		return productdtos;
	}
	
	
	
}

