package com.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.model.Employeee;
import com.jdbc.util.DatabaseUtil;
import com.jdbc.util.QueryUtil;

public class DataBaseService 
{
	DatabaseUtil databaseUtil=new DatabaseUtil();
	
	public void insertEmployee(Employeee employee) throws SQLException
	{
		try(Connection connection=databaseUtil.getConnection();
			PreparedStatement preparedstatemnt=connection.prepareStatement(QueryUtil.InsertEmployeeQuery());)
		{
			
			  preparedstatemnt.setString(1,employee.getEmployeeName());
			  preparedstatemnt.setString(2,employee.getEmployeeAddress());
			  preparedstatemnt.setDouble(3,employee.getEmployeeSalry());
			  
			  int row=preparedstatemnt.executeUpdate();
			  
			  if(row>0)
			  {
				  System.out.println("Record created successfully");
				 
			  }
			  else
			  {
				  
				  System.out.println("Inser resut fail");
			  }  
		}
	}
	public void getAllEmployee() throws SQLException
	{
		try(Connection connection=databaseUtil.getConnection();
			Statement statement=connection.createStatement();
			ResultSet reasultset=statement.executeQuery(QueryUtil.selectAllEmployeeQuery());
				)
		{
			while(reasultset.next())
			{
				printEmployee(new Employeee(reasultset.getInt("employee_id"),
						      reasultset.getString("employee_Name"),
						      reasultset.getString("employee_address"),
						      reasultset.getDouble("employee_salry") 
						      )) ;                              
						         
			}
		}
	}
	private void printEmployee(Employeee employee )
	{
		System.out.println("Employee Id="+employee.getEmployeeId());
		System.out.println("Employee Name="+employee.getEmployeeName());
		System.out.println("Employee Address="+employee.getEmployeeAddress());
		System.out.println("Employee salary="+employee.getEmployeeSalry());
		System.out.println("--------------------------------------------------");
	}
	public boolean getEmployeeById(int id) throws SQLException
	{
		boolean isFound=false;
		try(Connection connection=databaseUtil.getConnection();
				
			Statement statement=connection.createStatement();
				ResultSet reasultset=statement.executeQuery(QueryUtil.selectEmployeeById(id));
				)
		{
			if(reasultset.next())
			{
				isFound=true;
				printEmployee(new Employeee(reasultset.getInt("employee_id"),
					      reasultset.getString("employee_Name"),
					      reasultset.getString("employee_address"),
					      reasultset.getDouble("employee_salry") 
					      )) ;                    
				
			}
			else
			{
				System.out.println("Record not found for id"+id );
			}
			
		}
		
		return isFound;
	}
	
	public void deleteEmployeeById(int employee_id) throws SQLException
	{
		try(Connection connection =databaseUtil.getConnection();
			Statement statement=connection.createStatement();
				)
		{
			
			int rows=statement.executeUpdate(QueryUtil.deleteEmployeeById(employee_id));
			
			if(rows>0)
			{
				
				System.out.println("Record deleted successfully");
			}
			else
			{
				System.out.println("something went wrong");
			}
			
		}
	}
	public void updateEmployee(Employeee employee)throws SQLException
	{
		try(Connection connection=databaseUtil.getConnection();
		PreparedStatement preparedstatemnt=connection.prepareStatement(QueryUtil.updateEmployeeQuery(employee.getEmployeeId()))
				
				)
		{
			

			  preparedstatemnt.setString(1,employee.getEmployeeName());
			  preparedstatemnt.setString(2,employee.getEmployeeAddress());
			  preparedstatemnt.setDouble(3,employee.getEmployeeSalry());
			  
			  int row=preparedstatemnt.executeUpdate();
			  if(row>0)
			  {
				  System.out.println("Record created successfully");
				 
			  }
			  else
			  {
				  
				  System.out.println("Inser resut fail");
			  }  
			
		}
		
		
	}
	
		
}
