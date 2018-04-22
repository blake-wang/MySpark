package PlayCode;

class GetArrayIndex
{
	public static void main(String[] args) 
	{
		int[] arr ={3,2,1,54,2,9};
		int index = getIndex(arr,9);
		System.out.println("index="+index);
	}

	public static int getIndex(int[] arr,int key)
	{
		for(int x=0;x<arr.length;x++)
		{
			if(arr[x]==key)
				return x;
		}
		return -1;
	}
}
