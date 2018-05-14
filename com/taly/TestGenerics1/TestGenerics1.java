package com.taly.TestGenerics1;

/**
 * Created by Taly on 14.05.2018.
 */
public class TestGenerics1 {
	public static void main(String[] args) {
		new TestGenerics1().go();
	}

	public void go(){
		Animal[] animals = {new Dog(), new Cat(), new Dog()};
		Dog[] dogs = {new Dog(), new Dog(), new Dog()};
		takeAnimals(animals);
		takeAnimals(dogs);
	}

	public void takeAnimals(Animal[] animals){
		for (Animal a: animals) {
			a.eat();
		}
	}


	abstract class Animal{
		void eat(){
			System.out.println("животное ест");
		}
	}

	class Dog extends Animal{
		void bark(){}
	}

	class Cat extends Animal{
		void meow(){}
	}
}
