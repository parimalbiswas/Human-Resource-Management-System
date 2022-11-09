package com.usecase_admin;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;
import com.usecase_emp.AdminVerificationDone;
import com.welcomScreen.WelcomeScreen;

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
			System.out.println("====================================");

			System.out.println("1. Press 1 if u Want to  Go back");
			System.out.println("2. Press 2 if u Want to  Go to HOME PAGE");
			System.out.println("-----------------------------------");
			int chois = scanner.nextInt();

			if (chois == 1)
			{
				AdminVerificationDone.verifiedAdminAcivity();
			}
			else if (chois == 2)
			{
				WelcomeScreen.control();
			}
			else
			{
				System.out.println("Worng Choise. Sorry. Redirecting to Admin Menu ><><><><><>");
				System.out.println("--------------------------");
				AdminVerificationDone.verifiedAdminAcivity();
			}
		}
		catch (EmployeeException e)
		{

			e.printStackTrace();
		}

	}
}
