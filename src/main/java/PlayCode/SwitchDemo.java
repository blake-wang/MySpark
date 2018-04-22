package PlayCode;

class SwitchDemo
{
	public static void main(String[] args) 
	{
		int x = 16;
		switch(x)
		{
			case 3:
			case 4:
			case 5:
				System.out.println(x+"����");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println(x+"�ļ�");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println(x+"�＾");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println(x+"����");
				break;
			default:
				System.out.println("nono");
		}

		/*
		if��switch������
		����ʲô�����£�Ӧ���ĸ�����أ�
		����жϵľ�����ֵ���࣬���Ƿ���byte,short,int,char����������
		��Ȼ������䶼����ʹ�ã�����ʹ��switch��䣬��ΪЧ���Ը�
		����������������жϣ��Խ��Ϊboolean�����жϣ�ʹ��if��if�����÷�Χ���㡣
		*/
		System.out.println("Hello World!");
	}
}
