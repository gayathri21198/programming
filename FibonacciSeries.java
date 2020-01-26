class FibonacciSeries{
	public static void main(String[] args) {
		int i;
		int a=0;
		int b=1;
		int c=0;
		while(c<=89)
		{
			c=a+b;
			a=b;
			b=c;
            System.out.printf("The fibonacci series is as follows %d",c);
		}
	}
}