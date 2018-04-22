package PlayCode.三十三道题.三十三21共享数组开线程;package ��ʮ��21�������鿪�߳�;

import java.util.Random;

class ArrayAdd implements Runnable {
	private int[] in;
	private int num = 0;

	ArrayAdd(int[] in) {
		this.in = in;
	}

	public void run() {
		while (true) {
			synchronized (this) {
				if (num < in.length) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Random rd = new Random();
					int i = rd.nextInt(20) + 1;
					in[num] = i;
					num++;
					try {
						in.wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					break;
				}
			}
		}
	}

}