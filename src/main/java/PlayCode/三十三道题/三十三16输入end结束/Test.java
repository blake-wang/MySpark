package PlayCode.三十三道题.三十三16输入end结束;package ��ʮ��16����end����;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test {
	/**
	 * ��Ŀ����д����ѭ�������û��Ӽ����������ַ����� ֱ�����롰end��ʱѭ������������������������ַ������ֵ�˳�����ӡ��
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int num = s2.compareTo(s1);
				// ������-1�������� 1
				return num == 0 ? -1 : num;
			}
		});
		while (true) {
			String str = sc.nextLine();
			if ("end".equals(str)) {
				break;
			}
			ts.add(str);
		}
		for (Object object : ts) {
			System.out.print(object + "  ");
		}
	}
}
