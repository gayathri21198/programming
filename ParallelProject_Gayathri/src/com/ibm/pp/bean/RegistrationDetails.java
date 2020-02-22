package com.ibm.pp.bean;

public class RegistrationDetails {
	
	private int userid;
	private String name;
	private String email;
	private String password;
	
	public void setUserId(int userid)
	{
		this.userid = userid;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public int getUserId()
	{
		return userid;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}

@Override
public String toString()
{
	return " Registration details [ ID : " + userid + " Name : " + name + " Email ID : " + email + " Password : " + password + " ] "; 
}


}
