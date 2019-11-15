package utils;

import characters.Character;
import characters.heros.*;
import game.*;

public class UserInterface {
	/* Methods */

	/* Others */

	public static void homeStart() {
		System.out.print("Welcome to DungeonCrawler , input a corresponding number to access :\n" + "1) New game\n"
				+ "2) Load existing game\n" + "3) Exit\n");
		Integer inputUser = Integer.valueOf(Scan.scan.nextLine());
		Game game;
		switch (inputUser) {
		case 1:
			game = UserInterface.newGame();
			game.start();
			break;
		case 2:
			game = UserInterface.loadGame();
			game.start();
			break;
		default:
			System.out.println("Thank you for playing, see you again in the Dungeon !");
		}
		return;
	}

	public static Game newGame() {
		return new Game();
	}

	// TO BE DONE !
	public static Game loadGame() {
		return IOSerialization.loadGame();
	}

	public static Hero getHero() {
		System.out.print("A new challenger enter the dungeon to challenge its inhabitant"
				+ ", but who is it mysterious character who seeks fame, fortune or knowledge:\n");
		Hero hero = null;
		boolean noHeroChosen = true;
		Integer inputUser;
		String playerName;

		while (noHeroChosen) {

			System.out.println("Choose your hero :\n" + "1) Warrior\n" + "2) Thieft\n" + "3) Mage\n");
			inputUser = Integer.valueOf(Scan.scan.nextLine());

			switch (inputUser) {
			case 1:
				System.out.println("The hero was a proud warrior, known for strenght and toughness, named :");
				playerName = Scan.scan.nextLine();
				hero = new Warrior(playerName);
				noHeroChosen = false;
				break;
			case 2:
				System.out.println("The hero was a cunning Thief, known for agility and nimbleness, named :");
				playerName = Scan.scan.nextLine();
				hero = new Thief(playerName);
				noHeroChosen = false;
				break;
			case 3:
				System.out.println("The hero was a wise mage, known for intelligence and magical prowess, named :");
				playerName = Scan.scan.nextLine();
				hero = new Mage(playerName);
				noHeroChosen = false;
				break;
			default:
				System.out.println("Wrong input, input must be 1, 2 or 3");
			}
		}

		return hero;
	}

	public static String getActionType(Character character) {
		String inputUser;
		String actionChosen = null;
		boolean noActionSelected = true;

		while (noActionSelected) {

			System.out.println(
					"Choose " + character.getName() + " actions :\n" + "1) physical attack\n" + "2) magical attack\n");

			inputUser = Scan.scan.nextLine();

			switch (inputUser) {
			case "1":
				actionChosen = "attack_physical";
				noActionSelected = false;
				break;
			case "2":
				actionChosen = "attack_magical";
				noActionSelected = false;
				break;
			default:
				System.out.println("Wrong input, input must be 1 or 2");
			}
		}
		return actionChosen;
	}

	public static void waitForUser() {
		System.out.print("Press a key to continue : ");
		Scan.scan.nextLine();
		System.out.print("\n");
	}

	public static void endEncounter(Game game) {
		String inputUser;
		boolean noActionSelected = true;

		while (noActionSelected) {

			System.out.print("What would you like to do now?\n" + "1) Take a short rest (save your progress)\n"
					+ "2) Continue your journey");

			inputUser = Scan.scan.nextLine();

			switch (inputUser) {
			case "1":
				IOSerialization.saveGame(game);
				System.out.println(
						"This short rest steels your resolve, you start moving again to face what destiny has in wait for you");
				noActionSelected = false;
				break;
			case "2":
				System.out.println("You push forward on your path");
				noActionSelected = false;
				break;
			default:
				System.out.println("Wrong input, input must be 1 or 2");
			}
		}

	}

	public static String getFilePath() {
		String fileName = null;
		String inputUser;
		boolean noActionSelected = true;

		while (noActionSelected) {

			System.out.println("Your game is in?\n" + "1) Default location\n" + "2) Input your location");

			inputUser = Scan.scan.nextLine();

			switch (inputUser) {
			case "1":
				fileName = IOSerialization.fileNameSaveDefault;
				noActionSelected = false;
				break;
			case "2":
				System.out.println("Input a path for save file : ");
				fileName = Scan.scan.nextLine();
				noActionSelected = false;
				break;
			default:
				System.out.println("Wrong input, input must be 1 or 2");
			}
		}
		return fileName;
	}

}
