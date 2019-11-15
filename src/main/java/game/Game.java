package game;

import java.io.Serializable;
import java.util.*;

import characters.Character;
import characters.monsters.*;
import characters.heros.*;
import utils.DiceRandom;
import utils.IOSerialization;
import utils.UserInterface;

public class Game implements Serializable {

	/**
	 * Generated versionID for serialization purposes
	 */
	private static final long serialVersionUID = -5491659127409615506L;

	/** player stock the player the user chose to play with */
	Hero player;
	/** stock the monster the play faced / will face in combat */
	List<Monster> monsterList = new ArrayList<Monster>();
	/**
	 * number of combat concluded during the game, surviving 15 combat means the
	 * player wins
	 */
	int fightsSurvived = 0;

	/* Constructors */

	public Game() {
		player = UserInterface.getHero();
	}

	public Game(Hero player) {
		if (player != null) {
			this.player = player;
		} else {
			System.out.println("No existing player detected, please select one");
			this.player = UserInterface.getHero();
		}
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

	public List<Monster> getMonsterList() {
		return monsterList;
	}

	public int getFightsSurvived() {
		return fightsSurvived;
	}

	/* Setters */

	public void setPlayer(Hero player) {
		this.player = player;
	}

	public void setMonsterList(Monster... monsterList) {
		for (Monster monster : monsterList) {
			this.monsterList.add(monster);
		}
	}

	public void setFightConcluded(int fightsSurvived) {
		this.fightsSurvived = fightsSurvived;
	}

	/* Others */

	/** */
	public void start() {
		int dice100Result;

		if (monsterList.isEmpty()) {
			monsterList.add(new Monster());
		} else if (monsterList.get(monsterList.size() - 1).getHealth() <= 0) {
			// If last monster in the list is "dead", add a new before the encounter
			monsterList.add(new Monster());
		}

		System.out.println(
				"You finish descending the stairs, you are now in the infamous Dungeon, what as you, lets find out.");

		while (player.getHealth() > 0 && fightsSurvived < 15) {
			IOSerialization.saveAutoGame(this); /*
												 * Saving the file before each encounter by serialization in a default
												 * file location
												 */
			dice100Result = DiceRandom.d100();
			System.out.print("You open the heavy door blocking your progress, to find ");
			/*
			 * Encounter phase 70% combat, 20% wandering training coach, 10% wandering
			 * cleric
			 */
			if (dice100Result <= 70) { // Combat
				System.out.print("a monster !\n");
				System.out.println("Remaining fights : " + (15 - fightsSurvived));

				if (this.charactersFight(player, monsterList.get(fightsSurvived))) {
					player.gainExperience(monsterList.get(fightsSurvived).getExperience());
					fightsSurvived++;
					if (fightsSurvived <= 15) {
						monsterList.add(new Monster());
					}
				}

			} else if (dice100Result <= 90) { // Training coach
				System.out.print("a friendly face, its the famous training coach!\n");
				this.trainingCoachEncounter(player);
			} else {
				System.out.print("a wandering cleric, willing to dispense its miracle to help you!\n");
				this.clericEncounter(player);
			}
			UserInterface.endEncounter(this);
		}

		if (player.getHealth() > 0) {
			System.out.println(player.getName() + " finally access the last room, after opening the heavy stone door"
					+ ", a sudden golden glow shines blinds the hero for a moment.\n "
					+ "The room is cover in treasures : pile of coins, magic trinkets, and a jewel the size of a newborn child.\n"
					+ "You finally achieved what you came to do, Congratulation Hero.");
		} else {
			System.out.println(player.getName() + " starts losing strength, falling on the knees, eyelids heavy.\n"
					+ "The darkness envelops you, a relief from the constant pain ... is this how it ends? Maybe. (Game Over)");
		}
		System.out.println(this);
		return;
	}

	/** Return true if the player survive, false if the player dies */
	public boolean charactersFight(Character player, Character monster) {
		int counter = 0;

		System.out.println("Combat !");
		UserInterface.waitForUser();

		while (player.getHealth() > 0 && monster.getHealth() > 0) {
			counter++;
			System.out.println(player);
			System.out.println(monster);

			switch (UserInterface.getActionType(player)) {
			case "attack_physical":
				if (player.hit_physical(monster)) {
					monster.hurt(player.attack_physical());
				}
				break;
			case "attack_magical":
				if (player.hit_magical(monster)) {
					monster.hurt(player.attack_magical());
				}
				break;
			default:
				System.out.println("That is not supposed to happen, what action did you do?"
						+ " Call the developper to tell him something went wrong.");
				break;
			}
			if (monster.getHealth() > 0) {
				if (monster.bestHit(player)) {
					player.hurt(monster.bestAttack());
				}
			}
		}

		System.out.println("Round : " + counter);

		if (player.getHealth() <= 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/** grants a levelUp() to the hero and keep the current gape in exp to the next level*/
	public void trainingCoachEncounter(Hero player) {
		System.out.println("Training coach : Hey, nice seeing something else than monster in this place, stay a moment."
				+ "How about I share some fighting stories and give you some tips to survive out there.\n" + "\n"
				+ "The knowledge you gain is enough to for you to gain enlightement.");
		long addedExperience = 10 + player.getNextLevelUp() / 10;
		player.gainExperience(addedExperience);
	}

	/** had 25% of maxHealth from player to his health with the healed(int) method */
	public void clericEncounter(Hero player) {
		System.out.println("Wandering cleric : Oh, you surprised me, i'm here to purify this wicked dungeon.\n"
				+ "Since you are here i may as well spare you one of my miracle.");
		player.healed((int) (player.getMaxHealth() * 0.25f));
	}

	@Override
	public String toString() {
		String result = "Game :\n" + "[player=" + player + "]\n" + "monster encountered :\n";
		for (Monster monster : monsterList) {
			result += monster.toString() + "\n";
		}

		result += "fightsSurvived=" + fightsSurvived;
		return result;
	}

}
