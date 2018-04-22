package PlayCode.数组;

public class SelectSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 100,51,89, 12, 66, 26, 87, 12, 37, 99, 1, 7 };
		selectSort(arr);
		print(arr);

	}

	/*
	 * ѡ������ 1������ֵ���� 2�������б�
	 */
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}

			}
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
