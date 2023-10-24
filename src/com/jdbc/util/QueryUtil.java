package com.jdbc.util;

public class QueryUtil {
	
	public static String InsertEmployeeQuery()
	
	{
		  return "Insert into emploee_info (employee_name,employee_address,employee_salry) values(?,?,?)";
		
	}
    public static String selectAllEmployeeQuery()
    {
    	
    	return "select * from emploee_info";
    	
    }
    public static String selectEmployeeById(int employee_id)
    {
    	
    	return "select * from emploee_info where employee_id = "+employee_id;
    }
    public static String deleteEmployeeById(int employee_id)
    {
    	
    	return "delete from emploee_info where employee_id = "+employee_id;
    	
    }
    public static String updateEmployeeQuery(int employee_id)
    {
    	
    	return "update emploee_info set employee_name = ? ,employee_address = ? ,employee_salry = ? where employee_id = "+employee_id;
    }
}
