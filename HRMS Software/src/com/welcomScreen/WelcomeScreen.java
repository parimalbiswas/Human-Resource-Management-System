package com.welcomScreen;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
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
				Boolean yesno = dao.validateUser(ename, password);
				if (yesno == true)
				{
					UserVerificationDone.verifieduserAcivity();
				}
				else
				{
					System.out.println("Invaild credentials !!!! Worng Username or Password !!!!!");
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
