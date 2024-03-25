package com.sathya.mysql;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mySqlEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/chinnu","root","root");
		
		System.out.println("connection created with mysql database");
		
		//create table
		/*java.sql.Statement statement=connection.createStatement();
		statement.executeUpdate("create table emp(eid int,ename varchar(20),esal float);");
        System.out.println("table created successfully");*/
        
        //insert values
		PreparedStatement preparedStatement=connection.prepareStatement("insert into emp values(?,?,?);");
		preparedStatement.setInt(1, 111);
		preparedStatement.setString(2, "chinni");
		preparedStatement.setFloat(3, 100000.45f);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 222);
		preparedStatement.setString(2, "chinnu");
		preparedStatement.setFloat(3, 10000.65f);
		preparedStatement.addBatch();
        
		
		preparedStatement.setInt(1, 333);
		preparedStatement.setString(2, "gopi");
		preparedStatement.setFloat(3, 20000.98f);
		preparedStatement.addBatch();
		
		preparedStatement.executeBatch();
		
		System.out.println("inserted values successfully");
		
		//close the connection
		connection.close();
		System.out.println("connection closed");
        
        
        
	}

}
