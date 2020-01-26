class ThreeInputs{
	public static void main(String[] args) {
		int a,b,c;
		a=Integer.parseInt(args[0]);
		b=Integer.parseInt(args[1]);
		c=Integer.parseInt(args[2]);
		if(a>=40 && b>=40 && c>=40 && (a+b+c)>=125)
		{
			System.out.printf("The sum is %d",a+b+c);
		}
	}
}