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

	// If not taken into account in the method it can "heal" the character
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
		assertEquals(true, character.hurt(character.getHealth() + 10));
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

	/* public boolean hit_physical(Character target) */

	// Null paramater

	@Test(expected = NullPointerException.class)
	public void hit_physical_NullParam() {
		character.hit_physical(null);
	}

	// Correct Result

	@Test
	public void hit_physical_ReturnFalse() {
		PowerMockito.mockStatic(DiceRandom.class);
		Mockito.when(DiceRandom.d100()).thenReturn(100);
		assertEquals(false, character.hit_physical(character));
	}

	@Test
	public void hit_physical_ReturnFalseBarelyMissed() {
		PowerMockito.mockStatic(DiceRandom.class);
		Mockito.when(DiceRandom.d100()).thenReturn(71);
		assertEquals(false, character.hit_physical(character));
	}

	@Test
	public void hit_physical_ReturnTrueBarelyHit() {
		PowerMockito.mockStatic(DiceRandom.class);
		Mockito.when(DiceRandom.d100()).thenReturn(70);
		assertEquals(true, character.hit_physical(character));
	}

	@Test
	public void hit_physical_ReturnTrue() {
		PowerMockito.mockStatic(DiceRandom.class);
		Mockito.when(DiceRandom.d100()).thenReturn(1);
		assertEquals(true, character.hit_physical(character));
	}

	/* public float hit_score_physical(Character target) */

	// Null Parameter

	@Test(expected = NullPointerException.class)
	public void hit_score_physical_NullParameter() {
		character.hit_score_physical(null);
	}

	// Return Value

	@Test
	public void hit_score_physical_ReturnNegativeValue() {
		Character target = new Character(100, "MegaBoss", "MegaBoss", 200, 200, 200);
		float attack_hit_rate = 0.7f;
		assertEquals(
				attack_hit_rate + (character.getLevel() - target.getLevel()) * 0.1f
						+ (character.getAgility() - target.getAgility()) * 0.05f,
				character.hit_score_physical(target), 0.1);
	}

	@Test
	public void hit_score_physical_ReturnCorrectValue() {
		Character target = new Character(1, "RegularMinion", "Minion", 3, 3, 3);
		float attack_hit_rate = 0.7f;
		assertEquals(
				attack_hit_rate + (character.getLevel() - target.getLevel()) * 0.1f
						+ (character.getAgility() - target.getAgility()) * 0.05f,
				character.hit_score_physical(target), 0.1);
	}

	/* public boolean hit_magical(Character target) */

	// Null Parameter

	@Test(expected = NullPointerException.class)
	public void hit_magical_NullParam() {
		character.hit_magical(null);
	}

	// Correct Result

	@Test
	public void hit_magical_ReturnFalse() {
		PowerMockito.mockStatic(DiceRandom.class);
		Mockito.when(DiceRandom.d100()).thenReturn(100);
		assertEquals(false, character.hit_magical(character));
	}

	@Test
	public void hit_magical_ReturnFalseBarelyMissed() {
		PowerMockito.mockStatic(DiceRandom.class);
		Mockito.when(DiceRandom.d100()).thenReturn(91);
		assertEquals(false, character.hit_magical(character));
	}

	@Test
	public void hit_magical_ReturnTrueBarelyHit() {
		PowerMockito.mockStatic(DiceRandom.class);
		Mockito.when(DiceRandom.d100()).thenReturn(90);
		assertEquals(true, character.hit_magical(character));
	}

	@Test
	public void hit_magical_ReturnTrue() {
		PowerMockito.mockStatic(DiceRandom.class);
		Mockito.when(DiceRandom.d100()).thenReturn(1);
		assertEquals(true, character.hit_magical(character));
	}

	/* public float hit_score_magical(Character target) */

	// Null Parameter

	@Test(expected = NullPointerException.class)
	public void hit_score_magical_NullParameter() {
		character.hit_score_physical(null);
	}

	// Return Value

	@Test
	public void hit_score_magical_ReturnNegativeValue() {
		Character target = new Character(100, "MegaBoss", "MegaBoss", 200, 200, 200);
		float attack_hit_rate = 0.9f;
		assertEquals(
				attack_hit_rate + (character.getLevel() - target.getLevel()) * 0.1f
						+ (character.getAgility() - target.getAgility()) * 0.05f,
				character.hit_score_magical(target), 0.1);
	}

	@Test
	public void hit_score_magical_ReturnCorrectValue() {
		Character target = new Character(1, "RegularMinion", "Minion", 3, 3, 3);
		float attack_hit_rate = 0.9f;
		assertEquals(
				attack_hit_rate + (character.getLevel() - target.getLevel()) * 0.1f
						+ (character.getAgility() - target.getAgility()) * 0.05f,
				character.hit_score_magical(target), 0.1);
	}

}
