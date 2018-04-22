package PlayCode.Demo.螺旋递增.输入列数;/*
�������������ִ�ӡ
*/
import java.util.Scanner;
/*
������������һ�����ִ�1��ʼ ����n��
*/
class Demo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ�����֣�");
		int n = sc.nextInt();
		int[][] arr = new int [n][n];
		int x,y,m;
		int a = 1;
		for (x=0,m=0;a<=n*n ;m++ ){
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