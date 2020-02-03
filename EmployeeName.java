import java.util.*;
class EmployeeName{
	public static void main(String[] args) {
	  Scanner s=new Scanner(System.in);
	  System.out.println("Enter the first name");
	  String firstname= s.nextLine();
	  System.out.println("Enter the last name");
	  String lastname=s.nextLine();
	  try{
	  	if(firstname==null&&lastname==null)
	  	{
	  		throw new NameException("Invalid name");
	  	}
	  	else
	  	{
	  		throw new NameException("Valid name");
	  	}
	  }
	  catch(NameException ref)
	  {
	  	System.out.println(ref);
	  }	
	}
}

class NameException extends Exception{
public NameException(String str)
{
	System.out.println(str);
}
}