package PlayCode;

class ArrayPrint
{
	public static void main(String[] args) 
	{
		int[] arr = {4,9,78,44,56,22,10};
		double[] arr2 = {3.14,5.22};
		/*
		for(int x=0;x<arr.length;x++)
		{
			System.out.println("arr["+x+"]="+arr[x]+";");
			System.out.println("length:"+arr.length);
		}
		System.out.println("Hello World!");
		*/
		printArray(arr);
		printArray(arr);
		System.out.println(arr2);
	}

	public static void printArray(int[] arr)
	{
		for(int x=0;x<arr.length;x++)
		{
			if(x!=arr.length-1)
				System.out.print(arr[x]+",");
			else
				System.out.println(arr[x]);
		}
	}
}
