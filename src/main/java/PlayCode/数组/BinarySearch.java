package PlayCode.数组;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(binarySearch(arr, 1));

	}
	/*
	 * �������ƣ� ���ֲ���
	 * ���ܣ������������Ƿ����Ҫ���ҵ�Ԫ�أ��оͷ���Ԫ���������е�������û�оͷ���-1
	 * 1������ֵ����     int��
	 * 2�������б�      int������  ��  value Ҫ���ҵ�Ԫ��
	 * 
	 */
	public static int binarySearch(int[] arr, int value) {
		int max = arr.length - 1;
		int min = 0;
		int mid = (min + max) / 2;
		while (value != arr[mid]) {
			if (value > arr[mid]) {
				min = mid + 1;
			} else if (value < arr[mid]) {
				max = mid - 1;
			} 
			mid = (min + max) / 2;
			if (min > max) {
				break;
			}
		}
		return mid;
	}
}
