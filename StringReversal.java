import java.util.Scanner;

class StringReversal{

//  static String reversestring(String s)
//   {
//   	int n;

// 	int i;

// 	n=s.length();
// 	 	int j=n-1;
// 	 	char temp;

// 	for(i=0;i<j;i++)
// 	 	{
// 	 			temp = s.charAt(i);
// 	 			s.charAt(i)=s.charAt(j);

// 			s.charAt(j)=temp;

// 		    j--;

// 	}
// 	 	System.out.println(s);

// }
// 	public static void main(String[] args) {
// 		String str=new String();
// 		System.out.println("Enter the string to be checked");
// 		Scanner sc=new Scanner(System.in);
// 		str=sc.nextLine();
// 		System.out.println("the entered string is"+str);
// 		String str1=str.reversestring();
		
	//}

	public static void main(String[] args) {
		StringBuilder input=new StringBuilder();
		System.out.println("Enter the string to be reversed");
		Scanner sc=new Scanner(System.in);
		String str=new String();
 		str=sc.nextLine();
 		input.append(str);
 		System.out.println("the entered string is : "+input);
 		StringBuilder input1=input.reverse();
 		System.out.println(input1);


	}
}