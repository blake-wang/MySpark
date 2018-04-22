package PlayCode.集合框架.集合的选择和冒泡排序

��ҵ;

import java.util.ArrayList;
import java.util.List;

public class Test04 {
	/*
	 * ���ϵ�ѡ�������ð������
	 */

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("b");
		list1.add("f");
		list1.add("e");
		list1.add("c");
		list1.add("a");
		list1.add("d");
		
		sort1(list1);
		System.out.println(list1); // a, b, c, d, e, f

		List<Integer> list2 = new ArrayList<>();
		list2.add(5);
		list2.add(8);
		list2.add(3);
		list2.add(1);
		list2.add(4);

		sort2(list2);
		System.out.println(list2); // 1,3,4,5,8
	}
	private static void sort2(List<Integer> list2) {
		//ѡ������
		for (int i = 0; i < list2.size()-1; i++) {
			for (int j = i+1; j < list2.size(); j++) {
				if (list2.get(i)>list2.get(j)) {
					Integer temp = list2.get(i);
					list2.set(i, list2.get(j));
					list2.set(j,temp);
				}
			}
		}
	}
	private static void sort1(List<String> list1) {
		// ð������
		for (int i = 0; i < list1.size() - 1; i++) {
			for (int j = 0; j < list1.size() - 1 - i; j++) {
				if (list1.get(j).compareTo(list1.get(j+1))>0) {
					String temp = list1.get(j);
					list1.set(j, list1.get(j+1));
					list1.set(j+1,temp);
				}
			}
		}
	}
}
