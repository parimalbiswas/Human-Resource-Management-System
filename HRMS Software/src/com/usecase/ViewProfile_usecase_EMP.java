package com.usecase;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;
import com.welcomScreen.WelcomeScreen;

public class ViewProfile_usecase_EMP
{
	public static void viewProfile_usecaseX(Employee employee)
	{
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.println("Enter emp ID Again to view Your Profile");
//		int eid = scanner.nextInt();

		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		EmployeeDao dao = new EmployeeDaoImpl();
		try
		{
			Employee EMPreturnOBJ = dao.viewProfile(employee.getEid());
			System.out.println("Your Details Details are following ----------------->");
			System.out.println("Employee id is ->> " + EMPreturnOBJ.getEid());
			System.out.println("Employee name is ->> " + EMPreturnOBJ.getEname());
			System.out.println("Employee address ->> " + EMPreturnOBJ.getAddress());
			System.out.println("Employee Mobile ->> " + EMPreturnOBJ.getMobile());
			System.out.println("Employee Password ->> " + "XXXXXXXXX");
			System.out.println("Employee Depatment Name ->> " + EMPreturnOBJ.getDname());
			System.out.println("-----------------------------------------------------------");

			Scanner scanner = new Scanner(System.in);
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
				System.out.println("Worng Choise");
			}

		}
		catch (EmployeeException e)
		{

			e.printStackTrace();
		}

	}
}
