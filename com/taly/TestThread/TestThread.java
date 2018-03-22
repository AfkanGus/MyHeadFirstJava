package com.taly.TestThread;

/**
 * Created by Taly on 22.03.2018.
 */
public class TestThread {
	public static void main(String[] args) {
		ThreadOne t1 = new ThreadOne();
		ThreadTwo t2 = new ThreadTwo();

		Thread one = new Thread(t1);
		Thread two = new Thread(t2);

		one.start();
		two.start();
	}
}
