package com.welcomScreen;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;
import com.usecase.AdminVerificationDone;
import com.usecase.UserVerificationDone;

public class WelcomeScreen
{

	public static void control()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("**********************");
		System.out.println("WELCOME TO HRMS Panel");
		System.out.println("**********************");

		System.out.println("Press 1 for ADMIN LOGIN");
		System.out.println("Press 2 for EMPLOYEE LOGIN");
		System.out.println("=========================");

		System.out.println("Enter Your Choise");
		int choise = scanner.nextInt();

		if (choise == 1)
		{
			System.out.println("Enter Employee Name");
			String username = scanner.next();

			System.out.println("Enter Password");
			String password = scanner.next();

			if (username.equalsIgnoreCase("ADMIN") && password.equalsIgnoreCase("ADMIN"))
			{
				AdminVerificationDone.verifiedAdminAcivity();
			}
			else
			{
				System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
				System.out.println(" ><><><>< Invaild credentials !!!! Worng Username or Password !!! ><><><><");
				System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
				control();
			}

		}
		else if (choise == 2)
		{
			System.out.println("Enter Employee Name");
			String ename = scanner.next();

			System.out.println("Enter Password");
			String password = scanner.next();

			EmployeeDao dao = new EmployeeDaoImpl();
			try
			{
				Employee employee = dao.validateUser(ename, password);
				if (employee != null) // employee.getEid() != 0 ||
				{
					UserVerificationDone.verifieduserAcivity(employee);
				}
				else
				{
					System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
					System.out.println(" ><><><>< Invaild credentials !!!! Worng Username or Password !!! ><><><><");
					System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
					control();
				}
			}
			catch (EmployeeException e)
			{

				System.out.println(e.getMessage());
			}

		}
		else
		{
			System.out.println("Worng Choise");
			System.out.println("Want to Enter again ?  preess 1 if you to enter again");
			int x = scanner.nextInt();
			if (x == 1)
			{
				control();
			}
			else
			{
				System.out.println("TATA. Thank you for using our servise. COME AGAIN");
			}

		}
	}

	public static void main(String[] args)
	{
		WelcomeScreen.control();
	}

}
