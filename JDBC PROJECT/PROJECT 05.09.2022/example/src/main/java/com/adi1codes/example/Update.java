package com.adi1codes.example;

import java.sql.*;
 public class Update
 {
     Connection cnt;
     PreparedStatement pstm;
     String driver,url;
     String qry="update employee set ename=?,esal=?,ejob=? where eid=?";
     Update(String ename,int esal,String ejob,int eid)
     {
     driver="com.mysql.jdbc.Driver";
     url="jdbc:mysql://localhost:3307/employee";
     try
     {
     cnt=DriverManager.getConnection(url,"root","");
     pstm=cnt.prepareStatement(qry);
    
     pstm.setString(1,ename);
     pstm.setInt(2,esal);
     pstm.setString(3,ejob);
     pstm.setInt(4,eid);
  
     pstm.executeUpdate();
     System.out.println("Updation Sucessfull Done");
     cnt.close();
     }
         catch (SQLException ex) {
             System.out.println("Error : "+ex.getMessage());
         }
     }

 }
