package PlayCode.三十三道题.三十三02员工建模;package ��ʮ��02Ա����ģ;

public class Test {
	/**
	 * 2�� ���������ڿ���һ��ϵͳʱ��Ҫ��Ա�����н�ģ��Ա������ 3 �����ԣ�
	 * �����������Լ����ʡ�����Ҳ��Ա�������˺���Ա���������⣬��Ϊ����һ���������ԡ���ʹ�ü̳е�˼����Ƴ�Ա����;����ࡣҪ�������ṩ��Ҫ�ķ����������Է��ʡ�
	            
	     ˼·:
	     1.����ȷ��,˭�Ǹ���?˭������?
	     2.�����Ѿ�ӵ�е�,����ͨ��super�Ϳ��Ի�ȡ��,���ڸ�����˵,�ṩ�������
	     �����Լ�����.����������˵,��Ȼ�Ǽ̳�,����Ҫ���Լ����صķ��������ԲŴ�������.
	     
	  �ܽ�:
	  	��������һ������----�̳�.�ܴ�̶��ϼ����˴�����,�����˳���Ĺ�����չ,����ߴ���ĸ���.
	  	
	  ˼��:
	  	�̳м�Ȼ��ĳ�̶ֳ������ӵĳ���Ĺ�����չ�Լ����븴��.����,����֮������������׽���.
	  	��ô�����̳л����ʲô���ı׶���?
	  	1.���ڼ̳�ֻ�����ǵ��̳�,��ô�����������Ҫ���¶���һ����ϵ����ʱ,��û���ٿ��Լ̳е�Ȩ����.
	  	2.�̳�Ҳ��֮ǰ��һ�ĳ�����������������ϵ.��ά���Ƕȿ�,�����˵Ҳ������ά�����Ѷ�.
	  	3.��������,��˼̳���Ҫ��һ������ӵ��ǿ���ԵĻ����ϼ̳вŻ��������Ч��,Ϊ�̳ж��̳�,�ͻ�ʹ�ó������ḡ,��������ά��.
	     
	 * */


	public static void main(String[] args) {
		Employee e = new Employee("ʷ����",123,8000);
		Manager m = new Manager("����",200,1000000,2000);
		System.out.println(e);
		System.out.println(m);

	}

}
