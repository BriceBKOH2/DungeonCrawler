package utils;

public class UserInterface {

	/* Methods */

	/* Others */

	public static void homeStart() {
		System.out.print("Welcome to DungeonCrawler , input a corresponding number to access :\n" 
				+ "1) New game\n"
				+ "2) Load existing game\n"
				+ "3) Exit\n");
		Integer inputUser = Integer.valueOf(Scan.scan.nextLine());
		switch (inputUser) {
		case 1:
			UserInterface.newGame();
			break;
		case 2:
			UserInterface.loadGame();
			break;
		default:
			System.out.println("Thank you for using our services, goodbye !");
		}
		return;
	}
	
	public static void newGame () {
		System.out.print("A new challenger enter the dungeon to challenge its inhabitant"
				+ ", but who is it mysterious character who seeks fame, fortune or knowledge:\n" 
				+ "1) Warrior\n"
				+ "2) Thieft\n"
				+ "3) Mage\n");
	}
	
	public static void loadGame() {
		
	}
}
