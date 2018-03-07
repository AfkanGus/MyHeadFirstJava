package com.taly.Of76;

/**
 * Created by Taly on 07.03.2018.
 */
public class Of76 extends Clows {
	public static void main(String[] args) {
	Nose [] i = new Nose[3];
	i[0] = new Acts();
	i[1] = new Clows();
	i[2] = new Of76();
		for (int x = 0; x < 3; x++) {
			System.out.println(i[x].iMethod() + " " + i[x].getClass());
		}
	}
}

interface Nose{
	public int iMethod();
}

abstract class Picasso implements Nose{
	public int iMethod(){
		return 7;
	}
}

class Clows extends Picasso{}

class Acts extends Picasso{
	public int iMethod() {
		return 5;
	}
}
