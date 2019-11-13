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
		return new Game();
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
		Integer inputUser = 0;
		String actionChosen = null;
		boolean noActionSelected = true;
		boolean validInput = true;
		
		while (noActionSelected) {

			System.out.println("Choose " + character.getName() + " actions :\n"
					+ "1) physical attack\n"
					+ "2) magical attack\n");
			
			do{
		        if(Scan.scan.hasNextInt()){ // This checks to see if the next input is a valid **int**
		            inputUser = Scan.scan.nextInt();
		            validInput = true;
		        }
		        else{
		            System.out.print("Not a valid integer!\n");
		            Scan.scan.next();
		        }
		    }while(validInput == false);
			
			switch (inputUser) {
			case 1:
				actionChosen = "attack_physical";
				noActionSelected = false;
				break;
			case 2:
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
		
	}

	  static String getSaveFile() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
