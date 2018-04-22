package PlayCode.数组;

class LeiJia {
	public static void main(String[] args) {
		int[] arr = new int[99];
		int sum = 0;
		for(int i=1;i<=99;i++)
		{
			arr[i] = i;
			if(arr[i]%2==1)
				sum = sum + arr[i];
		}
		System.out.println(sum);
	}
}
