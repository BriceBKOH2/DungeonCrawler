package characters.monsters;

import java.io.Serializable;

import characters.Character;

public class Monster extends Character implements Serializable {


	/* Constructor */
	
	private static final long serialVersionUID = 4775486264413816816L;


	public Monster() {
		level = 1;
		name = "Basic Monster";
		type = "Monster";	
		experience = 5;
		
		strength = 5;
		intellect = 5;
		agility = 5;
		
		maxHealth = 100;
		health = maxHealth;
	}
	
	
	public Monster(String name) {
		level = 1;
		this.name = name;
		type = "Monster";	
		experience = 5;
		
		strength = 5;
		intellect = 5;
		agility = 5;
		
		maxHealth = 100;
		health = maxHealth;
	}
	
	
	public Monster(String name, int level) {
		this.level = 1;
		this.name = name;
		type = "Monster";	
		experience = 5;
		
		strength = 5;
		intellect = 5;
		agility = 5;
		
		maxHealth = 100;
		health = maxHealth;
		
		for (int i = 1; i < level; i++) {
			this.levelUp();
		}
	}
	/* Methods */
	
	
	@Override
	public void levelUp() {
		level++;
		experience += experience * 5 / 10;  
		
		strength += 2;
		intellect += 2;
		agility += 2;
		
		
		int increaseHealth = maxHealth / 10;
		maxHealth += increaseHealth;
		this.setHealth(health += increaseHealth);
	}

}
