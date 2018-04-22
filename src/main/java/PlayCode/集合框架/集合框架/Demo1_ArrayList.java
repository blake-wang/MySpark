package PlayCode.集合框架.集合框架;package ���Ͽ��;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo1_ArrayList {

	/**
	 * ����ArrayListȥ���������ַ������ظ�ֵ���ַ�����������ͬ��
	 * ˼·�������¼��Ϸ�ʽ
	 */
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		ArrayList newList = getSingle(list);
		System.out.println(newList);

	}
	/*
	 * �����¼��Ͻ��ظ�Ԫ��ȥ��
	 * 1����ȷ����ֵ���ͣ�����ArrayList
	 * 2����ȷ�����б�ArrayList
	 * 
	 * ������
	 * 1�������¼���
	 * 2�����ݴ���ļ��ϣ��ϼ��ϣ���ȡ������
	 * 3�������ϼ���
	 * 4��ͨ���¼����ж��Ƿ�����ϼ����е�Ԫ�أ���������Ͳ���ӣ���������������
	 */
	public static ArrayList getSingle(ArrayList list){
		ArrayList newList = new ArrayList();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			if(!newList.contains(obj)){
				newList.add(obj);
			}
		}
		return newList;
	}

}
