package PlayCode.Demo.猜数字;
import java.util.Scanner;


public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("��������µ�����");
		Scanner in = new Scanner(System.in);
		int guessNum = (int)(Math.random()*100)+1;
		while(true)
		{
			int num = in.nextInt();
			if(num < guessNum)
			{
				System.out.println("С��");
			}
			else if(num > guessNum)
			{
				System.out.println("����");
			}
			else{
				System.out.println("����");
				break;
			}
		}

	}

}
