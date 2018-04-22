package PlayCode.集合框架.集合遍历问题;

import java.util.ArrayList;
/*
������for������ʱ��������������ɾ��Ԫ�صĶ�������Ҫ��ÿ�α����У��Ǳ�Ҫ��1
������Ϊ�����ϵĴ�С��ʵʱ��С�ģ����ɾ��һ��Ԫ�أ�����size�ͻ��С1���Ǳ��Ҫ--���������Ҫע��������⣬�������������������⡣
*/

public class One {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("women12");
		list.add("hehe9");
		list.add("haha");
		list.add("aaaa1111");
		list.add("aaaaaaaaaaa");
		list.add("aaaaaaaaaaa");
		list.add("aaaaaaaaaaa");
		list.add("22adbc");
		list.add("1111111");
		list.add("aaaaaaaaaaa");
		list.add("aaaaaaaaaaa");
		list.add("aaaaaaaaaaa");
		list.add("aaaaaaaaaaa");
		list.add("aaaaaaaaaaa");
		list.add("aaaaaaaaaaa");
		list.add("aaaaaaaaaaa");
		deleteNum(list);
		System.out.println(list);
	}

	public static void deleteNum(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			char[] c = list.get(i).toCharArray();
			for (int j = 0; j < c.length; j++) {
				if (c[j] >= '0' && c[j] <= '9') {
					//���ֽǱ�Խ���쳣��ԭ���ǣ�����ɾ��һ��Ԫ�أ����ϵ�size�ͻ�ʵʱ��Сһ���������Ϳ�����ɽǱ�Խ���쳣,����취������������Ǳ�Ҫ--
					list.remove(i--);
					//ֻҪ��һ���ַ������֣���ֱ��ɾ���ַ�������break��
					break;
				}
			}
		}
	}
}
