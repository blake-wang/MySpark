package PlayCode.集合框架.集合框架;package ���Ͽ��;

import java.util.ArrayList;

public class Foreachѭ�� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		for (Object object : list) {
			System.out.println(object);
		}

	}

}
