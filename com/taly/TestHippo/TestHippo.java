package com.taly.TestHippo;

/**
 * Created by Taly on 10.03.2018.
 */

class Animal{
	public Animal(){
		System.out.println("Animal");
	}
}

class Hippo extends Animal{
	public Hippo(){
		System.out.println("Hippo");
	}
}
public class TestHippo {
	public static void main(String[] args) {
		System.out.println("Start");
		Hippo hippo = new Hippo();
	}
}
