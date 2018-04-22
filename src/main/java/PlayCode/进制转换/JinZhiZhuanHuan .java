package PlayCode.进制转换;

class JinZhiZhuanHuan
{
	public static void main(String[] args) 
	{
		toBin(10);
	}

	/*
	ʮ����-->������
	*/
	public static void toBin(int num)
	{
		trans(num,1,1);
	}
	/*
	ʮ����-->�˽���
	*/
	public static void toBa(int num)
	{
		trans(num,7,3);
	}
	/*
	ʮ����-->ʮ������
	*/
	public static void toHex(int num)
	{
		trans(num,15,4);
	}
	/*
	����ת���ĺ���

        0 1 2 3 4 5 6 7 8 9  A  B  C  D  E  F    ʮ�������е�Ԫ��
	0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

	����������е�Ԫ����ʱ�洢������������Ӧ��ϵ
	ÿһ��&15���ֵ��Ϊ����ȥ�齨���õı��Ϳ����Ҷ�Ӧ��Ԫ��
	������ -10+'a' �򵥵Ķࡣ

	�������ô�����أ�
	����ͨ�����ݵ���ʽ�����塣
	*/
	public static void trans(int num,int base,int offset)
	{
		if(num==0)
		{
			System.out.println(0);
			return;
		}
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};//�ѽ������õ����ַ�����װ��һ��������
		char[] arr = new char[32];
		int pos = arr.length;
		while(num!=0)
		{
			int temp = num & base;
			arr[--pos] = chs[temp];
			num = num >>> offset;
		}
		for(int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);
		}
	}
}
