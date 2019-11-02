package fr.dta.dungeoncrawler;

import characters.heros.*;
import characters.monsters.Monster;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Warrior hero = new Warrior("Jhon_Le_Magnifique");
		Monster monster = new Monster("Bourby");
		int counter = 0;
		
		System.out.println(hero);
		System.out.println(monster);
		System.out.println("Combat !");
		
		while (hero.getHealth() > 0 && monster.getHealth() > 0) {
			counter++;
			
			if (hero.hit_physical(monster)) {
				monster.hurt(hero.attack_physical());
			}

			if (monster.hit_physical(hero)) {
				hero.hurt(monster.attack_physical());
			}
		}
		
		System.out.println("Round : " + counter);
		System.out.println("We have a winner");
		System.out.println(hero);
		System.out.println(monster);
	}
}
