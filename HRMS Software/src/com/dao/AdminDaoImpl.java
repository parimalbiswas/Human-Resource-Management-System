package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.DepartmentException;
import com.exception.EmployeeException;
import com.exception.LeaveDetailException;
import com.model.Department;
import com.model.Employee;
import com.util.DBUtil;

public class AdminDaoImpl implements AdminDao
{

	@Override
	public String registerNewEmployee(Employee employee) throws EmployeeException
	{
		String message = "Not Registered";

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			ps1.setInt(1, employee.getEid());
			ps1.setString(2, employee.getEname());
			ps1.setString(3, employee.getAddress());
			ps1.setString(4, employee.getMobile());
			ps1.setString(5, employee.getEname());
			ps1.setString(6, employee.getDname());
			int x = ps1.executeUpdate();

			if (x > 0)
			{
				message = "Inserted Successfully.........." + "username is->" + employee.getEname()
						+ "  &&  passward is->" + employee.getPassword(); // +employee.getPassword();
			}
			else
			{
				throw new EmployeeException("Insertion Failed !!!!!!!!!!");
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
	public String transfarDepartmentEmp(int eid, String newdeptName) throws EmployeeException
	{
		String message = "Not Transfared";

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1.prepareStatement("update employee set dname = ? where eid = ?");

			ps1.setString(1, newdeptName);
			ps1.setInt(2, eid);

			int x = ps1.executeUpdate();

			if (x > 0)
			{
				message = "Transfar Successful.........."; // +employee.getPassword();
			}
			else
			{
				throw new EmployeeException("Transfar Failed !!!!!!!!!!");
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
	public String leaveApproval(int eid, String remarksApprove) throws LeaveDetailException
	{
		String message = "Not Approved";

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1.prepareStatement("update leaveDetail set adminapprove = ? where eid = ?");

			ps1.setString(1, remarksApprove);
			ps1.setInt(2, eid);

			int x = ps1.executeUpdate();

			if (x > 0)
			{
				message = "Leave Approved Successful.........."; // +employee.getPassword();
			}
			else
			{
				throw new LeaveDetailException("Approved Failed !!!!!!!!!!");
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new LeaveDetailException(e.getMessage());
		}

		return message;
	}

	@Override
	public String addNewDepartMent(Department department) throws DepartmentException
	{
		String message = "Not Added";

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1.prepareStatement("insert into department values(?,?)");
			ps1.setInt(1, department.getDid());
			ps1.setString(2, department.getDname());

			int x = ps1.executeUpdate();

			if (x > 0)
			{
				message = "New Department Added Successfully.........."; // +employee.getPassword();
			}
			else
			{
				throw new DepartmentException("Add Failed !!!!!!!!!!");
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}

		return message;
	}

	@Override
	public List<Department> viewAllDepartMent() throws DepartmentException
	{
		List<Department> list = new ArrayList<>();

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1.prepareStatement("select * from Department");
			ResultSet rs1 = ps1.executeQuery();

			while (rs1.next())
			{
				int did = rs1.getInt(1);
				String dname = rs1.getString(2);

				Department department = new Department(did, dname);
				list.add(department);
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}

		return list;
	}

	@Override
	public String updateDepartment(String oldDeptName, String newDeptName) throws DepartmentException
	{
		String message = "Not Updated";

		try (Connection conn1 = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn1.prepareStatement("update Department set dname= ? where dname= ?");
			ps1.setString(1, newDeptName);
			ps1.setString(2, oldDeptName);

			int x = ps1.executeUpdate();

			if (x > 0)
			{
				message = "New Department Updated Successfully.........."; // +employee.getPassword();
			}
			else
			{
				throw new DepartmentException("Update Failed !!!!!!!!!!");
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}

		return message;
	}

}
