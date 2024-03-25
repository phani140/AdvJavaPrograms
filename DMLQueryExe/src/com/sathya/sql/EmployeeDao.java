package com.sathya.sql;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
public class EmployeeDao {
	
	
	/*//save method
	  public int save(Employee emp) {
		//Declare the Resources
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		try {
			//Get the connection
			connection=DbConnection.createConnection();
			//Create the PS object
			preparedStatement=connection.prepareStatement("insert into Employee values(?,?,?)");
			//Read the data from emps object and set to parameters
			preparedStatement.setInt(1, emp.getEmpId());
			preparedStatement.setString(2, emp.getEmpName());
			preparedStatement.setDouble(3, emp.getEmpSalary());
			count=preparedStatement.executeUpdate();
			
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
		return count;
	}*/
	
	//findById  method 
	public Employee findById(int empId) 
	{
		Employee employee=null;
		try (Connection connection=DbConnection.createConnection(); PreparedStatement preparedStatement=connection.prepareStatement("select * from Employee where empId=?")){ 
			preparedStatement.setInt(1, empId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				employee =new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	return employee;	
	}
	
	
	/*//DeleteById
	public int deleteById(int empId) {
		int count=0;
		try (Connection connection=DbConnection.createConnection(); PreparedStatement preparedStatement=connection.prepareStatement("delete Employee where empId=?")){ 
			preparedStatement.setInt(1, empId);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}*/
	
	
	//delete records based on salary
	public int deleteBySalary(double empSalary) {
		int count=0;
		try (Connection connection=DbConnection.createConnection(); PreparedStatement preparedStatement=connection.prepareStatement("delete Employee where empSalary>?")){ 
			preparedStatement.setDouble(1, empSalary);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}
	
	/*//get all employee data
	public List<Employee> findAll()
	{
		List<Employee> emp=new ArrayList<Employee>();
		try (Connection connection=DbConnection.createConnection(); Statement statement=connection.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select * from Employee");
			while(resultSet.next()) {
				Employee employee=new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
				emp.add(employee);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}*/
	
	//update salary
	public int updateSalary(double currentSalary,double incSalary)
	{
		int count=0;
		try (Connection connection=DbConnection.createConnection(); PreparedStatement preparedStatement=connection.prepareStatement("update Employee set empSalary=empSalary+? where empSalary>?")){ 
			preparedStatement.setDouble(1, incSalary);
			preparedStatement.setDouble(2, currentSalary);
			count=preparedStatement.executeUpdate();
		
	    }
		catch(SQLException e)
		{
			e.printStackTrace();
	    }
		return count;
	}
}	
	


		


