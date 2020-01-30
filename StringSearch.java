import java.util.Scanner;
 class StringSearch{
 	public static void main(String[] args) {
 		Scanner sc=new Scanner(System.in);
 		System.out.println("Enter the string");
 		String str=new String();
 		str=sc.nextLine();
 		System.out.println("Enter the character to be searched");
 		char c=sc.next().charAt(0);
 		int n=str.length();
 		int i;
 		for(i=0;i<n;i++)
 		{
            if(str.charAt(i)==c)
            {
            	System.out.println("the char is found");
            }
 		}

 	}
 }