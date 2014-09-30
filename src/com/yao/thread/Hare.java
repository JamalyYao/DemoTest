package com.yao.thread;

public class Hare implements Runnable {

	private int totalStep;

	public Hare(int totalStep) {
		this.totalStep = totalStep;
	}

	@Override
	public void run() {
		int curStep = 0;
		boolean[] flag = { true, false };
		while (curStep < totalStep) {
			try {
				Thread.sleep(1 * 1000);
				if (flag[(int) (Math.random() * 10) % 2]) {
					System.out.printf("兔子开始睡一觉%n");
				} else {
					curStep += 2;
					System.out.printf("兔子跑了 %d 步 %n", curStep);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
