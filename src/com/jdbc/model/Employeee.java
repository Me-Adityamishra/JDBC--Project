package com.jdbc.model;

public class Employeee {
	
	private int employeeId;
	private String  employeeName;
	private String employeeAddress;
	private double employeeSalry;
	public Employeee(String employeeName, String employeeAddress, double employeeSalry)
	{
		super();
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeSalry = employeeSalry;
	}

	public Employeee(int employeeId, String employeeName, String employeeAddress, double employeeSalry) 
	{
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeSalry = employeeSalry;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public double getEmployeeSalry() {
		return employeeSalry;
	}
	public void setEmployeeSalary(double employeeSalry) {
		this.employeeSalry = employeeSalry;
	}
	
	
	
	
	
	
	

}
