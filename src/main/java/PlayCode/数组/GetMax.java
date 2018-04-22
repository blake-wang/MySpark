package PlayCode.数组;

/*
��ȡ��������ֵ
*/
class GetMax{
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public static int getMax1(int[] arr)
	{
		int max = arr[0];//�����һ��Ԫ�������ֵ
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
				max = arr[i];//�õ����ֵԪ��
		}
		return max;//�������ֵԪ��
	}
	public static int getMax2(int[] arr)
	{
		int max = 0;//�������ֵԪ�صĽǱ���0
		for(int i=1;x<arr.length;i++)
		{
			if(arr[i]>arr[max])
				max = i;//�õ����ֵԪ�صĽǱ�
		}
		return arr[max];//�������ֵԪ��
	}
}
