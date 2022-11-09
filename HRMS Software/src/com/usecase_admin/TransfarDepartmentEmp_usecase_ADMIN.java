package com.usecase_admin;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;

public class TransfarDepartmentEmp_usecase_ADMIN
{

	public static void TransfarDepartmentEmp_usecaseX()
	{
		Employee employee = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter emp id to change Department to another Department");
		int eid = scanner.nextInt();

		EmployeeDao dao1 = new EmployeeDaoImpl();
		try
		{
			employee = dao1.viewProfile(eid);
		}
		catch (EmployeeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("current department is -->" + employee.getDname());

		System.out.println("Enter new Department where your want to transfer emplyee ->  " + employee.getEname());
		String NEWdname = scanner.next();

		AdminDao dao2 = new AdminDaoImpl();
		try
		{
			String result = dao2.transfarDepartmentEmp(eid, NEWdname);
			System.out.println(result);
		}
		catch (EmployeeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
