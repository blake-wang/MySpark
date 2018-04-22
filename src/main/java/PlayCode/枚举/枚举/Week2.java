package PlayCode.枚举.枚举��;

public class Week2 {
	public static final Week2 MON = new Week2("����һ");
	public static final Week2 TUE = new Week2("���ڶ�");
	public static final Week2 WED = new Week2("������");
	
	private String name;
	//����Ĭ���ǿղι���
	private Week2(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	

}
