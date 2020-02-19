package com.ibm.servlettrainingbasic;

public class UserDetails {
	
	private String name , password;
	private int userid;
	
	public void setUserName()
	{
		this.name = name;
	}
	
	public void setPassword()
	{
		this.password = password;
	}
	
	public void setUserId()
	{
		this.userid = userid;
	}
	
	public int getUserId(int userid)
	{
		return userid;
	}
	
	public String getUserName(String name)
	{
		return name;
	}

	public String getPassword(String password)
	{
		return password;
	}
	
	@Override
	public String toString()
	{
		return "User Details [ Name : " + name + " Password : " + password + " ID : " + userid + " ] ";
	}
	
	

}
