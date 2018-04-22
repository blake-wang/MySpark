package PlayCode.字符串.字符串切割

/*
�ַ����и�������ʳ��Ⱥ��ֵ�˳������

*/
public class StringSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "wo fen fei,fee chang de shuai ni zhi dao ma";
		String str2 = str.replace(",", " ");
		String[] arr = str2.split(" ");
		System.out.println("ab".compareTo("aaa"));
		sortLength(arr);
		sortCompare(arr);
		print(arr);
	}

	private static void print(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void sortCompare(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j].length() == arr[j + 1].length()
						&& arr[j].compareTo(arr[j + 1]) > 0) {
					exchange(arr, j);
				}
			}
		}
	}

	private static void exchange(String[] arr, int j) {
		String temp = arr[j];
		arr[j] = arr[j + 1];
		arr[j + 1] = temp;
	}

	private static void sortLength(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j].length() - arr[j + 1].length() >= 0) {
					exchange(arr, j);
				}
			}
		}
	}
}
