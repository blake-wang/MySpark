package PlayCode.三十三道题.三十三10喝可乐;package ��ʮ��10�ȿ���;

public class Test02 {

	public static void main(String[] args) {
		System.out.println(cocoNum(28));
	}
	public static int cocoNum(int person){
		int lid = 0;  //������
		int cola = 0; //���ԺȵĿ���
		int gouMai = 0; //����Ŀ�����
		//�����ԺȵĿ�����������ʱ���ͼ�������
		while(cola<person){
			gouMai++;
			lid++;
			cola++;
			//��ƿ������3�����͸�ֵΪ1�����ÿ��ԺȵĿ���������1
			if(lid==3){
				lid = 1;
				cola++;
			}
		}
		return gouMai;
	}
}
