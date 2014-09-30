package com.yao.thread;

public class HareTortoiseGame {

	public static void main(String[] args) {
		int totalStep = 10;
		Thread hare = new Thread(new Hare(totalStep));
		Thread tortoise = new Thread(new Tortoise(totalStep));
		hare.start();
		tortoise.start();
	}

}
