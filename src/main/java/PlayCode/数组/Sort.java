package PlayCode.数组;

/*
ѡ�������ð������
*/
class Sort {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	/*
	ѡ������
	*/
	public static void selectSort(int[] arr)
	{
		for(int x=0;x<arr.length-1;x++)//��ѭ�����ƱȽϼ���
		{
			for(int y=x+1;y<arr.length;y++)//��ѭ������ÿ�ֱȽϼ���
			{
				if(arr[x]>arr[y])
				{
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;   //��С��������
				}
			}
		}
	}
	/*
	ð������
	*/
	public static void bubbleSort(int[] arr)
	{
		for(int x=0;x<arr.length-1;x++)//��ѭ�����ƱȽϼ���
		{
			for(int y=0;y<arr.length-1-x;y++)//��ѭ������ÿ�ֱȽϼ���
			{
				if(arr[y]>arr[y+1])
				{
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;	//��С��������
				}
			}
		}
	}
}
