package PlayCode.三十三道题.三十三08字符串反转;package ��ʮ��08�ַ�����ת;

import javax.sound.sampled.ReverbType;

public class Test08 {
	/*8�� ���ַ����н��з�ת��abcde --> edcba
	 * */
	public static void main(String[] args) {
         //demo1();
         String str = "abcde";
         String s = reverse(str);
         System.out.println(reverse(str));
         
	}

	private static void demo1() {
		StringBuffer sb = new StringBuffer();
         sb.append("abcde");
         sb.reverse();
         System.out.println(sb);
	}
	/*
	 * ���������ַ������з�ת
	 * 1,����ֵ���� String
	 * 2�������б� String
	 */
	public static String reverse(String string){
		char[] c = string.toCharArray();
		for (int i = 0; i < c.length/2; i++) {
			char temp = c[i];
			c[i] = c[c.length-1-i];
			c[c.length-1-i] = temp;
		}
		String s = c.toString();
		//return rs;
		return s;
	}

}
