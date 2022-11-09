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
			PreparedStatement ps1 = conn1.prepareStatement("select * from employee where eid = ?");
			ps1.setInt(1, empid);
			ResultSet rs1 = ps1.executeQuery();

			while (rs1.next())
			{
				int eid = rs1.getInt(1);
				String ename = rs1.getString(2);
				String address = rs1.getString(3);
				String mobile = rs1.getString(4);
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
	public String updateProfile(Employee employee) throws EmployeeException
	{
		String message = "Not Updated";

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1
					.prepareStatement("update employee set ename=?,address=?,mobile=? where eid=?");
			ps1.setString(1, employee.getEname());
			ps1.setString(2, employee.getAddress());
			ps1.setString(3, employee.getMobile());
			ps1.setInt(4, employee.getEid());
			int x = ps1.executeUpdate();

			if (x > 0)
			{
				message = "Updated Successfully.......";
			}
			else
			{
				throw new EmployeeException("Updated Failed !!!!!!!!!!!!");
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());

		}

		return message;
	}

	@Override
	public String updatePassword(int empid, String password) throws EmployeeException
	{
		String message = "Not Updated";

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1.prepareStatement("update employee set password=? where eid=?");
			ps1.setString(1, password);
			ps1.setInt(2, empid);
			int x = ps1.executeUpdate();

			if (x > 0)
			{
				message = "Password Updated Succesfully........";
			}
			else
			{
				throw new EmployeeException("Updated Failed !!!!!!!!!!!!");
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}

		return message;
	}

	@Override
	public String requestLeave(int empid, String dateofleave) throws EmployeeException
	{
		String message = "Not applied";

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1.prepareStatement("insert into leaveDetail values(?,?,?)");
			ps1.setInt(1, empid);
			ps1.setString(2, dateofleave);
			ps1.setString(3, "Not Approved");
			int x = ps1.executeUpdate();

			if (x > 0)
			{
				message = "Leave Application Requested.........";
			}
			else
			{
				throw new EmployeeException("Application failed !!!!!!!!!");
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}

		return message;
	}

	@Override
	public Employee validateUser(String ename, String password) throws EmployeeException
	{
		Employee employee = null;

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1.prepareStatement("select * from employee where ename = ? AND password = ?");
			ps1.setString(1, ename);
			ps1.setString(2, password);
			ResultSet rSet1 = ps1.executeQuery();

			while (rSet1.next())
			{
				int eid1 = rSet1.getInt(1);
				String ename1 = rSet1.getString(2);
				String address1 = rSet1.getString(4);
				String mobile1 = rSet1.getString(3);
				String password1 = rSet1.getString(5);
				String dname1 = rSet1.getString(6);

				employee = new Employee(eid1, ename1, address1, mobile1, password1, dname1);

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}

		return employee;
	}

}
