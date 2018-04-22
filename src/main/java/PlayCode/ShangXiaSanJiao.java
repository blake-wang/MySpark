package PlayCode;

class ShangXiaSanJiao
{
	public static void main(String[] args) 
	{

		/*
		*****
		****
		***
		**
		*
		*/
		//int z =0;
		for(int x=0;x<5;x++)
		{
			for(int y=x;y<5;y++)
			{
				System.out.print("*");
			}
			System.out.println();//ֻ��һ�������ǻ��С�
			//z++;

		}
		
		/*
		*
		**
		***
		****
		*****
		*/
		for(int x =0 ;x<5;x++)
		{
			for(int y=0;y<=x;y++)
			{
				System.out.print("*");
			}
			System.out.println();
		}

		/*
		���ǹ��ɵĹ��ɣ�
		�⳯�ϣ����Ըı�������������������ѭ���仯��
		�⳯�£����Ըı��ʼ��ֵ���ó�ʼ��������ѭ���仯��
		*/


		/*
		1
		12
		123
		1234
		12345
		*/

		for(int x=1;x<=5;x++)
		{
			for(int y=1;y<=x;y++)
			{
				System.out.print(y);
			
			}
			System.out.println();
		}

		/*
		�žų˷���
		1*1=1
		1*2=2 2*2=4
		1*3=3 2*3=6 3*3=9
		*/
		for(int x=1;x<=9;x++)
		{
			for(int y=1;y<=x;y++)
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
			System.out.println();
		}

		/*
		����������
		
		*/
		for(int x=0;x<5;x++)
		{
			for(int y=x+1;y<5;y++)
			{
				System.out.print(" ");
			}
			for(int z=0;z<=x;z++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
}
