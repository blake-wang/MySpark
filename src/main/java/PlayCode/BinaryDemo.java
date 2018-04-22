package PlayCode;

class BinaryDemo {
	public static void main(String[] args) {
		toHex(60);
		System.out.println("Hello World!");
	}

	public static void toHex(int num)
	{
		char chs[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char val[]=new char[32];
		int p=val.length;

		while(num!=0)
		{
			int temp=num&15;
			val[--p]=chs[temp];
			num>>>=4;
		}
		for(int i=p;i<val.length;i++)
		{
		
			System.out.print(val[i]);
		
		}
		System.out.println();
	}
}


