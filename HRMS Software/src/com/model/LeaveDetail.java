package com.model;

public class LeaveDetail
{

	int eid;
	String dateofleave;
	String adminapprove;

	public LeaveDetail(int eid, String dateofleave, String adminapprove)
	{
		super();
		this.eid = eid;
		this.dateofleave = dateofleave;
		this.adminapprove = adminapprove;
	}

	public LeaveDetail()
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

	public String getDateofleave()
	{
		return dateofleave;
	}

	public void setDateofleave(String dateofleave)
	{
		this.dateofleave = dateofleave;
	}

	public String getAdminapprove()
	{
		return adminapprove;
	}

	public void setAdminapprove(String adminapprove)
	{
		this.adminapprove = adminapprove;
	}

	@Override
	public String toString()
	{
		return "LeaveDetail [eid=" + eid + ", dateofleave=" + dateofleave + ", adminapprove=" + adminapprove + "]";
	}

}
