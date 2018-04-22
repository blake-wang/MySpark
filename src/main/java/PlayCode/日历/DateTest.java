package PlayCode.日历;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Date d1 = new Date();
		System.out.println(d1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		String str = sdf.format(d1);
		System.out.println(str);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd��");
		String str2 = "2011��12��19��";
		System.out.println(sdf2.parse(str2));

	}

}
