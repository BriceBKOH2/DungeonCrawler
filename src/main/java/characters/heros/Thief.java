package characters.heros;

public class Thief extends Hero{
	
	
	/* Constructors */
	
	
	public Thief(String name) {
		level = 1;
		this.name = name;
		type = "Thief";	
		experience = 0;
		// nextLevelUp = 10 by default in hero super class
		
		strength = 8;
		intellect = 10;
		agility = 8;
		
		maxHealth = 250;
		health = maxHealth;
	}
	
	
	public Thief(String name, long experience) {
		level = 1;
		this.name = name;
		type = "Thief";	
		this.experience = 0;
		// nextLevelUp = 10 by default in hero super class
		
		strength = 8;
		intellect = 10;
		agility = 8;
		
		maxHealth = 250;
		health = maxHealth;
		this.gainExperience(experience);
	}
	
		/* Inherited by CharacterMechanics interface */
	
	
	@Override
	public void levelUp() {
		level++;
		strength += 2;
		intellect += 2;
		agility += 3;
		
		int increaseHealth = maxHealth * 8 / 100;
		maxHealth += increaseHealth;
		this.setHealth(health += increaseHealth);
	}
	
	
}
