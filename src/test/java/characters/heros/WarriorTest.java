package characters.heros;

import static org.junit.Assert.*;

import org.junit.*;

public class WarriorTest {

	private Warrior warrior;
	
	
	@Before
	public void init() {
		warrior = new Warrior("Test");
	}
	
	
	/* public void levelUp() */
	
	
		// Correct value changes
	
	
	@Test
	public void levelup_CorrectLevel() {
		warrior.levelUp();
		assertEquals(2, warrior.getLevel());
	}
	
	
	
	@Test
	public void levelup_CorrectHealth() {
		int maxHealth = warrior.getHealth();
		warrior.levelUp();
		assertEquals((int) (maxHealth += maxHealth / 10), warrior.getHealth());
	}
	
	
	@Test
	public void levelup_CorrectMaxHealth() {
		int maxHealth = warrior.getMaxHealth();
		warrior.levelUp();
		assertEquals((int) (maxHealth += maxHealth / 10), warrior.getMaxHealth());
	}
	
	
	@Test
	public void levelup_CorrectStrength() {
		int strength = warrior.getStrength();
		warrior.levelUp();
		assertEquals(strength + 4, warrior.getStrength());
	}
	
	
	@Test
	public void levelup_CorrectAgility() {
		int agility = warrior.getAgility();
		warrior.levelUp();
		assertEquals(agility + 1, warrior.getAgility());
	}
	
	
	@Test
	public void levelup_CorrectIntellect() {
		int intellect = warrior.getIntellect();
		warrior.levelUp();
		assertEquals(intellect + 1, warrior.getIntellect());
	}
}
