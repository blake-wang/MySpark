package PlayCode.三十三道题.三十三04五名学生;package ��ʮ��04����ѧ��;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test {
	/**
	 * 4�� �����ѧ����ÿ��ѧ����3�ſΣ����ġ���ѧ��Ӣ��ĳɼ��� дһ��������մӼ�������ѧ������Ϣ�� �����ʽΪ��name,30,30,30
	 * �����������ſγɼ����� Ȼ��������ѧ����Ϣ���ִܷӸߵ��͵�˳��д��
	 * ��һ������"stu.txt"�ļ��С�Ҫ��stu.txt�ļ��ĸ�ʽҪ�Ƚ�ֱ�ۣ� ������ļ����Ϳ��Ժ�����Ŀ���ѧ������Ϣ��
	 * 
	 * �ҵ�˼·�� 1������һ��ѧ���࣬ѧ����4�����ԣ����������ĳɼ�����ѧ�ɼ���Ӣ��ɼ����ܷ� 2�����ֶ�¼��ķ�ʽ¼��ѧ������Ϣ�������ַ����ĸ�ʽ����
	 * 3�����ַ����и���ַ����飬�����е�Ԫ�ذ���˳���ѧ������Ϣһһ��Ӧ 4���������е�Ԫ��ת����ʽ����newѧ������
	 * 5����ѧ������ͳɼ��ܷ��Լ�ֵ�Եķ�ʽ���TreeMap�У��������ܷ��ɸߵ��͵�˳������
	 * 6������IO���������TreeMap�е�Ԫ�ش�ӡ��stu.txt�ļ���
	 * 
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				int num = s2.getSum() - s1.getSum();
				return num == 0 ? 1 : num;
			}
		});
		System.out.println("�밴������,���ĳɼ�,��ѧ�ɼ�,Ӣ��ɼ���ʽ����5��ѧ������Ϣ��");
		int i = 1;
		while (i <= 5) {
			String s = sc.nextLine();
			String[] str = s.split(",");
			String name = str[0];
			int chinese = Integer.parseInt(str[1]);
			int math = Integer.parseInt(str[2]);
			int english = Integer.parseInt(str[3]);
			int sum = chinese + math + english;
			Student stu = new Student(name, chinese, math, english, sum);
			ts.add(stu);
			i++;
		}
		FileOutputStream fos = new FileOutputStream("stu.txt");
		for (Student student : ts) {
			fos.write(student.toString().getBytes());
			fos.write("\r\n".getBytes());
		}
		fos.close();
	}
}
