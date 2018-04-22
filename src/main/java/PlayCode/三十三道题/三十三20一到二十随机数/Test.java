package PlayCode.三十三道题.三十三20一到二十随机数;package ��ʮ��20һ����ʮ�����;

import java.util.HashSet;
import java.util.Random;

public class Test {
	/**
	 * ��дһ�����򣬻�ȡ10��1��20���������Ҫ������������ظ��� 
	 * 
	 * 	˼·:
	 * 		1.��ȡ�����,����Random;
	 * 		2.����������ظ�,����set����.
	 * 		3.����Ϊ10,��set���ϳ���<=10;
	 * 	�ܽ�:
	 * 		�����ظ�,ҪװԪ��,����set����.
	 * 	˼��:
	 * 		����Ԫ�صĲ���,���ظ��Ͳ����ظ������������õıȽ϶�,Ҫ���������Ҫ�õ�ʲô����.��Ϊ������Ҫ�������,���Ծ������ǲ�Ҫ�����.���ʹ��HashSet;
	 * 
	 * */
	public static void main(String[] args) {
		Random r = new Random();
		HashSet hs = new HashSet();
		while(hs.size()<10){
			Integer i = (r.nextInt(20)+1);
			hs.add(i);
		}
		System.out.println(hs);
	}
}
