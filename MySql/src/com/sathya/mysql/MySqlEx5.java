package com.sathya.mysql;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class MySqlEx5 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
       
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/chinnu","root","root");
		
		//case-1: rowSet printing the data by default scrolling nature
		java.sql.Statement statement=connection.createStatement();
		ResultSet set=statement.executeQuery("select * from emp;");
		CachedRowSet rowSet=RowSetProvider.newFactory().createCachedRowSet();
		
		rowSet.populate(set);
		rowSet.afterLast();
		while(rowSet.previous()) {
			System.out.println(rowSet.getInt(1)+" "+rowSet.getString(2)+" "+rowSet.getFloat(3));
		}
		
		connection.close();
		
		//case-2:After closing connection data reading from rowSet
		
		
		
		
	}

}
