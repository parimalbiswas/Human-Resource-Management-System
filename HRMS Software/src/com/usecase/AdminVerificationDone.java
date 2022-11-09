package com.usecase;

import java.util.Scanner;

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

	}
}
