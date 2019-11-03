package game;

import java.util.*;

import characters.Character;
import characters.monsters.*;
import characters.heros.*
;
import utils.UserInterface;

public class Game {

	/** player stock the player the user chose to play with */
	Hero player;
	/** stock the monster the play faced / will face in combat */
	List monsterList;
	/**
	 * number of combat concluded during the game, surviving 15 combat means the
	 * player wins
	 */
	int fightsSurvived = 0;

	/* Constructors */

	public Game() {
		player = UserInterface.getHero();
		monsterList = new ArrayList<Monster>();
	}

	public Game(Hero player) {
		if (player != null) {
			this.player = player;
		} else {
			System.out.println("No existing player detected, please select one");
			this.player = UserInterface.getHero();
		}
		monsterList = new ArrayList<Monster>();
	}
	
	public Game(Hero player, List<Monster> monsterList) {
		if (player != null) {
			this.player = player;
		} else {
			System.out.println("No existing player detected, please select one");
			this.player = UserInterface.getHero();
		}
		this.monsterList = monsterList;
	}
	
	/* Methods */
	
	/* Getters */
	
	public Hero getPlayer() {
		return player;
	}

	public List getMonsterList() {
		return monsterList;
	}

	public int getFightsSurvived() {
		return fightsSurvived;
	}
	
	/* Setters */

	public void setPlayer(Hero player) {
		this.player = player;
	}	

	public void setMonsterList(List monsterList) {
		this.monsterList = monsterList;
	}
	
	public void setFightConcluded(int fightsSurvived) {
		this.fightsSurvived = fightsSurvived;
	}
	
	/* Others */
	
	/** Return true if the player survive, false if the player dies */
	public boolean charactersFight(Character player, Character monster) {
		int counter = 0;
		
		System.out.println(player);
		System.out.println(monster);
		System.out.println("Combat !");
		
		while (player.getHealth() > 0 && monster.getHealth() > 0) {
			counter++;
			
			if (player.hit_physical(monster)) {
				monster.hurt(player.attack_physical());
			}

			if (monster.bestHit(player)) {
				player.hurt(monster.bestAttack());
			}
		}
		
		System.out.println("Round : " + counter);
		System.out.println("We have a winner");
		System.out.println(player);
		System.out.println(monster);
		
		if (player.getHealth() <= 0) {
			return false;
		} else {
			return true;
		}
	}
}
