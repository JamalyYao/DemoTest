package com.yao.thread;

public class Tortoise implements Runnable {
	private int totalStep;

	public Tortoise(int totalSetp) {
		this.totalStep = totalSetp;
	}

	@Override
	public void run() {
		int curStep = 0;
		while(curStep < totalStep){
			try {
				Thread.sleep(1*1000);
				curStep++;
				System.out.printf("乌龟跑了 %n",curStep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
