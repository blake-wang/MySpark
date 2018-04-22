package PlayCode.多线程;package ���߳̿κ���ϰ��;

public class �����������߳� {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("main  "+(i+1));
		}
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					System.out.println("new  "+(i+1));
				}
			}
		}).start();
		
	}

}

