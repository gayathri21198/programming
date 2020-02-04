import java.util.*;
class FibonacciSequence{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the limit upto which the sequence must be printed");
		int n=s.nextInt();
		int a=1,b=1;
		// System.out.println(a);
		// System.out.println(b);
		int i;
		for(i=1;i<=n;i++)
		{
			System.out.println(a);
			int sum=a+b;
			a=b;
			b=sum;
		}
		
	}
}