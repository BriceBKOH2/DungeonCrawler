package characters.heros;

import static org.junit.Assert.*;

import org.junit.*;

public class HeroTest {
	
	private Hero hero;
	
	
	@Before
	public void init() {
		hero = new Hero();
	}
	
	
	/* public void reward(long experienceReward) */
	
	
		// Negative Parameters
	
	
	@Test
	public void reward_NegativeParameters() {
		long experience = hero.getExperience();
		hero.reward(-10);
		assertEquals(experience,hero.getExperience());
	}
	
	
		// Correct Result
	
	
	@Test
	public void reward_CorrectExperience() {
		long experience = hero.getExperience();
		hero.reward(5);
		assertEquals(experience + 5,hero.getExperience());
	}

	
	
		// Leveling up properly
	
	
	@Test
	public void reward_CorrectLevelUp() {
		int level = hero.getLevel();
		hero.reward(10);
		assertEquals(level + 1,hero.getLevel());
	}


	@Test
	public void reward_CorrectLevelUpMultiple() {
		int level = hero.getLevel();
		hero.reward(25);
		assertEquals(level + 2,hero.getLevel());
	}
	
	

	
}
