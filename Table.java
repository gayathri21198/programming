class Table{
	public static void main(String[] args) {
		int n;
		n=Integer.parseInt(args[0]);
		int i;
		int ans;
		for(i=1;i<=n;i++)
		{
			ans=n*i;
			System.out.printf("%d*%d=%d",n,i,ans);
		}
	}
}