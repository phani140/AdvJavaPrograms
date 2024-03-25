package com.sathya.jdbc;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
public class jdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	    //step1:Load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully");
		
		//step2:create the connection
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		System.out.println("connection created successfully");
		
		//step3: static query execution
		java.sql.Statement statement=connection.createStatement();
		String q1="create table emp(id number,name varchar2(20),salary number)";
		int res1=statement.executeUpdate(q1);
		System.out.println("table created successfully"+res1);
		
		//step4:release the connection
		connection.close();
		System.out.println("connection closed successfully");
		

	}

}
