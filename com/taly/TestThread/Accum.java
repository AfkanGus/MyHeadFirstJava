package com.taly.TestThread;

/**
 * Created by Taly on 22.03.2018.
 */
class Accum {
	private static Accum a  = new Accum(); // так как экземпляр статический, он один на весь класс
	private int counter = 0;

	private Accum(){} // констуктор приватный, значит никто другой не может создать объект класса

	public static Accum getAccum() {    // статический геттер + приватный конструктор = Singleton
		// ( шаблон проектирования одиночка)
		return a;
	}

	public int getCount() {
		return counter;
	}

	public void updateCounter(int add){
		counter += add;
	}
}
