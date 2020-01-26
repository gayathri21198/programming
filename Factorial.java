class Factorial{
	public static void main(String[] args) {
		int n,i;
		n=Integer.parseInt(args[0]);
		long factorial=1;
		for(i=1;i<=n;i++)
		{
			factorial=factorial*i;
		}

		System.out.printf("Factorial of %d = %d", n, factorial);

	}
}