package com.adi1codes.example;

import java.sql.*;
 public class Select
 {
     Connection cnt;
     PreparedStatement pstm;
     String driver,url;     
      ResultSet rs;     
      String qry="select * from employee";
     Select()
     {
     driver="com.mysql.jdbc.Driver";
     url="jdbc:mysql://localhost:3307/employee";
     try
     {
     cnt=DriverManager.getConnection(url,"root","");
     pstm=cnt.prepareStatement(qry);
     rs=pstm.executeQuery();
         while(rs.next())
         {
             int id=rs.getInt(1);
             String name=rs.getString(2);
             int sal=rs.getInt(3);
             String job=rs.getString(4);
            
             System.out.println(" | "+id+" | "+name+" | "+sal+" | "+job);
         }
     System.out.println("Sucessfull Records Done");
     rs.close();
     cnt.close();
    
     }
         catch (SQLException ex) 
         {
             System.out.println("Error : "+ex.getMessage());
         }
     }
 }
