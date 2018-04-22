package PlayCode.三十三道题.三十三03泛型反射存储;package ��ʮ��03���ͷ���洢;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 3�� ArrayList<Integer> list = new ArrayList<Integer>();
 * ���������ΪInteger��ArrayList�д��һ��String���͵Ķ���
 * 
 * ˼·: 1.������ΪInteger��ArrayList�����һ��String���Ͷ���,Ϊʲô�� ��Ӳ���ȥ?
 * 2.����ΪArrayListֻ����Integer����,��ô,��������ֻ�ǽ���Integer ���Ϳ�������?
 * 3.�����������ֻ����Integer��?��Ȼ�ǽ���,��ʲô����?��Ȼ��ArrayList�е�add������.
 * 4.��Ȼ��һ������,��ͨ�����佫�����������͸ı�,����O����?
 * 5.�뷴��,����Ҫ�����ֽ������,���ȡ����,����Ҫһ��ArrayList����.����,�����Ѿ�����...
 * 
 * �ܽ�: 1.��ν�ķ���,Ҳ�����ڷ����϶��ڽ��ܵ����ͽ�����һ���޶�. 2.���䷽�����ֶ��Լ�����,�ֽ�����Ǳ����.���з���,����Ҳ�Ǳ�Ҫ��.
 * ֻ�ǹ��챾������new�����,����ȡ�ֶκͷ�����Ҫ���ֽ������,����,��Ҫ�ж������.
 * 3.���ڷ���,һ������ע����Ƿ���Ķ����������ε����η���ʲô?�����public���ε�
 * ,ֱ�ӿ���getMethod()������ʽ�Ϳ���,�����Ĭ�ϵ�,����Ҫͨ��getDeclaredMethod
 * ()�ſ���,Ҫ��private�Ļ�,�Բ���,����Ҫͨ������������
 * ,����Ҫͨ��getDeclaredMethod(),������me.setAccessible(true)����������Ȩ��.
 * 
 * ˼��: 1.���͵ĳ�����ֹ������ɫɫ��Ԫ�ػ���,����,���˷���,�ͺñ��ý������»ص����ǰ.
 * 2.�����ȷ���ó������±�ò���ȫ,���,�����ر����ε�private,������������������һ��,�Ͼ�private��Ȼ��private�ĵ���.
 * 
 * */

public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(999);
		
		Class clazz = ArrayList.class;
		//ע�⣬�����һ�������Ƿ������ƣ��ڶ��������� Object.class 
		Method m = clazz.getMethod("add", Object.class);
		m.invoke(list, "hello");
		System.out.println(list);
	}
}
