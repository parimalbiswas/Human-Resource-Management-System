package com.usecase_admin;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;
import com.welcomScreen.WelcomeScreen;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
