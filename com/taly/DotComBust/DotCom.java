package com.taly.DotComBust;

import java.util.ArrayList;

/**
 * Created by Taly on 02.03.2018.
 */
class DotCom {
	private ArrayList<String> locationCells; // ArrayList с ячейками, описывающими местоположение
	private String name; // имя сайта

	public void setLocationCells(ArrayList<String> loc) {
		/*
		сеттер, который обновляет местоположение "сайта"
		(случайный адрес, предоставляемый методом placeDotCom
		из класса GameHelper)
		 */
		locationCells = loc;
	}

	public String checkYourself(String userInput){
		String result = "Мимо";
		/*
		Если ход пользователя совпал с одни из элементов ArrayList,
		то метод indexOf() вернет его местоположение.
		Иначе, вернет -1
		 */
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index); // удалим элемент
			if (locationCells.isEmpty()) { // проверим все ли адреса разгаданы
				result = "Потопил";
				System.out.println("Ой! Вы потопили " + name + " : ( ");
			}else {
				result = "Попал";
			} // конец if
		} // конец if
		System.out.println(result);
		return result;
	} // конец метода

	public void setName(String name) {
		this.name = name;
	}
} // конец класса
