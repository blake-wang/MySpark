package PlayCode.三十三道题.三十三18配置文件和反射;package ��ʮ��18�����ļ��ͷ���;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;

public class Test {

	/**
	 * (1) дһ��Properties��ʽ�������ļ�����������������ơ� (2)
	 * дһ�����򣬶�ȡ���Properties�����ļ����������������Ʋ����������,�÷��� �ķ�ʽ����run������ ˼·:
	 * 1.���ڴ��ڵ������ļ�,����Ҫͨ��FileInputStream�������.
	 * 2.����properties����,���������ͨ��load()����,�������� ��ȡ��������.
	 * 3.ͨ�����ϵ�getProperty()�������ļ��ж�Ӧ�����ݶ�ȡ����,�ַ�������
	 * 4.���ַ���(key��valueֵ)����������Ҫ��ȡ������ȫ��.��Class��forName()�Ϳ��Ի�ȡ���ֽ���. 5.Ȼ����Ƿ������.
	 * �ܽ�: 1.��ȡ�����ļ�,��ײ���Ҫͨ��IO��. 2.Properties����ͨ��load�����Ϲ���������д��properties��.
	 * 3.ͨ��getProperty(��)����Ӧ��ֵ��ȡ. ˼��: ��ȡ�����ļ�,����һ��ר�Ŷ�ȡ�����ļ��ļ���.����Ϊʲô?˵�������ļ�
	 * �Ķ�ȡ��javaʵ�ʿ�������������������
	 * .�������кܷ���Ļ�ȡkey��ֵ�ķ���.���ԶԼ��Ͻ��б���(StringPropertyNames()����һ��set����
	 * ),��һ���map��������������.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws Exception
	 * @throws IllegalArgumentException
	 * */

	public static void main(String[] args) throws  Exception {
		Properties p = new Properties();
		p.load(new FileInputStream("demo.properties"));
		Enumeration<String> names = (Enumeration<String>) p.propertyNames();
		String value = null;
		while (names.hasMoreElements()) {
			String key = (String) names.nextElement();
			value = p.getProperty(key);
			// System.out.println(key+"..."+value);
		}
		System.out.println(value);
		Class clazz = Class.forName(value);
		// Object obj = clazz.newInstance();
		Demo d = (Demo) clazz.newInstance();
		Method m = clazz.getMethod("run");
		m.invoke(d);

	}

}
