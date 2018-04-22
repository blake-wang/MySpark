package PlayCode.字符串.统计子字符串在大字符串出现的次数�����ַ����ڴ��ַ������ֵĴ���;
/*
 * ���ַ�����woyouyigemengxiang,wodediyigemengxiangshiyouqian,diergemengxiangshiyoulaopo,disangemengxiangshiyoubiantianxia;
 * С�ַ�����mengxiang
 * �������С�ַ����ڴ��ַ����г��ֵĴ���
 */

public class stringNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String big = "woyouyigemengxiang,wodediyigemengxiangshiyouqian,diergemengxiangshiyoulaopo,disangemengxiangshiyoubiantianxia";
		String small = "mengxiang";
		int count = 0;
		//�жϴ��ַ������Ƿ����С�ַ���
		while(big.indexOf(small)!=-1){
			count++;
			//��big.indexOf(small)+small.length()��ʼ���ַ���ĩβ
			big = big.substring(big.indexOf(small)+small.length());
		}
		System.out.println("С�ַ����Ĵ��ַ����г��ֵĴ����ǣ�"+count+" �Σ�");
		

	}

}
