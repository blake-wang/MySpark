package PlayCode;

class FunctionTest
{
	public static void main(String[] args) 
	{

		draw(5,10);
	}
	/*
	����һ�����ܣ����ڴ�ӡ����
	˼·��
	1��ȷ�������û�У���Ϊֱ�Ӵ�ӡ�����Է���ֵ������void
	2����δ֪�������У���������Ϊ���ε��к��в�ȷ��
	*/
	public static void draw(int row,int col)
	{
		for(int x=0;x<row;x++)
		{
			for(int y=0;y<col;y++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
