package com.sathya.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class MySqlEx4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/chinnu","root","root");
		
		java.sql.DatabaseMetaData metaData=connection.getMetaData();
		System.out.println(metaData.getDatabaseProductName());
		System.out.println(metaData.getDatabaseProductVersion());
		System.out.println(metaData.getDriverName());
		System.out.println(metaData.getUserName());
		System.out.println(metaData.getDriverVersion());
		System.out.println(metaData.getURL());
		
		connection.close();
		
		
	}

}
