package PlayCode.枚举.枚举2��2;

public enum Week2 {
	// ö��Ĭ���ǿղε�
	MON("����һ"){

		@Override
		public void show() {
			System.out.println("����һ");
		}
		
	}, TUE("���ڶ�") {
		@Override
		public void show() {
			System.out.println("���ڶ�");
		}
	}, WED("������") {
		@Override
		public void show() {
			System.out.println("������");
		}
	};
	private String name;

	private Week2(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}
	public abstract void show();

}
