package PlayCode.进制转换;

class JinZhiZhuanHuan1
{
	public static void main(String[] args) 
	{
		toBin(6);
		toHex(60);
	}
	//ʮ����-->ʮ������
	public static void toHex(int num)
	{
		StringBuffer sb = new StringBuffer();
		for(int x=0;x<8;x++)
		{
			int temp = num & 15;
			if(temp>9)
				sb.append((char)(temp-10+'A'));//���ַ��������ת��
			else
				sb.append(temp);
			num = num >>> 4;
		}
		System.out.println(sb.reverse());
	}
	
	
	
	//ʮ����-->������
	public static void toBin(int num)
	{
		StringBuffer sb = new StringBuffer();
		while(num>0)
		{
			//ֻ��ÿ�δ�ӡ�������6%2,3%2,1%2;
			sb.append(num%2);
			num = num/2;
		}
		System.out.println(sb.reverse());
	}
}
