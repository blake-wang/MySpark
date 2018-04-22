package PlayCode.三十三道题.三十三27枚举星期;package ��ʮ��27ö������;

public class Test {

	/**
	 * �Զ���ö��week��ʾ���ڼ���Ҫ��ÿ��ö��ֵ����tolocaleString�������������ĸ�ʽ�����ڼ���
	 */
	public static void main(String[] args) {
		System.out.println(WeekDay.MON.toLocalString());

	}

}
enum WeekDay{
	MON {
		@Override
		public String toLocalString() {
			return "����һ";
		}
	},TUE {
		@Override
		public String toLocalString() {
			return "���ڶ�";
		}
	},WED {
		@Override
		public String toLocalString() {
			return "������";
		}
	},THU {
		@Override
		public String toLocalString() {
			return "������";
		}
	},FRI {
		@Override
		public String toLocalString() {
			return "������";
		}
	},SAT {
		@Override
		public String toLocalString() {
			return "������";
		}
	},SUN{
		@Override
		public String toLocalString() {
			return "������";
		}
	};
	public abstract String toLocalString();
}
