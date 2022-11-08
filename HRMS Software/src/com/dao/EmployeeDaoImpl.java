package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.EmployeeException;
import com.model.Employee;
import com.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao
{

	@Override
	public Employee viewProfile(int empid) throws EmployeeException
	{
		Employee employee = null;

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1.prepareStatement("select * from employee where empid = ?");
			ps1.setInt(1, empid);
			ResultSet rs1 = ps1.executeQuery();

			while (rs1.next())
			{
				int eid = rs1.getInt(1);
				String ename = rs1.getString(2);
				String address = rs1.getString(3);
				int mobile = rs1.getInt(4);
				String password = rs1.getString(5);
				String dname = rs1.getString(6);

				employee = new Employee(eid, ename, address, mobile, password, dname);
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}

		return employee;
	}

	@Override
	public String updateProfile(int empid) throws EmployeeException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
