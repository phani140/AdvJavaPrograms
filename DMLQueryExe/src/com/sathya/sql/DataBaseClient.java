package com.sathya.sql;
import java.sql.*;
import java.util.List;
public class DataBaseClient {

	public static void main(String[] args) {
		EmployeeDao employeeDao=new EmployeeDao();
		
		
		/*//save method calling
		int res1=employeeDao.save(new Employee(1001,"RAM",10000));
		System.out.println("data inserted successfully"+res1);
		int res2=employeeDao.save(new Employee(1002,"nani",20000));
		System.out.println("data inserted successfully"+res2);*/
		
		
		/*//Employee method calling
		Employee emp=employeeDao.findById(1004);
		System.out.println(emp);*/
		
		/*//delete method calling
		int count=0;
		count=employeeDao.deleteById(1001);
		if(count==1) {
			System.out.println("Data Deleted Successfully");
		}
		else {
			System.out.println("Data Deletion fail");
		}*/
		
		
		//delete salary method calling
		int count=employeeDao.deleteBySalary(10000);
		System.out.println("No of records delete are "+count);
		
		
		/*//findall method
		List<Employee> emps=employeeDao.findAll();
		emps.forEach(emp->System.out.println(emp));*/
		
		/*//updateSalary
		int count=employeeDao.updateSalary(100000, 10000);
		System.out.println(count+"rows updated");*/
		
		
	}

}
