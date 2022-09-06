package com.adi1codes.example;

import java.sql.*;
 public class Insert
 {
     Connection cnt;
     PreparedStatement pstm;
     String driver,url;
     String qry="insert into emp(eid,ename,esal,ejob) values(?,?,?,?)";
     Insert(int id,String name,int sal,String job)
     {
     driver="com.mysql.jdbc.Driver";
     url="jdbc:mysql://localhost:3307/employee";
     try
     {
     cnt=DriverManager.getConnection(url,"root","");
     pstm=cnt.prepareStatement(qry);
     pstm.setInt(1,id);
     pstm.setString(2,name);
     pstm.setInt(3,sal);
     pstm.setString(4,job);
     pstm.execute();
     System.out.println("Sucessfull");
     cnt.close();
     }
         catch (SQLException ex) {
             System.out.println("Error : "+ex.getMessage());
         }
     }
 }