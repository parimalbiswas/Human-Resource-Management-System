package com.model;

public class Employee
{
	int eid;
	String ename;
	String address;
	int mobile;
	String password;
	String dname;

	public Employee(int eid, String ename, String address, int mobile, String password, String dname)
	{
		super();
		this.eid = eid;
		this.ename = ename;
		this.address = address;
		this.mobile = mobile;
		this.password = password;
		this.dname = dname;
	}

	public Employee()
	{
		super();
	}

	public int getEid()
	{
		return eid;
	}

	public void setEid(int eid)
	{
		this.eid = eid;
	}

	public String getEname()
	{
		return ename;
	}

	public void setEname(String ename)
	{
		this.ename = ename;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public int getMobile()
	{
		return mobile;
	}

	public void setMobile(int mobile)
	{
		this.mobile = mobile;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getDname()
	{
		return dname;
	}

	public void setDname(String dname)
	{
		this.dname = dname;
	}

	@Override
	public String toString()
	{
		return "Employee [eid=" + eid + ", ename=" + ename + ", address=" + address + ", mobile=" + mobile
				+ ", password=" + password + ", dname=" + dname + "]";
	}

}
