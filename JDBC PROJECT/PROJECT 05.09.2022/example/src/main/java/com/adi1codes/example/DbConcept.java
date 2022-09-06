package com.adi1codes.example;

import java.io.*;

public class DbConcept 
{

public static void main(String args[]) throws IOException 
{
InputStreamReader in = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(in);
    int option, eid, esal;
    String ename, ejob;
    System.out.println("1. Select Records");
    System.out.println("2. Insert Records");
    System.out.println("3. Delete Records");
    System.out.println("4. Update Records");
    System.out.println("Enter Above Mention OPtion : ");
    option = Integer.parseInt(br.readLine());
    switch (option) {             
        case 1:
            System.out.println("EMPLOYEE RECORDS SELECTION");
        Select obj = new Select();
            break;
        case 2:
            System.out.println("EMPLOYEE RECORDS INSERTION");
            System.out.println("Enter Employee id : ");
            eid = Integer.parseInt(br.readLine());
            System.out.println("Enter Employee Name : ");
            ename = br.readLine();
            System.out.println("Enter Employee Salary : ");
            esal = Integer.parseInt(br.readLine());
            System.out.println("Enter Employee Job : ");
            ejob = br.readLine();
            Insert inobj = new Insert(eid, ename, esal, ejob);
            break;
        case 3:
            System.out.println("EMPLOYEE RECORDS DELETION");
        System.out.println("Enter Employee id : ");
            eid = Integer.parseInt(br.readLine());
            Delete demo = new Delete(eid);
            break;
        case 4:
            System.out.println("EMPLOYEE RECORDS UPDATION");
            System.out.println("Enter Employee Name upadte : ");
            ename = br.readLine();
            System.out.println("Enter Employee Salary upadte: ");
            esal = Integer.parseInt(br.readLine());
            System.out.println("Enter Employee Job upadte: ");
            ejob = br.readLine();
            System.out.println("Enter confm Employee id that u hav to change : ");
            eid = Integer.parseInt(br.readLine());
            Update up = new Update(ename, esal, ejob, eid);
            break;
            default:
            System.out.println("Invalid Option");


           }
       }
   }
    