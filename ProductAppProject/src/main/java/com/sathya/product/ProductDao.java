package com.sathya.product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ProductDao
{
	
	public int save(Product product) {
		//Declare the Resources
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int saveResult=0;
		try {
			//Get the connection
			 connection= DbConnectionutils.createConnection();
			//Create the PS object
			preparedStatement=connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?,?,?)");
			//Read the data from pro object and set to parameters
			preparedStatement.setString(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setFloat(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			preparedStatement.setDate(6, product.getProMfgDate());
			preparedStatement.setDate(7, product.getProExpDate());
			preparedStatement.setBytes(8,product.getProImage());
			preparedStatement.setBytes(9,product.getProAudio());
			preparedStatement.setBytes(10,product.getProVideo());
			
			saveResult=preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		finally
		{
			//Before release connection check the connection present or not
			try{
				if(connection!=null)
			      connection.close();
			    if(preparedStatement!=null)
				  preparedStatement.close();
			}
			catch(SQLException e) {
			     e.printStackTrace();
			}
		}
		return saveResult;
	}
	
	
	//findall method
	public List<Product> findAll(){
		List<Product> productList=new ArrayList<Product>();
		try(Connection connection=DbConnectionutils.createConnection(); Statement statement=connection.createStatement()){
			ResultSet resultSet=statement.executeQuery("select * from product_data");
			while(resultSet.next()) {
				Product product=new Product();
				product.setProId(resultSet.getString("proId"));
				product.setProName(resultSet.getString("proName"));
				product.setProPrice(resultSet.getFloat("proPrice"));
				product.setProBrand(resultSet.getString("proBrand"));
				product.setProMadeIn(resultSet.getString("proMadeIn"));
				product.setProMfgDate(resultSet.getDate("proMfgDate"));
				product.setProExpDate(resultSet.getDate("proExpDate"));
				product.setProImage(resultSet.getBytes("proImage"));
				product.setProAudio(resultSet.getBytes("proAudio"));
				product.setProVideo(resultSet.getBytes("proVideo"));

				

				
				
				productList.add(product);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList ;	
		
	}
	
	//delete by id
	public int deleteById(String proId) {
		int count=0;
		try (Connection connection=DbConnectionutils.createConnection(); 
				PreparedStatement preparedStatement=connection.prepareStatement("delete product_data where proId=?")){ 
			preparedStatement.setString(1, proId);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	//findById  method 
		public Product findById(String proId) 
		{
			Product product=null;
			try (Connection connection=DbConnectionutils.createConnection(); 
					PreparedStatement preparedStatement=connection.prepareStatement("select * from product_data where proId=?")){ 
				preparedStatement.setString(1, proId);
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next())
				{
					product =new Product();
					product.setProId(resultSet.getString("proId"));
					product.setProName(resultSet.getString("proName"));
					product.setProPrice(Float.parseFloat(resultSet.getString("proPrice")));
					product.setProBrand(resultSet.getString("proBrand"));
					product.setProMadeIn(resultSet.getString("proMadeIn"));
					product.setProMfgDate(resultSet.getDate("proMfgDate"));
					product.setProExpDate(resultSet.getDate("proExpDate"));
					product.setProImage(resultSet.getBytes("proImage"));
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return product;	
		}
		
		
		//update by id
		public int UpdateById(Product product) {
			int updateResult=0;
			try (Connection connection=DbConnectionutils.createConnection(); 
				PreparedStatement preparedStatement=connection.prepareStatement("UPDATE product_data SET proName=?,proPrice=?,proBrand=?,proMadeIn=?,proMfgDate=?,proExpDate=? ,proImage=? where proId=?")){ 
				preparedStatement.setString(1,product.getProName());
				preparedStatement.setDouble(2,product.getProPrice());
				preparedStatement.setString(3,product.getProBrand());
				preparedStatement.setString(4,product.getProMadeIn());
				preparedStatement.setDate(5,product.getProMfgDate());
				preparedStatement.setDate(6,product.getProExpDate());
				preparedStatement.setBytes(7,product.getProImage());
				preparedStatement.setString(8,product.getProId());
				updateResult=preparedStatement.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return updateResult;
		
		}	
		
		
		
}



			
		
