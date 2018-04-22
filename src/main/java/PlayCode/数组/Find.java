package PlayCode.数组;

/*
���������е�Ԫ��
*/
class Find{
	public static void find(int[] arr,int x)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==x)
			{
				System.out.println("��Ҫ���ҵ��� "+x+" ��������ĵ�"+(i+1)+"��Ԫ�ء�");
				break;
			}
			else if( arr[i]!=x && i==arr.length-1)
			{
				System.out.println("��Ҫ���ҵ��� "+x+" �������в����ڡ�");
				break;
			}	
		}	
	}
}