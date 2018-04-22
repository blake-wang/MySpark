package PlayCode.三十三道题.三十三14反射获得方法;package ��ʮ��14�����÷���;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws Exception {
		//��һ�ַ�ʽ��ͨ���ֽ����ļ�
		//Class clazz = Print.class;
		//�ڶ��ַ�ʽ��ͨ��Class����forName���������ļ���ַ
		Class clazz = Class.forName("��ʮ��14�����÷���.Print");
		Print p = (Print) clazz.newInstance();
		Constructor c = clazz.getConstructor();
		Method m = clazz.getMethod("print");
		m.invoke(p);
		// ��һ����������Ҫ����ķ��������ƣ��ڶ��������� �㷴��ķ����� Ҫ����Ĳ�������
		Method m2 = clazz.getMethod("print", int.class);
		// ��һ�������Ƕ������ƣ��ڶ��������ǲ���ֵ
		m2.invoke(p, 10);
		Method m3 = clazz.getDeclaredMethod("print",String.class);
		m3.setAccessible(true);
		m3.invoke(p, "�ο�");

	}

}
