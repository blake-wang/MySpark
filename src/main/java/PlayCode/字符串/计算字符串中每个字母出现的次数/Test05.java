package PlayCode.字符串.计算字符串中每个字母出现的次数;

public class Test05 {

	/**
	 * ȡ��һ���ַ�������ĸ���ֵĴ������磺�ַ�����"abcdekka27qoq" �������ʽΪ��a(2)b(1)k(2)...
	 */
	public static void main(String[] args) {
		String s = "wfq24fwgewg32erh2fge79rge24rge43rweabc3rewwe239ttwt2r";
		int arrayLength = 0;
		int index = 0;
		while(true) {
			char regex = s.charAt(index++);
			arrayLength = s.length();
			if(regex >= 'a'&& regex <= 'z') {
				s = s.replaceAll(regex+"", "");
				arrayLength -= s.length();
				System.out.print(regex+"("+arrayLength+")");
				index = 0;
				System.out.println(s);
			}
			if(index == arrayLength)
				break;		
		}

	}

}
