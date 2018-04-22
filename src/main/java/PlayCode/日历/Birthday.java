package PlayCode.日历;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Birthday {

	/**
	 * �����Լ������˶�����
	 * ˼·
	 * 1�����ַ�����¼�Լ������գ��Լ����������
	 * 2������SimpleDateFormat����
	 * 3����SimpleDateFormat������������ΪDate����
	 * 4��ͨ������ֵ�����Լ������������
	 */
	public static void main(String[] args) {
		String birthday = "1989��12��19��";
		String today = "2016��3��29��";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		try {
			Date d1 = sdf.parse(birthday);
			Date d2 = sdf.parse(today);
			System.out.println((d2.getTime()-d1.getTime())/1000/60/60/24);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		

	}

}
