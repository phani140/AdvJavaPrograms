package com.sathya.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class MySqlEx3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/chinnu","root","root");
		
		java.sql.Statement statement=connection.createStatement();
		
		//storing data into resultSet
		ResultSet resultSet=statement.executeQuery("select * from emp");
		
		java.sql.ResultSetMetaData metaData=resultSet.getMetaData();
		System.out.println(metaData.getColumnCount());
		System.out.println(metaData.getColumnName(2));
		System.out.println(metaData.getColumnTypeName(2));
		System.out.println(metaData.getColumnDisplaySize(2));
		
		connection.close();
		
		

	}

}
