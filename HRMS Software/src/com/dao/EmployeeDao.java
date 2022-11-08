package com.dao;

import com.exception.EmployeeException;
import com.model.Employee;

public interface EmployeeDao
{
	public Employee viewProfile(int empid) throws EmployeeException;

	public String updateProfile(int empid) throws EmployeeException;

}
