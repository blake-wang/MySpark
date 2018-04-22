package PlayCode.集合框架.集合框架;package ���Ͽ��;

import java.util.ArrayList;
import java.util.Iterator;

public class Example06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("Jack");
		list.add("Rose");
		list.add("nima");
		list.add("heigui");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if ("Jack".equals(obj)) {
				list.remove(obj);
				break;
			}
		}
		System.out.println(list);
	}
}
