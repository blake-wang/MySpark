package PlayCode.数组;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {99,2,8,4,7,22,1,9,6};
		bubbleSort(arr);
		print(arr);
		

	}
	/*
	 * ð������
	 * 1������ֵ����
	 * 2�������б�
	 */
	public static void bubbleSort(int[] arr){
		for(int i = 0;i<arr.length-1;i++){
			for(int j =0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp =arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void print(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
