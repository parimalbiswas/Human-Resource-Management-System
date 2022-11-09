package com.usecase_admin;

import java.util.Scanner;

import com.welcomScreen.WelcomeScreen;

public class AdminVerificationDone
{

	public static void verifiedAdminAcivity()
	{
		System.out.println("Verified via method");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Verified >>>>  WELCOME TO ADMIN MANAGEMENT PANEL : " + "ADMIN");

		System.out.println("1. Press 1 to add New Department ");
		System.out.println("2. Press 2 to view All Department ");
		System.out.println("3. Press 3 to Update Department ");
		System.out.println("4. Press 4 to Add New Employee ");
		System.out.println("5. Press 5 to Transfer Department ");
		System.out.println("6. Press 6 to Leave Approve ");
		System.out.println("7. Press 7 to exit ");
		System.out.println("------------------------------------");
		int choise = scanner.nextInt();

		switch (choise) {
		case 1:
			System.out.println("You Pressed 1....");
			AddNewDepartMent_usecase_ADMIN.addNewDepartMent_usecaseX();
			break;

		case 2:
			System.out.println("You Pressed 2....");
			// UpdateProfile_usecase_EMP.updateProfile_usecaseX(employee);
			break;

		case 3:
			System.out.println("You Pressed 3....");
			// updatePassword_usecase_EMP.updatePassword_usecaseX(employee);
			break;

		case 4:
			System.out.println("You Pressed 4....");
			RegisterNewEmployee_usecase_ADMIN.RegisterNewEmployee_usecaseX();
			break;

		case 5:
			System.out.println("You Pressed 5....");
			TransfarDepartmentEmp_usecase_ADMIN.TransfarDepartmentEmp_usecaseX();
			break;

		case 6:
			System.out.println("You Pressed 6....");
			LeaveApproval_usecase_ADMIN.leaveApproval_usecaseX();
			break;

		case 7:
			WelcomeScreen.control();
			break;

		default:
			System.out.println("Worng choise....");
			verifiedAdminAcivity();
			break;
		}

	}
}
