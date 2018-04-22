package PlayCode.Demo.斗地主;package ������;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test01 {
	/*���Լ�д�Ķ�����
	 * 
	 * ������ 1��ϴ�� 2������ 3������
	 */

	public static void main(String[] args) {
		String[] s1 = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K",
				"A", "2" };
		String[] s2 = { "����", "����", "÷��", "��Ƭ" };
		ArrayList<String> list = new ArrayList<>();
		for (String str1 : s1) {
			for (String str2 : s2) {
				list.add(str2.concat(str1));
			}
		}
		//System.out.println(list);
		TreeMap<Integer, String> tm = new TreeMap<>();
		int index = 0;
		for (String string : list) {
			tm.put(index, string);
			index++;
		}
		tm.put(index, "С��");
		index++;
		tm.put(index, "����");
		//System.out.println(index);
		//System.out.println(tm);
		List<Integer> list2 = new ArrayList<>();
		for (Integer key : tm.keySet()) {
			list2.add(key);
		}
		//System.out.println(list2);
		Collections.shuffle(list2);
		//System.out.println(list2);
		TreeSet<Integer> zhichao = new TreeSet<>();
		TreeSet<Integer> zhangning = new TreeSet<>();
		TreeSet<Integer> wanglei = new TreeSet<>();
		TreeSet<Integer> dipai = new TreeSet<>();
		for (int i =0;i<list2.size();i++) {
			if (i>= list2.size()-3) {
				dipai.add(list2.get(i));
			} else if (list2.get(i) % 3 == 0) {
				zhichao.add(list2.get(i));
			} else if (list2.get(i) % 3 == 1) {
				zhangning.add(list2.get(i));
			} else {
				wanglei.add(list2.get(i));
			}
		}
		//System.out.println(zhichao);
		//System.out.println(zhangning);
		//System.out.println(wanglei);
		//System.out.println(dipai);
		ArrayList<String> zhichao2 = new ArrayList<>();
		ArrayList<String> zhangning2 = new ArrayList<>();
		ArrayList<String> wanglei2 = new ArrayList<>();
		ArrayList<String> dipai2 = new ArrayList<>();
		for (Integer i : zhichao) {
			zhichao2.add(tm.get(i));
		}
		for (Integer i : zhangning) {
			zhangning2.add(tm.get(i));
		}
		for (Integer i : wanglei) {
			wanglei2.add(tm.get(i));
		}
		for (Integer i : dipai) {
			dipai2.add(tm.get(i));
		}
		System.out.println("־����"+zhichao2);
		System.out.println("������"+zhangning2);
		System.out.println("���ڣ�"+wanglei2);
		System.out.println("���ƣ�"+dipai2);
	}
}
