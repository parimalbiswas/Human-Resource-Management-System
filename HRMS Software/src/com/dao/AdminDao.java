package com.dao;

import java.util.List;

import com.exception.DepartmentException;
import com.exception.EmployeeException;
import com.exception.LeaveDetailException;
import com.model.Department;
import com.model.Employee;

public interface AdminDao
{

	public String registerNewEmployee(Employee employee) throws EmployeeException;

	public String transfarDepartmentEmp(int eid, String newdeptName) throws EmployeeException;

	public String leaveApproval(int eid, String remarksApprove) throws LeaveDetailException;

	////////////////////////////////////////////////////////////////////////////////////////

	public String addNewDepartMent(Department department) throws DepartmentException;

	public List<Department> viewAllDepartMent() throws DepartmentException;

	public String updateDepartment(String oldDeptName, String newDeptName) throws DepartmentException;

}
