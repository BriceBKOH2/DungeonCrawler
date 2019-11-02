package characters;

public interface CharacterMechanicsInterface {
	
	
	/** Methods that increase the character stats and health based on its type */
	void levelUp();
	
	
	/** Methods that return if true if the target is hit */
	boolean hit_physical(Character target);
	
	
	/** Methods that return if true if the target is hit */
	boolean hit_magical(Character target);
	
	
	/** Methods that return an int based on the character's stats*/
	float hit_score_physical(Character target);
	
	
	/** Methods that return an int based on the character's stats*/
	float hit_score_magical(Character target);
	
	
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
