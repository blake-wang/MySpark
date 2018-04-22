package PlayCode.三十三道题.三十三31金额转换;package ��ʮ��31���ת��;

import java.util.Scanner;

public class Test {
	/*
	 * 25�����ת��������������ת�����й���ͳ��ʽ�� ���磺101000001010 ת��Ϊ ҼǪ��Ҽʰ����ҼǪ��ҼʰԲ��
	 */
	private static final char[] data = { '��', 'Ҽ', '��', '��', '��', '��', '½',
			'��', '��', '��' };
	private static final char[] units = { 'Բ', 'ʰ', '��', 'Ǫ', '��', 'ʰ', '��',
			'Ǫ', '��', 'ʰ', '��', 'Ǫ' };

	public static void main(String[] args) {
		while (true) {
			Scanner scan = new Scanner(System.in);
			int lon = scan.nextInt();
			try {
				System.out.println(convert(lon));
			} catch (Exception e) {
				e.printStackTrace();
			}
			scan.close();
		}

	}

	private static String convert(int money) throws Exception {
		StringBuilder sb = new StringBuilder();
		int uint = 0;
		while (money != 0) {
			sb.insert(0, units[uint++]);
			sb.insert(0, data[(int) (money % 10)]);
			money = money / 10;
		}
		return sb.toString().replaceAll("��[Ǫ��ʰ]", "��").replaceAll("��+��", "��")
				.replaceAll("��+��", "��").replaceAll("����", "����")
				.replaceAll("��+", "��").replaceAll("��Բ", "Բ");
	}

}
