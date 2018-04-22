package PlayCode.数组.打印一维 package ��ӡ����;

public class ArrayPrintTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {19,56,99,2,7,10,29};
		int[][] arr2 = {{1,5,9,2},{22,67,89,10,3},{12,66,88,24,90,1}};
		int[][] arr3 = {{23,45,6,1,7},{1,2,3,4,5},{12,6,8,9,0,1}};
		ArrayPrint ap = new ArrayPrint();
		ap.print1(arr1);
		System.out.println();
		ap.print2(arr2);
		System.out.println();
		ap.print3(arr3);
		

	}

}


class ArrayPrint {
	public void print1(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				System.out.print(arr[i] + ",");
			} else {
				System.out.print(arr[i] + "]");
			}
		}
	}

	/*
	 * print2ʹ��ѭ��Ƕ�״�ӡ�Ķ�ά����
	 */
	public void print2(int[][] arr) {
		System.out.print("{");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				if (j == 0) {
					System.out.print("[" + arr[i][j] + ",");
				}

				else if (j < arr[i].length - 1) {

					System.out.print(arr[i][j] + ",");
				} else if (j == arr[i].length - 1) {
					System.out.print(arr[i][j]);
					if (i < arr.length - 1) {
						System.out.print("],");
					} else {
						System.out.print(arr[i][j] + "]");
					}
				}
			}
		}
		System.out.print("}");
	}

	public void print3(int[][] arr) {
		System.out.print("{");
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				print1(arr[i]);
				System.out.print(",");
			}else{
				print1(arr[i]);
			}
		}
		System.out.print("}");

	}

}
