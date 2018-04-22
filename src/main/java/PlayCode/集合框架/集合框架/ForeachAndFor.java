package PlayCode.集合框架.集合框架;package ���Ͽ��;

public class ForeachAndFor {

	/**
	 * @param args
	 */
	static String[] str = { "abc", "123", "ooo" };

	public static void main(String[] args) {

		for (String string : str) {
			string = "ddd";
		}
		for (String string : str) {
			System.out.println(string);
		}
		for (int i = 0; i < str.length; i++) {
			str[i] = "ddd";

		}
		for (String string : str) {
			System.out.println(string);
		}

	}

}
