package com.taly.TestException;

/**
 * Created by Taly on 14.03.2018.
 */
public class TestException {
	public static void main(String[] args) {
		//String test = "no";
		String test = "yes";
		try {
			System.out.println("Начало try");
			doRisky(test);
			System.out.println("Конец try");
		} catch (Exception se){
			System.out.println("--- Жуткое исключение ---");
		} finally {
			System.out.println("finally");
		}
		System.out.println("Конец main");
	}

	static void doRisky(String test) throws Exception{
		System.out.println("Начало опасного метода");
		if ("yes".equals(test)) {
			throw new Exception();
		}
		System.out.println("Конец опасного метода");
		//return;
	}
}
