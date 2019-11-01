package characters.heros;

import static org.junit.Assert.*;

import org.junit.*;

public class MageTest {

	private Mage mage;

	
	@Before
	public void init() {
		mage = new Mage("Test");
	}


	/* public void levelUp() */

	
		// Correct value changes

	
	@Test
	public void levelup_CorrectLevel() {
		mage.levelUp();
		assertEquals(2, mage.getLevel());
	}
	

	@Test
	public void levelup_CorrectHealth() {
		int maxHealth = mage.getHealth();
		mage.levelUp();
		assertEquals((int) (maxHealth += maxHealth * 6 / 100), mage.getHealth());
	}

	
	@Test
	public void levelup_CorrectMaxHealth() {
		int maxHealth = mage.getMaxHealth();
		mage.levelUp();
		assertEquals((int) (maxHealth += maxHealth * 6 / 100), mage.getMaxHealth());
	}

	
	@Test
	public void levelup_CorrectStrength() {
		int strength = mage.getStrength();
		mage.levelUp();
		assertEquals(strength + 2, mage.getStrength());
	}

	
	@Test
	public void levelup_CorrectAgility() {
		int agility = mage.getAgility();
		mage.levelUp();
		assertEquals(agility + 1, mage.getAgility());
	}

	
	@Test
	public void levelup_CorrectIntellect() {
		int intellect = mage.getIntellect();
		mage.levelUp();
		assertEquals(intellect + 5, mage.getIntellect());
	}

}
