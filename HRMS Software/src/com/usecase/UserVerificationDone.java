package com.usecase;

import java.util.Scanner;

import com.model.Employee;
import com.welcomScreen.WelcomeScreen;

public class UserVerificationDone
{
	public static void verifieduserAcivity(Employee employee)
	{
//		System.out.println(employee);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Verified >>>>  WELCOME TO EMPLOYEE MANAGEMENT PANEL : " + employee.getEname());

		System.out.println("1. Press 1 to view Profile ");
		System.out.println("2. Press 2 to update Profile ");
		System.out.println("3. Press 3 to update Passworde ");
		System.out.println("4. Press 4 to request Leave ");
		System.out.println("5. Press 5 to exit ");
		System.out.println("------------------------------------");
		int choise = scanner.nextInt();

		switch (choise) {
		case 1:
			System.out.println("You Pressed 1....");
			ViewProfile_usecase_EMP.viewProfile_usecaseX(employee);
			break;

		case 2:
			System.out.println("You Pressed 2....");
			UpdateProfile_usecase_EMP.updateProfile_usecaseX(employee);
			break;
		case 3:
			System.out.println("You Pressed 3....");
			updatePassword_usecase_EMP.updatePassword_usecaseX(employee);
			break;
		case 4:
			System.out.println("Worng 4....");
			break;
		case 5:
			WelcomeScreen.control();
			break;
		default:
			System.out.println("Worng choise....");
			verifieduserAcivity(employee);
			break;
		}

	}
}
