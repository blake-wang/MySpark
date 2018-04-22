package PlayCode.集合框架.集合框架;package ���Ͽ��;

import java.util.LinkedList;

public class Demo3_LinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst("a");
		list.addFirst("b");
		list.addFirst("c");
		list.addFirst("d");
		//���list�ͱ���list�������ǲ�һ����
		//������������ϵ������������ÿһ��Ԫ�ص����
		System.out.println(list.getFirst());
		System.out.println(list);
		System.out.println(list.getLast());
		/*for (Object object : list) {
			System.out.println(object);
		}*/
		

	}

}
