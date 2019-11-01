package characters;

public interface CharacterMechanics {
	
	
	/** Methods that increase the character stats and health based on its type */
	void levelUp();
	
	
	/** Methods that decrease the health of the character, return true if the character health gets at 0 or below, false otherwise */
	boolean hurt(int damage);
	
	
	/** Methods to return an int damage base on character strength stat added to the result of a random int between 1 and 12 (d12) */
	int attack_physical();
	
	
	/** Methods to return an int damage base on character strength stat added to the result of a random int between 1 and 12 (d12) and the modifier */
	default int attack_physical(int modifier) {
		return this.attack_physical() + modifier;
	}
	
	
	/** Methods to return an int damage base on character intellect stat added to the result of a random int between 1 and 12 (d12) */
	int attack_magical();
	
	
	/** Methods to return an int damage base on character intellect stat added to the result of a random int between 1 and 12 (d12) and the modifier */
	default int attack_magical(int modifier) {
		return this.attack_magical() + modifier;
	}
	
	
}
