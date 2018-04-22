package PlayCode;

//break��continue������
class BreakAndContinue 
{
	public static void main(String[] args) 
	{
		//break��
		//w��q�Ǳ�ţ�ֻ������ѭ���ϡ�
		w:for(int x=0;x<3;x++)
		{
			q:for(int y=0;y<4;y++)
			{
				System.out.println("x="+x);
				break w;
			}
		}

		System.out.println("----------------------");
		//continue:ֻ��������ѭ���ṹ������ѭ�����ص㣺��������ѭ����������һ��ѭ��
		for(int x=1;x<=10;x++)
		{
			if(x%2==1)
				continue;
			System.out.println("x="+x);
		}
		System.out.println("--------------------------");
		w:for(int x=0;x<3;x++)
		{
			for(int y=0;y<4;y++)
			{
				System.out.println("x="+x);
				continue w;
			}
		
		}

		/*
		��ס��
		1��break��continue������õķ�Χ
		2��break��continue��������ʱ������������κ���䣬��Ϊ��ִ�в�����
		*/
		
	}
}
