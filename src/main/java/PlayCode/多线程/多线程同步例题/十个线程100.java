package PlayCode.多线程.多线程同步例题;package ���߳̿κ���ϰ��;

public class ʮ���߳�100 {
	static int sum = 0;

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	
		Thread t1 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					sum = sum +i;
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 11; i <= 20; i++) {
					sum = sum +i;
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 21; i <= 30; i++) {
					sum = sum +i;
				}
			}
		});
		Thread t4 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 31; i <= 40; i++) {
					sum = sum +i;
				}
			}
		});
		Thread t5 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 41; i <= 50; i++) {
					sum = sum +i;
				}
			}
		});
		Thread t6 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 51; i <= 60; i++) {
					sum = sum +i;
				}
			}
		});
		Thread t7 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 61; i <= 70; i++) {
					sum = sum +i;
				}
			}
		});
		Thread t8 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 71; i <= 80; i++) {
					sum = sum +i;
				}
			}
		});
		Thread t9 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 81; i <= 90; i++) {
					sum = sum +i;
				}
			}
		});
		Thread t10 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 91; i <= 100; i++) {
					sum = sum +i;
				}
			}
		});
		t1.start();
		t2.start();
		//Thread.sleep(10);
		t3.start();
		//Thread.sleep(10);
		t4.start();
		//Thread.sleep(10);
		t5.start();
		//Thread.sleep(10);
		t6.start();
		//Thread.sleep(10);
		t7.start();
		//Thread.sleep(10);
		t8.start();
		//Thread.sleep(10);
		t9.start();
		//Thread.sleep(10);
		t10.start();
		//Thread.sleep(10);
		Thread.sleep(10);
		System.out.println(sum);

	}

}
