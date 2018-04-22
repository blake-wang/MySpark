package PlayCode.数组;

class Reverse {
	public static void main(String[] args) {
		reverse(arr);
		
	}
	public static void reverse(int[] arr)
	{
		for(int i=0;i<arr.length/2;i++)
		{
			int temp= arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
}