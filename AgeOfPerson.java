import java.util.*;
class AgeOfPerson{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the age of the person");
		int age=s.nextInt();
		try
		{
			if(age<=15)
			{
				throw new AgeException("Invalid age");
			}
			else
			{
				System.out.println("Valid age");
			}
		}
		catch(AgeException ref)
		{
			System.out.println(ref);
		}
	}
}

class AgeException extends Exception{
	public AgeException(String str)
	{
		System.out.println(str);
	}

}