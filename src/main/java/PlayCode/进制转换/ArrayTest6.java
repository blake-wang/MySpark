package PlayCode.进制转换;

class ArrayTest6
{
	public static void main(String[] args) 
	{
		toHex(60);
	}

	/*
	0 1 2 3 4 5 6 7 8 9  A  B  C  D  E  F    ʮ�������е�Ԫ��
	0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

	����������е�Ԫ����ʱ�洢������������Ӧ��ϵ
	ÿһ��&15���ֵ��Ϊ����ȥ�齨���õı��Ϳ����Ҷ�Ӧ��Ԫ��
	������ -10+'a' �򵥵Ķࡣ

	�������ô�����أ�
	����ͨ�����ݵ���ʽ�����塣
	*/

	public static void toHex(int num)
	{
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		StringBuffer sb = new StringBuffer();
		for(int x=0;x<8;x++)
		{
			int temp = num & 15;
			//System.out.println(chs[temp]);
			sb.append(chs[temp]);
			num=num>>>4;
		}
		System.out.println(sb.reverse());
	}
}
