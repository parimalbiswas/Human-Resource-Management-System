package com.usecase_emp;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;
import com.welcomScreen.WelcomeScreen;

public class UpdateProfile_usecase_EMP
{

	public static void updateProfile_usecaseX(Employee employee)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Welcome to Update Area : " + employee.getEname());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("Enter Your Updated Name (Your Current Name is) ->  " + employee.getEname());
		String newName = scanner.next();

		System.out.println("Enter Your Updated Address (Your Current Address is) ->  " + employee.getAddress());
		String newaddress = scanner.next();

		System.out.println("Enter Your Updated Mobile (Your Current Mobile is) ->  " + employee.getMobile());
		String newmobile = scanner.next();

		Employee newemployeeUpdate = new Employee(employee.getEid(), newName, newaddress, newmobile,
				employee.getPassword(), employee.getDname());

		EmployeeDao dao = new EmployeeDaoImpl();
		try
		{
			String result = dao.updateProfile(newemployeeUpdate);
			System.out.println(result);
			System.out.println("------------");
			System.out.println("Press 1 to View Your Profile");
			System.out.println("Press 2 to goto Employee Detals Page");

			int x = scanner.nextInt();

			if (x == 1)
			{
				ViewProfile_usecase_EMP.viewProfile_usecaseX(newemployeeUpdate);
			}
			else if (x == 2)
			{
				UserVerificationDone.verifieduserAcivity(newemployeeUpdate);
			}
			else
			{
				System.out.println("TATA. Worng Choise. Returning to Home Page");
				WelcomeScreen.control();
			}

		}
		catch (EmployeeException e)
		{

			e.printStackTrace();
		}

//		System.out.println("================================");

	}

}
