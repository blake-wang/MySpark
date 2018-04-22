package PlayCode.日历;

import java.util.Calendar;
import java.util.Scanner;

/*
 * ������ʾ
 * ���󣺼���¼������һ����ݣ��жϸ��������껹��ƽ��
 * Calendar c = Calendar.getInstance();
 * 
 * ������
 * 1������¼����Scanner
 * 2������Calendar c = Calendar.getInstance();
 * 3��ͨ��get��������Ϊ��һ���3��1��
 * 4��������ǰ��ȥ1
 * 5���ж����Ƕ����죬�����29�췵��true�����򷵻�false
 */

public class CalendarTest {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ݣ��жϸ���������껹��ƽ�꣺");
		String line = sc.nextLine();
		int year = Integer.parseInt(line);
		boolean b = getYear(year);
		System.out.println(b);
	}

	private static boolean getYear(int year) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR) + "�꣬"
				+ (c.get(Calendar.MONTH) + 1) + "�£�"
				+ c.get(Calendar.DAY_OF_MONTH) + "�ա�");
		c.set(year, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(c.get(Calendar.YEAR) + "�꣬"
				+ (c.get(Calendar.MONTH) + 1) + "�£�"
				+ c.get(Calendar.DAY_OF_MONTH) + "�ա�");
		return c.get(Calendar.DAY_OF_MONTH) == 29;

	}

}
