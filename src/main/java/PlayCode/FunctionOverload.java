package PlayCode;

class FunctionOverload
{
	public static void main(String[] args) 
	{
		print99();
		print99(5);
		add(3,4,5);
		System.out.println(add(3,4,5));
	}
	public static void print99()
	{
		print99(9);
	}
	public static void print99(int num)
	{
		for(int x=1;x<=num;x++)
		{
			for(int y=1;y<=x;y++)
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
			System.out.println();
		}
	}
	public static int add(int a,int b)
	{
		return a+b;
	}
	public static int add(int a,int b,int c)
	{
		return add(a,b)+c;
	}
}
