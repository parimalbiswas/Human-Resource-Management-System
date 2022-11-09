package com.usecase_emp;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;
import com.welcomScreen.WelcomeScreen;

public class updatePassword_usecase_EMP
{
	public static void updatePassword_usecaseX(Employee employee)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Update Password Portal : " + employee.getEname());

		System.out.println("Enter new Password U want to Change (Your Old password is) -> " + employee.getPassword());
		String newPassword = scanner.next();

		EmployeeDao dao = new EmployeeDaoImpl();
		try
		{
			String result = dao.updatePassword(employee.getEid(), newPassword);
			System.out.println(result);
			System.out.println("====================================");
			System.out.println("1. Press 1 if u Want to  Go back");
			System.out.println("2. Press 2 if u Want to  Go to HOME PAGE");
			System.out.println("-----------------------------------");
			int chois = scanner.nextInt();

			if (chois == 1)
			{
				UserVerificationDone.verifieduserAcivity(employee);
			}
			else if (chois == 2)
			{
				WelcomeScreen.control();
			}
			else
			{
				System.out.println("Worng Choise ><><><><><>");
				System.out.println("--------------------------");
				UserVerificationDone.verifieduserAcivity(employee);

			}
		}
		catch (EmployeeException e)
		{
			e.printStackTrace();
		}

	}
}
