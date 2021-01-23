package com.company;

public class Main {

    public static void main(String[] args) {

	Alien a1 = new Alien(true, 3);
	System.out.println("alien health : " + a1.getAlienHealth());

	a1.hit();
	System.out.println("hit method called, is dead? :" + a1.isDead());
	System.out.println();
	System.out.println("alien health : " + a1.getAlienHealth());

	a1.dodge();
	System.out.println("dodge method called, is dodging :" + a1.isDodging());
	System.out.println();

		a1.miss();
		System.out.println("miss method called, is dodging? :" + a1.isDodging());
		System.out.println();
		System.out.println("alien health : " + a1.getAlienHealth());

		a1.hit();a1.hit();
		System.out.println("hit method called x2, is dead? :" + a1.isDead());
		System.out.println();
		System.out.println("alien health : " + a1.getAlienHealth());

		System.out.println("hit method called, is dead? :" + a1.isDead());
		System.out.println("dodge method called, is dodging :" + a1.isDodging());
		System.out.println("miss method called, is dodging? :" + a1.isDodging());


	}
}
