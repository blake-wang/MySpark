package PlayCode.日历.三种格式化方法;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Test04 {

	/**
	 * ���󣺼���ӽ�������100���Ժ��Ǽ��¼��ţ�����ʽ����xxxx��xx��xx�յ���ʽ��ӡ����
	 * ���裺1������Calendar���add������������100��������
	 *     2������Calendar��getTime������������Date���Ͷ���
	 *     3��ʹ��Full��ʽ��DateFormat���󣬵���format����������ʽ��Date����
	 */
	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		String str = sdf.format(d);
		System.out.println(str);
		
		System.out.println("---------------------");
		
		Calendar c = Calendar.getInstance();
		c.set(2016,2,30);
		c.add(Calendar.DAY_OF_MONTH, 100);
		Date d2 = c.getTime();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		String str3 = df.format(d2);
		System.out.println(str3);
		
		System.out.println("---------------------");
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd��");
		String str2 = sdf.format(d2);
		System.out.println(str2);

	}

}
