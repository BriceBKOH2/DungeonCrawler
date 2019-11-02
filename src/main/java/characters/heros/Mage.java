package characters.heros;

public class Mage extends Hero{
	
	
	/* Constructors */
	
	
	public Mage(String name) {
		level = 1;
		this.name = name;
		type = "Mage";	
		experience = 0;
		// nextLevelUp = 10 by default in hero super class
		
		strength = 6;
		intellect = 10;
		agility = 6;
		
		maxHealth = 200;
		health = maxHealth;
	}
	
	
	public Mage(String name, long experience) {
		level = 1;
		this.name = name;
		type = "Mage";	
		this.experience = 0;
		// nextLevelUp = 10 by default in hero super class
		
		strength = 6;
		intellect = 10;
		agility = 6;
		
		maxHealth = 200;
		health = maxHealth;
		this.gainExperience(experience);
	}
	
	
		/* Inherited by CharacterMechanics interface */
	
	
	@Override
	public void levelUp() {
		level++;
		strength += 2;
		intellect += 5;
		agility += 1;
		
		int increaseHealth = maxHealth * 6 / 100;
		maxHealth += increaseHealth;
		this.setHealth(health += increaseHealth);
	}
	
	
}
