package com.taly.DogTestDrive;

/**
 * Created by Taly on 01.03.2018.
 */
public class Dog {
	int size;
	String name;

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
class DogTestDrive{
	public static void main(String[] args) {
		Dog one = new Dog();
		Dog two = new Dog();
		Dog three = new Dog();
		one.size = 70;
		two.size = 8;
		three.size = 35;
		one.bark();
		two.bark();
		three.bark();
	}


}
