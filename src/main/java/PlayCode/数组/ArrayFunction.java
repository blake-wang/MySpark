package PlayCode.数组;

import java.util.*;
class ArrayFunction {
	public static void main(String[] args) {
		System.out.println("����������ĳ��ȣ�");
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int[] arr = new int[length];
		if(length<=0)
		{
			System.out.println("����������鳤�Ȳ���ȷ��");
		}
		else
		{
			for(int i =0;i<length;i++)
			{
				System.out.println("������� "+(i+1)+" ��Ԫ�أ�");
				int a = in.nextInt();
				arr[i] = a;
			}
		System.out.println("������������ǣ�");
		System.out.print("[");
		}
		for(int i=0;i<arr.length;i++)
		{
			if(i>=0 && i<arr.length-1)
			{
				System.out.print(arr[i]+", ");
			}
			else if(i==arr.length-1)
			{
				System.out.print(arr[i]+"]");
				System.out.println();	
			}
		}
		//����һ����ǣ���ʼֵ��true
		boolean flag = true;
		while(flag)
		{
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("ѡ����Ҫִ�еĲ�����");
			System.out.println("1 ---> ��ת����");
			System.out.println("2 ---> ����");
			System.out.println("3 ---> ������ֵ");
			System.out.println("4 ---> �������С�����������");
			System.out.println("5 ---> �˳�");
			
			int select = in.nextInt();
			switch(select)
			{
				case 1:
					reverse(arr);
					print(arr);
					System.out.println();
				break;
				case 2:
					System.out.print("��������Ҫ���ҵ�����");
					int x = in.nextInt();
					int y = BinarySearch(arr,x);
					System.out.println(y);
				break;
				case 3:
					System.out.println("�����е����ֵ�ǣ�"+getMax(arr));
					System.out.println();
				break;
				case 4:
					selectSort(arr);
					System.out.println();
				break;
				case 5:
					flag = false;
					System.out.println();
				break;
			}
		}
	}
	/*
	���鷴ת
	*/
	public static void reverse(int[] arr)
	{
		for(int i=0;i<arr.length/2;i++)
		{
			int temp= arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
	/*
	������ӡ����
	*/
	public static void print(int[] arr)
	{
		System.out.print("[");
		for(int i=0;i<arr.length;i++)
		{
			if(i>=0 && i<arr.length-1)
			{
				System.out.print(arr[i]+", ");
			}
			else if(i==arr.length-1)
			{
				System.out.print(arr[i]+"]");
			}
		}	
	}
	/*
	���������е�Ԫ��
	(�ö��ֲ��ң��������Ч��̫��)
	*/
	/*
	public static void find(int[] arr,int x)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==x)
			{
				System.out.println("��Ҫ���ҵ��� "+x+" ��������ĵ�"+(i+1)+"��Ԫ�ء�");
				break;
			}
			else if( arr[i]!=x && i==arr.length-1)
			{
				System.out.println("��Ҫ���ҵ��� "+x+" �������в����ڡ�");
				break;
			}	
		}	
	}
	*/
	/*
	���������е�Ԫ�� �� ���ֲ���
	*/
	public static int BinarySearch(int[] arr, int value) {
		int max = arr.length - 1;
		int min = 0;
		int mid = (max + min) / 2;
		while (value != arr[mid]) {
			if (value > arr[mid]) {
				min = mid + 1;
			} else if (value < arr[mid]) {
				max = mid - 1;
			}
			mid = (max + min) / 2;
			if (min > max) {
				return -1;
			}
		}
		return mid;
	}
	/*
	ȡ���������ֵ
	*/
	public static int getMax(int[] arr)
	{
		int max = arr[0];//�����һ��Ԫ�������ֵ
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
				max = arr[i];//�õ����ֵԪ��
		}
		return max;//�������ֵԪ��
	}
	/*
	ѡ������
	*/
	public static void selectSort(int[] arr)
	{
		for(int x=0;x<arr.length-1;x++)//��ѭ�����ƱȽϼ���
		{
			for(int y=x+1;y<arr.length;y++)//��ѭ������ÿ�ֱȽϼ���
			{
				if(arr[x]>arr[y])
				{
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;   //��С��������
				}
			}
		}
		print(arr);
	}
}
