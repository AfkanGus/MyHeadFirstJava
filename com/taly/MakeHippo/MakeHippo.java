package com.taly.MakeHippo;

/**
 * Created by Taly on 10.03.2018.
 */
abstract class Animal{
	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Hippo extends Animal{
	public Hippo(String name) {
		super(name);
	}
}

public class MakeHippo {
	public static void main(String[] args) {
		Hippo hippo = new Hippo("Buff");
		System.out.println(hippo.getName());
	}
}
