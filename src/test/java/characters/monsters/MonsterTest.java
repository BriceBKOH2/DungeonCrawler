package characters.monsters;

import static org.junit.Assert.*;

import org.junit.*;

public class MonsterTest {

	private Monster monster;
	
	
	@Before
	public void init() {
		monster = new Monster("Test");
	}
	
	
	/* public void levelUp() */
	
	
		// Correct value changes
	
	
	@Test
	public void levelUp_CorrectLevel() {
		monster.levelUp();
		assertEquals(2, monster.getLevel());
	}
	
	
	@Test
	public void levelUp_CorrectExperience() {
		long experience = monster.getExperience();
		monster.levelUp();
		assertEquals(experience += experience * 5 / 10, monster.getExperience());
	}
	
	
	@Test
	public void levelUp_CorrectHealth() {
		int maxHealth = monster.getHealth();
		monster.levelUp();
		assertEquals((int) (maxHealth += maxHealth / 10), monster.getHealth());
	}
	
	
	@Test
	public void levelUp_CorrectMaxHealth() {
		int maxHealth = monster.getMaxHealth();
		monster.levelUp();
		assertEquals((int) (maxHealth += maxHealth / 10), monster.getMaxHealth());
	}
	
	
	@Test
	public void levelUp_CorrectStrength() {
		int strength = monster.getStrength();
		monster.levelUp();
		assertEquals(strength + 2, monster.getStrength());
	}
	
	
	@Test
	public void levelUp_CorrectAgility() {
		int agility = monster.getAgility();
		monster.levelUp();
		assertEquals(agility + 2, monster.getAgility());
	}
	
	
	@Test
	public void levelUp_CorrectIntellect() {
		int intellect = monster.getIntellect();
		monster.levelUp();
		assertEquals(intellect + 2, monster.getIntellect());
	}

}
