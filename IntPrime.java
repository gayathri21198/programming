import java.util.*;
class IntPrime{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the integer upto which the prime number must be printed");
		int n=s.nextInt();
		int i;
		for(i=1;i<=n;i++)
		{
			int flag=0;
			for(int j=1;j<=i;j++)
			{
				if(i%j==0)
				{
					flag++;
				}

			}
			if(flag==2)
			{
				System.out.println(i);
			}
            
		}
		
	}
}