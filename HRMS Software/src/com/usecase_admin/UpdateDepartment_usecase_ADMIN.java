package com.usecase_admin;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.DepartmentException;
import com.welcomScreen.WelcomeScreen;

public class UpdateDepartment_usecase_ADMIN
{

	public static void updateDepartment_usecaseX()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------Department Adding Portal-------------");

		System.out.println("Enter OLD departmnt Name ");
		String OLDdid = scanner.next();

		System.out.println("Enter Updated departmnt Name ->  ");
		String NEWdname = scanner.next();

		AdminDao dao = new AdminDaoImpl();
		try
		{
			String result = dao.updateDepartment(OLDdid, NEWdname);
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
		catch (DepartmentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
