package PlayCode.三十三道题.三十三05打印文件内容;package ��ʮ��05��ӡ�ļ�����;

import java.io.FileInputStream;
import java.io.IOException;

public class Test {
	/**
	 * ����һ���ļ�������������read(byte[] b)������exercise.txt 
	 * �ļ��е��������ݴ�ӡ����(byte����Ĵ�С����Ϊ5)��
	 * 
	 */

	public static void main(String[] args) throws IOException {
		//����һ���ֽ�����������������ȡ�ļ�����
		FileInputStream fis = new FileInputStream("exercise.txt");
		//����һ������Ϊ5���ֽ����飬�����ֽڻ�������
		byte[] byt = new byte[5];
		//����һ���ַ�����������������Ŷ�ȡ���ļ�����
		StringBuffer sb = new StringBuffer();
		int len;
		while ((len = fis.read(byt)) != -1) {
			//���������ļ����ַ�������ʽ�����������Ҫע��len��ȡֵ
			String str = new String(byt, 0, len);
			sb.append(str);

		}
		fis.close();
		System.out.println(sb);
	}

}
