package PlayCode.三十三道题.三十三11main中定义Map;package ��ʮ��11main�ж���Map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Test {

	/**
	 * 11.�}Ŀ:��дһ���࣬��main�����ж���һ��Map���󣨲��÷��ͣ��� �������ɸ�����Ȼ���������ӡ����Ԫ�ص�key��value��
	 * 
	 * ˼·: ��ʵҲû��ʲô����˼·,������Ǻܼ򵥵�map�ı�������Ӧ��.
	 * 
	 * �ܽ�: map����������뻹���Ǿ仰,�뵽set�׽���. һ����ͨ��EntrySet()����ϵ�Դ���set����.
	 * һ����ͨ��KeySet()��keyֵ����set����. ˼��: map���ϵ����ֱ�����ʽҪ���μ�ס.һ���������key��value�Ĺ�ϵ.һ��
	 * �������ʵʵ���ڵ�key;
	 * */
	public static void main(String[] args) {
		Map<Person, String> map = new TreeMap<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				int num = p2.getAge()-p1.getAge();

				return num == 0 ? 1 : num;
			}
		});
		map.put(new Person("���»�", 23), "���");
		map.put(new Person("�ž޻�", 46), "����");
		map.put(new Person("����", 79), "�ձ�");
		map.put(new Person("�ž޻�", 101), "����");
		demo1(map);
		demo2(map);

	}

	/*
	 *�����TreeMap�д�����ͬ���ļ����������ַ�ʽȥ����ֵ 
	 */
	private static void demo2(Map<Person, String> map) {
		//ȡ�����Ǽ�ֵ�ԵĹ�ϵ�ļ���
		Set<Entry<Person, String>> entrySet = map.entrySet();
		Iterator it = entrySet.iterator();
		while(it.hasNext()){
			//it.next() �����Ὣ���������Զ�����ΪObject
			Entry<Person,String> entry = (Entry<Person, String>) it.next();
			Person p =entry.getKey();
			String s =entry.getValue();
			System.out.println(p+"..."+s);
			
		}
	}

	private static void demo1(Map<Person, String> map) {
		//ȡ�����Ǽ��ļ���
		Set<Person> set = map.keySet();
		Iterator<Person> it = set.iterator();
		while (it.hasNext()) {
			Person p = it.next();
			// �����ַ�������Set���ϣ�map.get(p)Ҳ�����comparator��������ô�����������ֵ��Ϊnull�����ǱȽ�ֵ���ص���0
			System.out.println(p + "..." + map.get(p));
		}
	}
}
