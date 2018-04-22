package PlayCode.三十三道题.三十三30;package ��ʮ��30;

public class Test {

	//��дһ��������������һ�����������е�ÿ��Ԫ���ö������ӳ�һ���ַ�����
	//���磬��������Ϊ[1][2][3]�������γ�����Ϊ"1,2,3"���ַ�����

	public static void main(String[] args) {
		int[] arr = {1,4,6,8,9,2};
		String str = getString(arr);
		System.out.println(str);
	}

	private static String getString(int[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if(i!=arr.length-1){
				sb.append(arr[i]+",");
			}else{
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
	

}
