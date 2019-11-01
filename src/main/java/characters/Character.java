package characters;

import static utils.DiceRandom.*;

/* local */
import characters.interfacemechanics.CharacterMechanics;

public class Character implements CharacterMechanics{
	
	/* Attributes */
	
	
	/** Measure the power of the character, increase in level means increase in character's stats and health. */
	private int level;
	/** Name of the character */
	private String name;
	/** Type of the character, determines starting stats and lvl up stats increase, ... . */
	private String type;
	/** The amount determines what level the character is, each level up increase the amount needed by 10%. */
	private long experience;
	
	
		// Basic statistics (stats)
	
	
	/** Influence physical damage.*/
	private int strength;
	/** Influence magical damage.*/
	private int intellect;
	/** Influence hit chance and dodge chance. */
	private int agility;
	
	
		// Health
	
	
	/** Max value the health can get too (in case of healing) */
	private int maxHealth;
	/** Health Point : 0 or bellow = death = end of combat; (end of game if its a Playable Character(PC), reward if this a Non Playable Character (NPC => monster, ...) 
	 * IMPORTANT : Always use setHealth to change Health value so health doesnt go above max_healt */
	private int health;

	
	/* Constructors */
	
	
	protected Character(String name, String type) {
		level = 1;
		this.name = name;
		this.type = type;	
		experience = 0;
		
		strength = 3;
		intellect = 3;
		agility = 3;
		
		maxHealth = 100;
		health = maxHealth;
	}
	
	
	protected Character(int level, String name, String type, int strength, int intellect, int agility) {
		this.level = level;
		this.name = name;
		this.type = type;	
		experience = 0;
		
		this.strength = strength;
		this.intellect = intellect;
		this.agility = agility;
		
		maxHealth = 100;
		health = maxHealth;
	}

	
	protected Character(int level, String name, String type, long experience, int strength, int intellect, int agility) {
		this.level = level;
		this.name = name;
		this.type = type;	
		this.experience = experience;
		
		this.strength = strength;
		this.intellect = intellect ;
		this.agility = agility;
		
		maxHealth = 100;
		health = maxHealth;
		
		for (int i = 0; i < level; i++) {
			this.levelup();
		}
	}
	
	
	/* Methods */

	
		/* Getters */
	

	protected int getLevel() {
		return level;
	}


	protected String getName() {
		return name;
	}

	
	protected String getType() {
		return type;
	}


	protected long getExperience() {
		return experience;
	}
	
	
	protected int getStrength() {
		return strength;
	}


	protected int getIntellect() {
		return intellect;
	}

	
	protected int getAgility() {
		return agility;
	}


	protected int getMaxHealth() {
		return maxHealth;
	}


	protected int getHealth() {
		return health;
	}


		/* Setters */


	protected void setLevel(int level) {
		this.level = level;
	}
	
	
	protected void setName(String name) {
		this.name = name;
	}


	protected void setType(String type) {
		this.type = type;
	}
	
	
	protected void setExperience(long experience) {
		this.experience = experience;
	}


	protected void setStrength(int strength) {
		this.strength = strength;
	}
	

	protected void setIntellect(int intellect) {
		this.intellect = intellect;
	}


	protected void setAgility(int agility) {
		this.agility = agility;
	}


	protected void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/** setHealth checks if the new value doesn't exceed maxHealth, if it does it set health = maxHealth to avoid problems (either bugs or "cheats / cheesing" */
	protected void setHealth(int health) {
		if (health > maxHealth) {
			this.health = maxHealth;
		} else {
			this.health = health;
		}
		
	}

	
	/* Inherited by CharacterMechanics interface */
	
	
	@Override
	public void levelup() {
		level++;
		strength += 2;
		intellect += 2;
		agility += 2;
		
		int increaseHealth = maxHealth / 10;
		maxHealth += increaseHealth;
		this.setHealth(health += increaseHealth);
	}

	
	@Override
	public boolean hurt(int damage) {
		if (damage > 0) {
			this.setHealth(health -= damage);
		}
		
		return health <= 0 ? true : false;
	}


	
	@Override
	public int attack_physical() {
		return strength + d12();
	}


	@Override
	public int attack_magical() {
		return intellect + d12();
	}
	
	
	/* Others */

	
	
}
