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
	public void levelUp_CorrectLevel() {
		mage.levelUp();
		assertEquals(2, mage.getLevel());
	}
	

	@Test
	public void levelUp_CorrectHealth() {
		int maxHealth = mage.getHealth();
		mage.levelUp();
		assertEquals((int) (maxHealth += maxHealth * 6 / 100), mage.getHealth());
	}

	
	@Test
	public void levelUp_CorrectMaxHealth() {
		int maxHealth = mage.getMaxHealth();
		mage.levelUp();
		assertEquals((int) (maxHealth += maxHealth * 6 / 100), mage.getMaxHealth());
	}

	
	@Test
	public void levelUp_CorrectStrength() {
		int strength = mage.getStrength();
		mage.levelUp();
		assertEquals(strength + 2, mage.getStrength());
	}

	
	@Test
	public void levelUp_CorrectAgility() {
		int agility = mage.getAgility();
		mage.levelUp();
		assertEquals(agility + 1, mage.getAgility());
	}

	
	@Test
	public void levelUp_CorrectIntellect() {
		int intellect = mage.getIntellect();
		mage.levelUp();
		assertEquals(intellect + 5, mage.getIntellect());
	}

}
