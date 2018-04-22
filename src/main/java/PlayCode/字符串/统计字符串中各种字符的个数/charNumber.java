package PlayCode.字符串.统计字符串中各种字符的个数�Ƹ����ַ��ĸ���;

/*
 * �ַ���abcedfABCDEFG!@#$%^&*12345678
 * �ֱ�ͳ�������ַ����У���д��ĸ��Сд��ĸ�����ֺͷ��ŵĸ���
 */

public class charNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcedfABCDEFG!@#$%^&*12345678";
		int big = 0;
		int num = 0;
		int small = 0;
		int other = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				big++;
			} else if (c >= '0' && c <= '9') {
				num++;
			} else if (c >= 'a' && c <= 'z') {
				small++;
			} else {
				other++;
			}

		}
		System.out.println("��д��ĸ"+big+"����"+"Сд��ĸ"+small+"����"+"����"+num+"����"+"����"+other+"����");

	}

}
