package com.usecase;

import java.util.Scanner;

import com.welcomScreen.WelcomeScreen;

public class EMPviewProfile
{

	public static void EMPviewProfileX()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("If You want to view your Profile Enter CORRECT EID");
		System.out.println("Press 0 to go to Home Screen");
		System.out.println("================================");

		int response = scanner.nextInt();

		if (response == 0)
		{

			WelcomeScreen.control();
		}
		else
		{
			System.out.println("ID Entered");

		}

	}

}
