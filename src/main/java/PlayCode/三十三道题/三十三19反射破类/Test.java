package PlayCode.三十三道题.三十三19反射破类;package ��ʮ��19��������;

public class Test {

	/*
	 * 6����дһ���࣬����һ��ʵ���������ڴ�ӡһ���ַ�����
	 * ��ʹ�÷����ֶδ�������Ķ��� �����øö����еķ�����
	 * */

	public static void main(String[] args) throws Exception, IllegalAccessException {
		Class clazz = Demo.class;
		Demo d = (Demo) clazz.newInstance();
		d.print();

	}

}
