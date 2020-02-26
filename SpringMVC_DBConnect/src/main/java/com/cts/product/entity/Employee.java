package com.cts.product.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity

public class Employee {
	
	@Id
	private int empId;
	private String empName;
	private double salary;
	private Date dob;
	
	public Date getDob() {
		System.out.println("------ getter DOB >>>");
		return dob;
	}
	public void setDob(Date dob) {
	System.out.println("------ setter DOB   >>>");
	this.dob=dob;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
