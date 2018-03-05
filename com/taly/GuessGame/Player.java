package com.taly.GuessGame;

/**
 * Created by Taly on 28.02.2018.
 */
public class Player {
	protected int number;
	public void guess(){
		number = (int) (Math.random() * 10);
		System.out.println("Думаю, это число " + number);
	}
}
