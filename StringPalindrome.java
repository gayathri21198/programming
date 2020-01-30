import java.util.Scanner;
class StringPalindrome{
	static boolean ispalindrome(String s)
		{
			int n=s.length();
			int i=0;
			int j=n-1;
			while(i<j)
			{
				if(s.charAt(i)!=s.charAt(j))
				{
					return false;
				}
				i++;
				j--;
			}
			return true;

		}

	public static void main(String[] args) {
		String str=new String();
		System.out.println("Enter the string to be checked");
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		System.out.println("the entered string is"+str);
		if(ispalindrome(str))
		{
			System.out.println("the string is a palindrome");
		}
		else
		{
			System.out.println("the string is not a palindrome");
		}
		

		
	}
}



