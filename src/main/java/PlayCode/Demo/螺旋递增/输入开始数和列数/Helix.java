package PlayCode.Demo.螺旋递增.输入开始数和列数;

import java.util.Scanner;
/*
������������һ�����ִ�a��ʼ,��n��
*/
class Helix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ�����֣�");
		int n = sc.nextInt();
		System.out.println("������һ�����֣�");
		int a = sc.nextInt();
		int[][] arr = new int [n][n];
		int x,y,m;
		for (x=0,m=0;m<n/2+1;m++ ){
			for (y=x;x<n-m ;x++ ){
				arr[y][x] = a++;
			}
			x--;
			for (y=y+1;y<n-m ;y++ ){
				arr[y][x] = a++;
			}
			y--;
			for (x=x-1;x>=m ;x-- ){
				arr[y][x] = a++;
				
			}
			x++;
			for (y=y-1;y>m ;y-- ){
				arr[y][x] = a++;
			}
			x++;
		}
		for (int i = 0;i < n ;i++ ){
			for (int j = 0;j < n ;j++ ){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
