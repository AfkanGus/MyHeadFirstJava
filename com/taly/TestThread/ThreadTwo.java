package com.taly.TestThread;

/**
 * Created by Taly on 22.03.2018.
 */
public class ThreadTwo implements Runnable {
	Accum a = Accum.getAccum();
	@Override
	public void run() {
		for (int i = 0; i < 99; i++) {
			a.updateCounter(1);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("two " + a.getCount());
	}
}
