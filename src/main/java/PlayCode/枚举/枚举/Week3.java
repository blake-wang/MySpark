package PlayCode.枚举.枚举��;

public abstract class Week3 {
	public static final Week3 MON = new Week3("����һ") {

		@Override
		public void show() {
			System.out.println("����һ");
		}

	};
	public static final Week3 TUE = new Week3("���ڶ�") {

		@Override
		public void show() {
			System.out.println("���ڶ�");
		}

	};
	public static final Week3 WED = new Week3("������") {

		@Override
		public void show() {
			System.out.println("������");
		}

	};

	private String name;

	// ����Ĭ���ǿղι���
	private Week3(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void show();
}
