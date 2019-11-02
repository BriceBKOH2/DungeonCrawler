package characters;

import static utils.DiceRandom.*;

import utils.DiceRandom;

public class Character implements CharacterMechanicsInterface {

	/* Attributes */

	/**
	 * Measure the power of the character, increase in level means increase in
	 * character's stats and health.
	 */
	protected int level;
	/** Name of the character */
	protected String name;
	/**
	 * Type of the character, determines starting stats and lvl up stats increase,
	 * ... .
	 */
	protected String type;
	/**
	 * The amount determines what level the character is, each level up increase the
	 * amount needed by 10%.
	 */
	protected long experience;

	// Basic statistics (stats)

	/** Influence physical damage. */
	protected int strength;
	/** Influence magical damage. */
	protected int intellect;
	/** Influence hit chance and dodge chance. */
	protected int agility;

	// Health

	/** Max value the health can get too (in case of healing) */
	protected int maxHealth;
	/**
	 * Health Point : 0 or bellow = death = end of combat; (end of game if its a
	 * Playable Character(PC), reward if this a Non Playable Character (NPC =>
	 * monster, ...) IMPORTANT : Always use setHealth to change Health value so
	 * health doesnt go above max_healt
	 */
	protected int health;

	/* Constructors */

	public Character() {
		level = 1;
		name = "empty";
		type = "character without type";
		experience = 0;

		strength = 3;
		intellect = 3;
		agility = 3;

		maxHealth = 100;
		health = maxHealth;
	}

	public Character(String name) {
		level = 1;
		this.name = name;
		type = "character without type";
		experience = 0;

		strength = 3;
		intellect = 3;
		agility = 3;

		maxHealth = 100;
		health = maxHealth;
	}

	public Character(String name, int level) {
		this.level = 1;
		this.name = name;
		type = "character without type";
		experience = 0;

		strength = 3;
		intellect = 3;
		agility = 3;

		maxHealth = 100;
		health = maxHealth;

		for (int i = 1; i < level; i++) {
			this.levelUp();
		}
	}

	public Character(String name, int level, long experience) {
		this.level = 1;
		this.name = name;
		type = "character without type";
		this.experience = experience;

		strength = 3;
		intellect = 3;
		agility = 3;

		maxHealth = 100;
		health = maxHealth;

		for (int i = 1; i < level; i++) {
			this.levelUp();
		}
	}

	public Character(String name, String type) {
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

	public Character(int level, String name, String type, int strength, int intellect, int agility) {
		this.level = 1;
		this.name = name;
		this.type = type;
		experience = 0;

		this.strength = strength;
		this.intellect = intellect;
		this.agility = agility;

		maxHealth = 100;
		health = maxHealth;

		for (int i = 1; i < level; i++) {
			this.levelUp();
		}
	}

	public Character(int level, String name, String type, long experience, int strength, int intellect, int agility) {
		this.level = level;
		this.name = name;
		this.type = type;
		this.experience = experience;

		this.strength = strength;
		this.intellect = intellect;
		this.agility = agility;

		maxHealth = 100;
		health = maxHealth;

		for (int i = 0; i < level; i++) {
			this.levelUp();
		}
	}

	/* Methods */

	/* Getters */

	public int getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public long getExperience() {
		return experience;
	}

	public int getStrength() {
		return strength;
	}

	public int getIntellect() {
		return intellect;
	}

	public int getAgility() {
		return agility;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getHealth() {
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

	/**
	 * setHealth checks if the new value doesn't exceed maxHealth, if it does it set
	 * health = maxHealth to avoid problems (either bugs or "cheats / cheesing"
	 */
	protected void setHealth(int health) {
		if (health > maxHealth) {
			this.health = maxHealth;
		} else {
			this.health = health;
		}

	}

	/* Inherited by CharacterMechanics interface */

	@Override
	public void levelUp() {
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

	@Override
	public boolean hit_physical(Character target) {
		if (DiceRandom.d100() <= this.hit_score_physical(target) * 100) {
			return true;
		} else
			return false;
	}

	@Override
	public float hit_score_physical(Character target) {
		float attack_hit_rate = 0.7f;
		return (attack_hit_rate + (this.getLevel() - target.getLevel()) * 0.1f
				+ (this.getAgility() - target.getAgility()) * 0.05f);
	}

	@Override
	public boolean hit_magical(Character target) {
		if (DiceRandom.d100() <= this.hit_score_magical(target) * 100) {
			return true;
		} else
			return false;
	}

	@Override
	public float hit_score_magical(Character target) {
		float attack_hit_rate = 0.9f;
		return (attack_hit_rate + (this.getLevel() - target.getLevel()) * 0.1f
				+ (this.getAgility() - target.getAgility()) * 0.05f);
	}

	/* Others */

	@Override
	public String toString() {
		return type + " : " + name + " [level=" + level + ", experience=" + experience + ", strength=" + strength
				+ ", intellect=" + intellect + ", agility=" + agility + ", Health (" + health + " / " + maxHealth
				+ ") ]";
	}

}
