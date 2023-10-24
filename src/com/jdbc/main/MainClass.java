package com.jdbc.main;

import java.util.Scanner;

import com.jdbc.model.Employeee;
import com.jdbc.service.DataBaseService;

public class MainClass {

    public static void main(String[] args)
    {
    	DataBaseService dbs=new DataBaseService ();
        try (Scanner sc = new Scanner(System.in))
        {
        	boolean isRunning=true;
            while (isRunning)
            {
            	System.out.println("Enter choice");
                System.out.println("1.insert");
                System.out.println("2.select all");
                System.out.println("3.select employee by an id");
                System.out.println("4.delete employee");
                System.out.println("5.update employee");
                System.out.println("6.Exist");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                    	System.out.println("enter Name,Address,Salry");
                    	dbs.insertEmployee(new Employeee(sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine())));
                    	break;
                        

                    case 2:
                        dbs.getAllEmployee();
                        break;

                    case 3:
                    	 System.out.println("enter id of an employee");
                         dbs.getEmployeeById(Integer.parseInt(sc.nextLine()));
                         break;
                    case 4:
                    	 System.out.println("enter id of an employee");
                    	 dbs.deleteEmployeeById(Integer.parseInt(sc.nextLine()));
                          break;
                    case 5:
                    	System.out.println("enter id of an employee");
                    	int updateId=Integer.parseInt(sc.nextLine());
                    	boolean isFound=dbs.getEmployeeById(updateId);
                    	if(isFound)
                    	{
                    		System.out.println("enterName,enterAddress,enterSalary");
                    		Employeee employee=new Employeee(updateId,sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine()));
                    		dbs.updateEmployee(employee);
                    	}
                    	
                        break;
                    case 6:
                    	System.out.println("thank you,visit again");
                    	isRunning=false;
                    	break;

                    default:
                        System.out.println("Incorrect choice");
                        break;
                }	
            	
            	
            }
        }
        catch(Exception e)
        {
        	throw new RuntimeException ("error comes"+e);
        	
        }
       
    }
}
