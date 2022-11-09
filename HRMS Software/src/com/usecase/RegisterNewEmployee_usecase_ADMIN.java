package com.usecase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;

public class RegisterNewEmployee_usecase_ADMIN
{

	public static void RegisterNewEmployee_usecaseX()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("-----------------Register New Emp--------------------");

		System.out.println("Enter employee id");
		int eid = scanner.nextInt();

		System.out.println("Enter employee name");
		String ename = scanner.next();

		System.out.println("Enter Address");
		String address = scanner.next();

		System.out.println("Enter mobile");
		String mobile = scanner.next();

		System.out.println("Enter password");
		String password = scanner.next();

		System.out.println("Enter Department");
		String dname = scanner.next();

		Employee employee = new Employee(eid, ename, address, mobile, password, dname);

		AdminDao dao = new AdminDaoImpl();
		try
		{
			String result = dao.registerNewEmployee(employee);
			System.out.println(result);
		}
		catch (EmployeeException e)
		{

			e.printStackTrace();
		}

	}
}
