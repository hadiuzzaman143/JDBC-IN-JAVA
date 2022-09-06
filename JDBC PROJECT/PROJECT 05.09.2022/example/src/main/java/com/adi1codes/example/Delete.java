package com.adi1codes.example;

import java.sql.*;
 public class Delete
 {
     Connection cnt;
     PreparedStatement pstm;
     String driver,url;
     String qry="delete from emp where eid=?";
     Delete(int eid)
     {
     driver="com.mysql.jdbc.Driver";
     url="jdbc:mysql://localhost:3307/employee";
     try
     {
     cnt=DriverManager.getConnection(url,"root","");
     pstm=cnt.prepareStatement(qry);
     pstm.setInt(1,eid);
     pstm.execute();
     System.out.println("Deletion Done");
     pstm.close();
     cnt.close();
     }
         catch (SQLException ex) 
         {
            System.out.println("Error : "+ex.getMessage());
         }
     }

 }