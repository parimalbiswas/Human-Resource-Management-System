package com.usecase_admin;

import java.util.List;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.DepartmentException;
import com.model.Department;
import com.welcomScreen.WelcomeScreen;

public class ViewAllDepartMent_usecase_ADMIN
{

	public static void viewAllDepartMent_usecaseX()
	{
		Scanner scanner = new Scanner(System.in);
		List<Department> listDept;

		System.out.println("---------------------------Displaying all department are--------------------------------");
		AdminDao dao = new AdminDaoImpl();
		try
		{
			listDept = dao.viewAllDepartMent();

			listDept.forEach(s -> System.out.println(s.getDname()));

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
