package com.adi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeUploader {
	
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			EmployeeUploader emp = new EmployeeUploader();
			int choice;
			do {
				System.out.println("----------------------------");
				System.out.println("1.Insert Department ");
				System.out.println("2.Insert Employee");
				System.out.println("3.Employee Retrive Data");
				System.out.println("4.Employee Calculate PF");
				System.out.println("5.Exit");
				System.out.print("Enter your choice: ");
				// read the user input
				choice = s.nextInt();
			
				// switch case to choose the the operation
				switch(choice) {
				
				// 1. Department
				case 1: 
					emp.storeDepartmentDetails();
				
					break;
				// 2. Employee
				case 2:
				
					emp.storeEmployeeDetails();
				
					break;
				// 3. Retrieve Data
				case 3:
					
					emp.retrieveEmployeeDetails();
					
					break;
				// 4. Calculate PF
				case 4:
					
					emp.calculatePF();
					
					break;
				// 5. Exit	
				case 5:
					System.out.println("Thank You.");
					
				default:
					break;
				}
			} while (choice!=5);
			
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// create a method to access connection
	public Connection getConnect() {

			// try block
			try {
				// register the driver with jdbc
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				// get connection from database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hadi_db","root","adiar143@");
				
				return conn;
			// catch block	
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
	
		
		
	public void calculatePF() throws SQLException{
		// call getConnection() method
		Connection conn = getConnect();
		Statement stm = conn.createStatement();
		System.out.print("Enter Employee ID: ");
		int id = s.nextInt();
		
		ResultSet rs = stm.executeQuery("SELECT * FROM employee where Employee_Id="+id);
		while(rs.next()) {
			if(rs.getDouble(4)>1000 && rs.getDouble(4)<10000){
				System.out.println("PF amount is "+rs.getDouble(4)*5/100);
			}
			else if(rs.getDouble(4)>10000 && rs.getDouble(4)<100000){
				System.out.println("PF amount is "+rs.getDouble(4)*6/100);
			}
			else if(rs.getDouble(4)>100000){
				System.out.println("PF amount is "+rs.getDouble(4)*7/100);
			}
		}
		rs.close();
		conn.close();
	}
	
	public void storeDepartmentDetails() throws SQLException {
		// call getConnection() method
		Connection conn = getConnect();
		String sql = "insert into department(Department_ID,Department_Name,Department_Head,Department_Description) values(?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		System.out.print("Enter Department ID: ");
		pstm.setInt(1, s.nextInt());
		System.out.print("Enter Department Name: ");
		pstm.setString(2, s.next());
		System.out.print("Enter Department Head: ");
		pstm.setString(3, s.next());
		System.out.print("Enter Department Description: ");
		pstm.setString(4, s.next());
		
		int x = pstm.executeUpdate();
		
		if(x == 1) {
			System.out.println("Record inserted succesfully.");
		}
		else {
			System.out.println("Duplicate Entry!");
		}
		conn.close();
	}
	
	
	public void storeEmployeeDetails() 
	{
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		try {
			// call getConnection() method
			Connection conn = getConnect();
			String sql = "insert into employee(Employee_Id,Employee_Name,Employee_Address,Employee_Salary,Employee_Contact_No,Department_Id) values(?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			System.out.print("Enter Employee ID: ");
			pstm.setInt(1, s.nextInt());
			System.out.print("Enter Employee Name: ");
			pstm.setString(2, s.next());
			System.out.print("Enter Employee Address: ");
			pstm.setString(3, s1.next());
			System.out.print("Enter Employee Salary: ");
			pstm.setDouble(4, s.nextDouble());
			System.out.print("Enter Employee Contact No: ");
			pstm.setLong(5, s.nextLong());
			System.out.print("Enter Department ID: ");
			pstm.setInt(6, s2.nextInt());
			
			int x = pstm.executeUpdate();
			
			if(x == 1) {
				System.out.println("Record inserted succesfully.");
			} 
			conn.close();
		} catch (Exception e) {
			System.out.println("Duplicate entry!");
		}
		
	}
	
	public void retrieveEmployeeDetails() throws SQLException 
	{
		
		System.out.print("Enter Emlpyee ID:");
		int id = s.nextInt();
		String sql = "SELECT Employee_Id,Employee_Name,Employee_Contact_No,Employee_Address,Department_Name,Department_Head from department left join employee on department.Department_Id = employee.Department_Id where Employee_Id="+id;
		Connection conn = getConnect();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
		} else {
			System.out.println("Employee Id not Present.");
		}
		rs.close();
		conn.close();
	}
	
}
