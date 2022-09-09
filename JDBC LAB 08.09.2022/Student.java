package com.adi;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			Student sdt = new Student();
			int choice;
			do {
				System.out.println("----------------------------");
				System.out.println("1. Class Test 1 ");
				System.out.println("2. Class Test 2");
				System.out.println("3. Class Test 3");
				System.out.println("4. Student Fees");
				System.out.println("5.Exit");
				System.out.print("Enter your choice: ");
				// read the user input
				choice = s.nextInt();
			
				// switch case to choose the the operation
				switch(choice) {
				
				 
				 
				// 2. Employee
				case 1:
				
					sdt.storeClassTest1();
				
					break;
				// 3. Retrieve Data
				case 2:
					
					sdt.retrieveClassTest2();
					
					break;
				// 4. Calculate PF
				case 3:
					
					sdt.ClassTest3();
					
					break;
				// 5. Exit	
				case 4:
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
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","adiar143@");
				
				return conn;
			// catch block	
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
	
		
		
	public void ClassTest3() throws SQLException{
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
	
	 
	
	public void storeClassTest1() 
	{
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		try {
			// call getConnection() method
			Connection conn = getConnect();
			String sql = "insert into student(Test_Cases,Student_id,Grade,MonthlyFees,Is_ScholarshipEligible,Output) values(?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			System.out.print("Enter Test_Cases: ");
			pstm.setInt(1, s.nextInt());
			System.out.print("Enter Student_id: ");
			pstm.setString(2, s.next());
			System.out.print("Enter Grade: ");
			pstm.setString(3, s1.next());
			System.out.print("Enter MonthlyFees: ");
			pstm.setDouble(4, s.nextDouble());
			System.out.print("Enter Is_ScholarshipEligible: ");
			pstm.setLong(5, s.nextLong());
			System.out.print("Enter Output: ");
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
	
	public void retrieveClassTest2() throws SQLException 
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
