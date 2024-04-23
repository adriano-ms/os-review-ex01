package view;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		
		int processesAmount = 20;
		
		Semaphore mutex = new Semaphore(1);
		Thread[] processes = new Thread[processesAmount];
		
		for(int i = 0; i < processesAmount; i++) {
			processes[i] = new Thread() {
				@Override
				public void run() {
					try {
						mutex.acquire();
						System.out.println(this.getName() + " Starting");
						sleep((long)(Math.random() * 8001) + 4000);
						System.out.println(this.getName() + " Ending");
						mutex.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}
		
		for(Thread process : processes) {
			process.start();
		}

	}

}
