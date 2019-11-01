package characters.heros;

import characters.Character;

public class Hero extends Character implements HeroMechanicsInterface{
	
	/* Attributes */
	/** Represent the threshold to reach with experience to level up a character, increase by 10% by each level up. */
	protected long nextLevelUp = 10;

	
	/* Constructors */
	
	
	protected Hero() {
		level = 1;
		name = "empty";
		type = "hero";	
		experience = 0;
		
		strength = 8;
		intellect = 8;
		agility = 8;
		
		maxHealth = 250;
		health = maxHealth;
	}
	
	
	/* Methods */


		/* Getters */
	
	
	public long getNextLevelUp() {
		return nextLevelUp;
	}

	
		/* Setters */
	

	protected void setNextLevelUp(long nextLevelUp) {
		this.nextLevelUp = nextLevelUp;
	}
	
	
		/* Inherited by HeroMechanicsInterface */
	
	
	@Override
	public void reward(long experienceReward) {
		if (experienceReward >= 0) {
			experience += experienceReward;
			
			while (nextLevelUp <= experience) {
				this.levelUp();
				nextLevelUp *= 2.10;
			}
		}
	}

	
}
