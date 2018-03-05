package com.taly.SimpleDotComGame;

/**
 * Created by Taly on 02.03.2018.
 */

public class SimpleDotComGame {
	public static void main(String[] args) {
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		DotCom theDotCom = new DotCom();
		int randomNum = (int)(Math.random() * 5);
		int[] location = {randomNum, randomNum + 1, randomNum + 2};
		theDotCom.setLocationCells(location);
		boolean isAlive = true;
		while (isAlive) {
			String guess = helper.getUserInput("Введите число");
			String result = theDotCom.checkYourself(guess);
			numOfGuesses++;
			if (result.equals("Потопил")) {
				isAlive = false;
				System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
			}
		}
	}
}
