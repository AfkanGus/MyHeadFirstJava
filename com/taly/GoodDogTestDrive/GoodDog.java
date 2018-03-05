package com.taly.GoodDogTestDrive;

/**
 * Created by Taly on 01.03.2018.
 */
public class GoodDog {
	private int size;
	private String name;

	public void setSize(int s) {
		size = s;
	}

	public int getSize() {
		return size;
	}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	void bark(){
		if (size > 60) {
			System.out.println("Гав Гав!");
		}else if (size > 14) {
			System.out.println("Вуф Вуф!");
		} else {
			System.out.println("Тяф Тяф!");
		}
	}
}

class GoodDogTestDrive {
	public static void main(String[] args) {
		GoodDog one = new GoodDog();
		GoodDog two = new GoodDog();
		GoodDog three = new GoodDog();
		one.setSize(70);
		two.setSize(8);
		three.setSize(35);
		System.out.println("Первая собака: " + one.getSize());
		System.out.println("Вторая собака: " + two.getSize());

		one.bark();
		two.bark();
		three.bark();
	}
}
