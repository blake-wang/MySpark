package PlayCode.三十三道题.三十三01字符个数;package ��ʮ��01�ַ�����;

import java.util.Set;
import java.util.TreeMap;

public class Test01 {
	/**
	 * 1�� ȡ��һ���ַ�������ĸ���ֵĴ������磺�ַ�����"abcdekka27qoq" �� �����ʽΪ��a(2)b(1)k(2)...
	 * 
	 * ˼·: 1.��Ҫ֪��ÿ���ַ����ֵĴ���,��Ҫ��ÿ���ַ����б���. 2.��ζԱ����������ַ��Ͷ�Ӧ���ֵĴ������д洢��?����Ҫmap����.
	 * 3.����һ���������,��ΰ�ÿ���ַ����ֵ��������Ĵ���װ��map����? ����Ҫͨ��һ���ж�,�������ַ�������,�ͽ�key�Լ�����value����.
	 * (����Ѿ�����,˵������ַ��������Ѿ���������valueֵ��)
	 * 4.�����map���ϰ�Ԫ�ض�����֮��,��ͨ��EntrySet()�������ϵ�Ա�������.Ȼ���ٷֱ��ȡkey��value.����ӡ.
	 */

	public static void main(String[] args) {
		
		String str = "abcdekka27qoq";
		//���ַ���ת�����ַ�����
		char[] c = str.toCharArray();
		//����TreeMap���ϣ����ڴ洢�ַ����ַ�������ֵ��
		TreeMap tm = new TreeMap();
		//�����ַ�����
		for (int i = 0; i < c.length; i++) {
			//��������������ַ�������������ѭ���������´�ѭ��
			if (c[i] > '0' && c[i] < '9') {
				continue;
			}
			//�ж�,���map����c[i]�����͸�c[i]��Ӧ��ֵ��1
			if (tm.containsKey(c[i])) {
				tm.put(c[i], (Integer) tm.get(c[i]) + 1);
			} else {
				//���map������c[i]�����͸�c[i]��Ӧ��ֵ��Ϊ1
				tm.put(c[i], 1);
			}
		}
		//��map�����е����м�ȡ�������set������
		Set keySet = tm.keySet();
		//����set���ϣ�����Ҫ���ӡ�����ֵ��
		for (Object object : keySet) {
			System.out.print(object + "(" + tm.get(object) + ")");
		}
	}
}
