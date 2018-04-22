package PlayCode.Demo.模拟彩票中奖;/*
ģ���Ʊ�н�����  33ѡ7
*/
import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("��Ҫ���ж��ٸ����֣� ");
		int k = in.nextInt();
		
		System.out.print("һ���ж��ٸ���������£� ");
		int n = in.nextInt();

		//����һ�����飬1��2��3��4��5.......����������Ҫ�µ�����
		int[] numbers = new int[n];
		for(int i = 0;i<numbers.length;i++)
		{
			//�Ǳ��Ǵ�0��ʼ�������һ��Ԫ���Ǵ�1��ʼ
			numbers[i] = i+1;
		}

		//����k�����ֲ������ǷŽ��ڶ�������
		int[] result = new int[k];
		for(int i=0;i<result.length;i++){
			//��0 - n-1֮���������Ǳ�
			int r = (int)(Math.random()*n);
			//����ЩԪ�طŵ������λ��
			result[i] = numbers[r];

			//�����һλ�����ƶ��������λ��
			numbers[r] = numbers[n-1];
			n--;
		}
		//��ӡ�����������
		Arrays.sort(result);
		/*
		�����ʽ�Ľ�
		*/
		System.out.print("�����������������룬��ϲ���д��ˣ�"+"\n"+"[");
		/*
		for(int r:result)
			System.out.print(r+"	");
			
		*/
			
		for(int i=0;i<result.length;i++){
			if(i==result.length-1){
				System.out.print(result[i]+"]");
			}else
				System.out.print(result[i]+",");
			
		}

	}
}
