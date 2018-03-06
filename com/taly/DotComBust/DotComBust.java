package com.taly.DotComBust;

import java.util.ArrayList;

/**
 * Created by Taly on 02.03.2018.
 */

public class DotComBust {
	// объявляем и инициализируем переменные, которые нам понадобятся
	private GameHelper helper = new GameHelper();
	// создаем ArrayList только для объектов DotCom
	private ArrayList<DotCom> dotComList = new ArrayList<>();
	private int numOfGuesses = 0;

	public static void main(String[] args) {
		DotComBust game = new DotComBust(); //создаем игровой объект
		game.setUpGame(); // говорим игровому объекту подготовить игру
		/*
		говорим игровому объекту начать главный игровой цикл
		(продолжаем запрашивать пользовательский ввод и проверять полученные данные)
		 */
		game.startPlaying();
	} //конец метода

	private void setUpGame(){
		// создадим несколько сайтов и присвоим им адреса
		// создаем три объекта DotCom, даем имена и помещаем в ArrayList
		DotCom one = new DotCom();
		one.setName("one.com");
		DotCom two = new DotCom();
		two.setName("two.com");
		DotCom three = new DotCom();
		three.setName("three.com");
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);

		// выводим краткие инструкции для пользователя
		System.out.println("Ваша цель - потопить три \"Сайта\".");
		System.out.println("one.com, two.com, three.com");
		System.out.println("Попытайтесь потопить их за минимальное количество ходов");

		for (DotCom dotComToSet : dotComList) { // повторяем с каждым объектом DotCom в списке
			//запрашиваем у вспомогательного объекта адрес "сайта"
			ArrayList<String> newLocation = helper.placeDotCom(3);
			/*
			Вызываем сеттер из объекта DotCom,
			чтобы передать ему местоположение, которое только что получили
			от вспомогательного объекта
			 */
			dotComToSet.setLocationCells(newLocation);
		} // конец for
	} // конец метода

	private void startPlaying(){
		while (!dotComList.isEmpty()){ //до тех пор, пока список объектов DotCom не станет пустым
			String userGuess = helper.getUserInput("Сделайте ход"); // Получаем пользовательский ввод
			checkUserGuess(userGuess); // вызываем наш метод checkUserGuess
		} // конец while
		finishGame(); // вызываем наш метод finishGame
	} // конец метода

	private void checkUserGuess(String userGuess){
		numOfGuesses++; // инкрементируем количество попыток, которые сделал пользователь
		String result = "Мимо"; // Подразумеваем промах, пока не выяснили обратного
		for (DotCom dotComToTest : dotComList) { // повторяем это для всех объектов DotCom в списке
			// Просим DotCom проверить ход пользователя, ищем попадание (или потопление)
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("Попал")) {
				break; //выбираемся из цикла раньше времени, нет смысла проверять другие "сайты"
			}
			if (result.equals("Потопил")) {
				/*
				ему пришел конец, та что удаляем его из списка "сайтов" и выходим из цикла
				 */
				dotComList.remove(dotComToTest);
				break;
			}
		} // конец for
		System.out.println(result); // выводим для пользователя результат
	} // конец метода

	private void finishGame(){
		// выводим сообщение о том, как пользователь прошел игру
		System.out.println("Все \"сайты\" ушли ко дну! Ваши акции теперь ничего не стоят.");
		if (numOfGuesses <= 18) {
			System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток.");
			System.out.println("Вы успели выбраться до того, как ваши вложения утонули.");
		} else {
			System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток.");
			System.out.println("Рыбы водят хороводы вокруг ваших вложений");
		}
	} // конец метода
} // конец класса
