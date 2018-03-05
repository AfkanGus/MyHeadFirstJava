package com.taly.SimpleDotComGame;

/**
 * Created by Taly on 02.03.2018.
 */
class SimpleDotCom{
	private int[] locationCells;
	int numOfHits = 0;

	public void setLocationCells(int[] locs) {
		locationCells = locs;
	}

	public String checkYourself(String stringGuess){
		int guess = Integer.parseInt(stringGuess);
		String result = "Мимо";
		for (int cell : locationCells) {
			if (cell == guess) {
				result = "Попал";
				numOfHits++;
				break;
			}
		}
		if (numOfHits == locationCells.length) {
			result = "Потопил";
		}
		System.out.println(result);
		return result;
	}
}
