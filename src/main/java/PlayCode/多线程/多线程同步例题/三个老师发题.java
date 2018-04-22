package PlayCode.多线程.多线程同步例题;package ���߳̿κ���ϰ��;

public class ������ʦ���� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SendTest st = new SendTest();
		Thread t1 = new Thread(st,"���");
		Thread t2 = new Thread(st,"ƽƽ");
		Thread t3 = new Thread(st,"�һ�");
		//t1.setName("��ʦһ");
		//t2.setName("��ʦ��");
		//t3.setName("��ʦ��");
		t1.start();
		t2.start();
		t3.start();
	}
}

class SendTest extends Thread {
	private int note = 80;
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (SendTest.class) {
				if (note <= 0) {
					break;
				}
				System.out.println(Thread.currentThread().getName() + "����"
						+ note-- + "��ѧϰ�ʼ�");
			}
		}
	}
}
