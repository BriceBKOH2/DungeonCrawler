package characters.heros;

import static org.junit.Assert.*;

import org.junit.*;

public class ThiefTest {

	private Thief thief;

	
	@Before
	public void init() {
		thief = new Thief("Test");
	}


	/* public void levelUp() */

	
		// Correct value changes

	
	@Test
	public void levelup_CorrectLevel() {
		thief.levelUp();
		assertEquals(2, thief.getLevel());
	}
	

	@Test
	public void levelup_CorrectHealth() {
		int maxHealth = thief.getHealth();
		thief.levelUp();
		assertEquals((int) (maxHealth * 1.08), thief.getHealth());
	}

	
	@Test
	public void levelup_CorrectMaxHealth() {
		int maxHealth = thief.getMaxHealth();
		thief.levelUp();
		assertEquals((int) (maxHealth * 1.08f), thief.getMaxHealth());
	}

	
	@Test
	public void levelup_CorrectStrength() {
		int strength = thief.getStrength();
		thief.levelUp();
		assertEquals(strength + 2, thief.getStrength());
	}

	
	@Test
	public void levelup_CorrectAgility() {
		int agility = thief.getAgility();
		thief.levelUp();
		assertEquals(agility + 3, thief.getAgility());
	}

	
	@Test
	public void levelup_CorrectIntellect() {
		int intellect = thief.getIntellect();
		thief.levelUp();
		assertEquals(intellect + 2, thief.getIntellect());
	}
}
