package characters.heros;

public class Warrior extends Hero{
	
	
	/* Constructors */
	
	
	public Warrior(String name) {
		level = 1;
		this.name = name;
		type = "Warrior";	
		experience = 0;
		// nextLevelUp = 10 by default in hero super class

		strength = 10;
		intellect = 6;
		agility = 8;
		
		maxHealth = 300;
		health = maxHealth;
	}
	
	
	public Warrior(String name, long experience) {
		level = 1;
		this.name = name;
		type = "Warrior";	
		this.experience = 0;
		// nextLevelUp = 10 by default in hero super class
		
		strength = 10;
		intellect = 6;
		agility = 8;
		
		maxHealth = 300;
		health = maxHealth;
		this.gainExperience(experience);
	}
	
	/* Methods */
	
	
	
		/* Inherited by CharacterMechanics interface */
	
	
	@Override
	public void levelUp() {
		level++;
		strength += 4;
		intellect += 1;
		agility += 1;
		
		int increaseHealth = maxHealth / 10;
		maxHealth += increaseHealth;
		this.setHealth(health += increaseHealth);
	}
	
	
}
