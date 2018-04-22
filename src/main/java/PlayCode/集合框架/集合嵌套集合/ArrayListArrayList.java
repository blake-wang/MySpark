package PlayCode.集合框架.集合嵌套集合;package ����Ƕ�׼���;

import java.util.ArrayList;

public class ArrayListArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Student>> arrayList = new ArrayList<ArrayList<Student>>();
		ArrayList<Student> first = new ArrayList<Student>();
		ArrayList<Student> second = new ArrayList<Student>();
		arrayList.add(first);
		arrayList.add(second);
		first.add(new Student("�ܽ�·",39));
		first.add(new Student("�ź���",90));
		second.add(new Student("С����",55));
		second.add(new Student("��̫��",47));
		for (ArrayList<Student> a : arrayList) {
			for(Student s : a){
				System.out.println(s);
			}
			
		}

	}

}
