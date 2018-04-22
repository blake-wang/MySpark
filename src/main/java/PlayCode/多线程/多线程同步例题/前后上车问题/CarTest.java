package PlayCode.多线程.多线程同步例题.前后上车问题;

public class CarTest {
	public static void main(String[] args) {
		Car c = new Car();
		Thread t1 = new Thread(c, "--ǰ  --��");
		Thread t2 = new Thread(c, "-- ��--��");
		t1.start();
		t2.start();
		//c.start();
	}
}

class Car implements Runnable {
	private int num = 700;
	public void run() {
		while (num>0) {
			synchronized (Car.class) {
				if (num <= 0) {
					break;
				}
				System.out.println("��" + Thread.currentThread().getName()
						+ "�ϳ�---��ʣ" + --num + "����λ");
			}
		}
	}
}
