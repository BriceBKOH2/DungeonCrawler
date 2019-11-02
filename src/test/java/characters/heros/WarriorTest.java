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
	public void levelUp_CorrectLevel() {
		warrior.levelUp();
		assertEquals(2, warrior.getLevel());
	}
	
	
	
	@Test
	public void levelUp_CorrectHealth() {
		int maxHealth = warrior.getHealth();
		warrior.levelUp();
		assertEquals((int) (maxHealth += maxHealth / 10), warrior.getHealth());
	}
	
	
	@Test
	public void levelUp_CorrectMaxHealth() {
		int maxHealth = warrior.getMaxHealth();
		warrior.levelUp();
		assertEquals((int) (maxHealth += maxHealth / 10), warrior.getMaxHealth());
	}
	
	
	@Test
	public void levelUp_CorrectStrength() {
		int strength = warrior.getStrength();
		warrior.levelUp();
		assertEquals(strength + 4, warrior.getStrength());
	}
	
	
	@Test
	public void levelUp_CorrectAgility() {
		int agility = warrior.getAgility();
		warrior.levelUp();
		assertEquals(agility + 1, warrior.getAgility());
	}
	
	
	@Test
	public void levelUp_CorrectIntellect() {
		int intellect = warrior.getIntellect();
		warrior.levelUp();
		assertEquals(intellect + 1, warrior.getIntellect());
	}
}
