package PlayCode.三十三道题.三十三17删除abc;package ��ʮ��17ɾ��abc;

import java.util.ArrayList;

public class Test {
	/**
	 * һ��ArrayList����aList�д������ɸ��ַ���Ԫ�أ�
	 *  ����������ArrayList����ɾ����������ֵΪ"abc"���ַ���Ԫ�أ�
	 *  ���ô���ʵ�֡�
	 *  
	 *  ˼·:
	 *  	1.����һ��ArrayList,���洢����Stirng����Ԫ��.
	 *  	2.list����,Ҳ���нǱ��,��ô�������?�����Ԫ�غ�"abc"
	 *  ��ͬʱ,��ɾ��.
	 */

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("ganni");
		list.add("abc");
		list.add("zhongguo");
		list.add("shanghai");
		list.add("����");
		list.add("123");
		list.add("abc");
		for (int i = 0; i < list.size(); i++) {
			if("abc".equals(list.get(i))){
				list.remove(i);
			}			
		}
		System.out.println(list);
	}
}
