package PlayCode.集合框架.集合框架;package ���Ͽ��;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo2_ArrayList {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Person("����", 23));
		list.add(new Person("����", 23));
		list.add(new Person("�Ա�", 25));
		list.add(new Person("��Ԫ��", 29));
		list.add(new Person("��Ԫ��", 29));
		list.add(new Person("��Ԫ��", 29));
		list.add(new Person("��Ԫ��", 29));

		ArrayList newList = getSingle(list);
		System.out.println(newList);
	}

	public static ArrayList getSingle(ArrayList list) {
		ArrayList newList = new ArrayList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			//���ö���ıȽϣ�Ҫ��bean������дequals����
			if (!newList.contains(obj)) {
				newList.add(obj);
			}
		}
		return newList;
	}

}
