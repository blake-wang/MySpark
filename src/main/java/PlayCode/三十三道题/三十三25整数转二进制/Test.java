package PlayCode.三十三道题.三十三25整数转二进制;package ��ʮ��25����ת������;

import java.util.Scanner;

public class Test {
	/**
	 * �Ӽ��̽���һ������,�����ʮ���Ƶ�����ת���ɶ����Ʋ����
	 * ������̨,������"end"ʱ,����.
	 * 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ��������");
		while(true){
			try {
				String str = sc.nextLine();
				if("end".equals(str)){
					System.out.println("���������say you lala");
					break;
				}
				Integer i = Integer.parseInt(str);
				String binary = i.toBinaryString(i);
				System.out.println(binary);
			} catch (NumberFormatException e) {
				System.out.println("������Ĳ������������������룺");
			}
			
		}

	}

}
