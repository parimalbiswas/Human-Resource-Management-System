package com.dao;

import com.exception.EmployeeException;
import com.model.Employee;

public interface EmployeeDao
{

	public Employee viewProfile(int empid) throws EmployeeException;

	public String updateProfile(Employee employee) throws EmployeeException;

	public String updatePassword(int empid, String password) throws EmployeeException;

	public String requestLeave(int empid, String dateofleave) throws EmployeeException;

	public Employee validateUser(String ename, String password) throws EmployeeException;

}
