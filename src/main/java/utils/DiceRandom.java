package utils;

import java.util.Random;

public class DiceRandom {
	
	/* Attributes */
	
	
	/** a static Random object used to generate random number in the DiceRandom methods */
	static Random dice = new Random();
	
	
	/* Constructors */
	
	
	/* Methods */
	
	
		// Others
	
	
	/** Methods to return a random int between 1 and 12 included */
	static public int d12() {
		return dice.nextInt(12)+1;
	}


	/** Methods to return a random int between 1 and 100 included */
	static public int d100() {
		return dice.nextInt(100)+1;
	}
	
	
}
