package PlayCode.三十三道题.三十三29List集合5个随机数;package ��ʮ��29List����5�������;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Test {

	/**
	 * ��д��������5��1��10֮����������������һ��List���ϣ�
	 * ��д������List���Ͻ��������Զ��������㷨������Collections.sort������TreeSet�� ˼·:
	 * 1.�����������,����list����,��Ŀ��5�� 2.ͨ���Զ����Ԫ�رȽϷ�,����ЩԪ�ؽ�������.
	 * 3.���������?��Ԫ����װ��һ��������,Ȼ���������ж����ֽ�������. ������������ֱ�����װ�뼯����.
	 */

	public static void main(String[] args) {
		int[] arr = new int[5];
		Random rd = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(10) + 1;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		Iterator<Integer> it = list.iterator();
		//hasNext()��������ֵΪtrue
		while(it.hasNext()){
			int i = it.next();
			System.out.println(i);
		}
		/*	for (Integer integer : list) {
			System.out.println(integer);
		}*/

	}
}
