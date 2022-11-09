package com.usecase_admin;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
import com.exception.LeaveDetailException;
import com.model.Employee;

public class LeaveApproval_usecase_ADMIN
{

	public static void leaveApproval_usecaseX()
	{
		Employee employee = null;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter emp id to Approve the Leave");
		int eid = scanner.nextInt();

		EmployeeDao dao1 = new EmployeeDaoImpl();
		try
		{
			employee = dao1.viewProfile(eid);
		}
		catch (EmployeeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Employee name is -->" + employee.getEname());

		System.out.println("Enter Approve to Approve Leave ->  ");
		String approve = scanner.next();

		AdminDao dao2 = new AdminDaoImpl();

		try
		{
			String result = dao2.leaveApproval(eid, approve);
			System.out.println(result);
		}
		catch (LeaveDetailException e)
		{
			e.printStackTrace();
		}
	}
}
