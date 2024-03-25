package com.sathya.mysql;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlEx2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/chinnu","root","root");
		
		java.sql.Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		ResultSet set=statement.executeQuery("select * from emp");
		
		//reverse of records
		set.afterLast();
		while(set.previous()) {
			System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getFloat(3));
		}
		
		//cursor is pointing to first record
		set.first();
		System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getFloat(3));
		
		//cursor is last
		set.last();
		System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getFloat(3));
		
		//cursor is pointing to specific record
		set.absolute(2);
		System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getFloat(3));
		
		connection.close();
		System.out.println("connection released");
	}

}
