package PlayCode.三十三道题.三十三04五名学生;package ��ʮ��04����ѧ��;

public class Student {
	private String name;
	private int chinese;
	private int math;
	private int english;
	private int sum;

	protected Student() {
		super();
	}

	protected Student(String name, int chinese, int math, int english, int sum) {
		super();
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		this.sum = chinese + math + english;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChinese() {
		return chinese;
	}

	public void setChinese(int chinese) {
		this.chinese = chinese;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}
	

	public int getSum() {
		return sum;
	}

	@Override
	public String toString() {
		return "������" + name + ", ���ĳɼ���" + chinese + ", ��ѧ�ɼ���"
				+ math + ", Ӣ��ɼ���" + english + ", �ܷ֣�" + sum + "��";
	}
	



}
