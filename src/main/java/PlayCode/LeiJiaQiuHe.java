package PlayCode;

/**
1,��ȡ1-10�ĺͲ���ӡ��
*/

class ForTest2
{
	public static void main(String[] args) 
	{
		//1������������ڴ洢���ϱ仯�ĺ�
		int sum =0;
		//2���������X����¼ס���ϱ仯�ı��ӵ�����
		//3������ѭ�����ظ��ӷ��Ĺ��̡�
		for(int x=0;x<=10;x++)
		{
			sum=sum + x;
		}
		System.out.println("sum="+sum);

		int sum2 = 0;
		int y = 0;
		while(y<=10)
		{
			sum2+=y;
			y++;
		}
		System.out.println("sum2="+sum2);
	}
}
