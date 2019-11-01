package characters;

import static org.junit.Assert.*;

import org.junit.*;
/* PowerMock import */
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import utils.DiceRandom;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DiceRandom.class)
public class CharacterTest {

	private Character character;
	
	
	@Before
	public void init() {
		character = new Character("Test");
	}
	
	
	/* public void levelUp() */
	
	
		// Correct value changes
	
	
	@Test
	public void levelup_CorrectLevel() {
		character.levelUp();
		assertEquals(2, character.getLevel());
	}
	
	
	
	@Test
	public void levelup_CorrectHealth() {
		int maxHealth = character.getHealth();
		character.levelUp();
		assertEquals((int) (maxHealth += maxHealth / 10), character.getHealth());
	}
	
	
	@Test
	public void levelup_CorrectMaxHealth() {
		int maxHealth = character.getMaxHealth();
		character.levelUp();
		assertEquals((int) (maxHealth += maxHealth / 10), character.getMaxHealth());
	}
	
	
	@Test
	public void levelup_CorrectStrength() {
		int strength = character.getStrength();
		character.levelUp();
		assertEquals(strength + 2, character.getStrength());
	}
	
	
	@Test
	public void levelup_CorrectAgility() {
		int agility = character.getAgility();
		character.levelUp();
		assertEquals(agility + 2, character.getAgility());
	}
	
	
	@Test
	public void levelup_CorrectIntellect() {
		int intellect = character.getIntellect();
		character.levelUp();
		assertEquals(intellect + 2, character.getIntellect());
	}
	
	
	/* public boolean hurt(int damage) */
	
	
		// Negative Parameter
	
	
	//If not taken into account in the method it can "heal" the character 
	@Test
	public void hurt_NegativeNumber() {
		int health = character.getHealth();
		character.hurt(-10);
		assertEquals(health, character.getHealth());
	}
	
	
		// Death (health 0 or bellow)
	
	
	@Test
	public void hurt_Health0() {
		assertEquals(true, character.hurt(character.getHealth()));
	}
	
	
	@Test
	public void hurt_HealthNegative() {
		assertEquals(true, character.hurt(character.getHealth()+10));
	}
	
	
		// Not Dead (health > 0)
	
	
	@Test
	public void hurt_HealthPositive() {
		assertEquals(false, character.hurt(1));
	}
	
	
		// Correct Result
	
	
	@Test
	public void hurt_CorrectResult() {
		int health = character.getHealth();
		character.hurt(10);
		assertEquals(health - 10, character.getHealth());
	}
	
	
	/* public int attack_physical() */
	
	
		// Correct Result
	
	@Test
	public void attack_physical_CorrectResult() {
		PowerMockito.mockStatic(DiceRandom.class);
		Mockito.when(DiceRandom.d12()).thenReturn(10);
		assertEquals(character.getStrength() + 10, character.attack_physical());
	}
	
	
	/* public int attack_magical() */
	
	
		// Correct Result

	@Test
	public void attack_magical_CorrectResult() {
		PowerMockito.mockStatic(DiceRandom.class);
		Mockito.when(DiceRandom.d12()).thenReturn(5);
		assertEquals(character.getIntellect() + 5, character.attack_magical());
	}
}
