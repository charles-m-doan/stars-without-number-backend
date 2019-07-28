package wcci.swnb.utility;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.junit.Test;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import wcci.swnb.entities.PlayerCharacter;
import wcci.swnb.entities.factories.PlayerCharacterFactory;

public class PlayerCharacterFactoryTest {

	private static final Random RANDOM = new Random(System.nanoTime());
	private static final Lorem LOREM = LoremIpsum.getInstance();

	private static final boolean INCLUDE_OUTPUT = false;
	private static final int LEVELS_TO_LIST = 25;

	@Test
	public void listXPTableForFirstXLevels()
		{
		if (!INCLUDE_OUTPUT)
			{
			return;
			}
		int x = LEVELS_TO_LIST;
		System.out.println("--------------------------------");
		System.out.println("XP TABLE");
		System.out.println("--------------------------------");
		for (int i = 1; i <= x; i++)
			{
			int level = i;
			int xpNeededForNextLevel = PlayerCharacterFactory.getBaseXPNeededToAttainLevelFromPrevious(level + 1);
			int totalXPNeededToAttainLevel = PlayerCharacterFactory.getXPForGivenLevel(level);
			System.out.println("Lvl: " + i + ", Total: " + totalXPNeededToAttainLevel);
			System.out.println("    (XP for Next: " + xpNeededForNextLevel + ")");
			}
		}

	@Test
	public void levelShouldIncreaseBy3AfterAdding21XPTo0XP()
		{
		PlayerCharacter underTest = new PlayerCharacter(LOREM.getFirstName());
		int levelBefore = underTest.getLevel();

		PlayerCharacterFactory.addExperienceToPlayerCharacter(underTest, 21);
		int levelAfter = underTest.getLevel();
		int difference = (levelAfter - levelBefore);

		assertEquals(3, difference);
		}

	@Test
	public void levelShouldIncreaseOrRemainUnchangedAfterAddingXP()
		{
		PlayerCharacter underTest = new PlayerCharacter(LOREM.getFirstName());

		for (int i = 1; i <= 50; i += 3)
			{
			int xpToAdd = 1 + RANDOM.nextInt(i);

			int xpBefore = underTest.getExperience();
			int levelBefore = underTest.getLevel();

			PlayerCharacterFactory.addExperienceToPlayerCharacter(underTest, xpToAdd);

			int xpAfter = underTest.getExperience();
			int levelAfter = underTest.getLevel();

			if (INCLUDE_OUTPUT)
				{
				String before = "Before[Xp:" + xpBefore + ", Lvl:" + levelBefore + "]";
				String addition = " + " + xpToAdd + " exp = ";
				String after = "After[Xp:" + xpAfter + ", Lvl:" + levelAfter + "]";
				String levelsGained = " -> " + (levelAfter - levelBefore) + " levels gained.";
				System.out.println(underTest.getName() + " - " + before + addition + after + levelsGained);
				}

			assertThat(levelAfter, greaterThanOrEqualTo(levelBefore));
			}
		}

	@Test
	public void shouldReturn12ForLevel4()
		{
		int xpNeeded = PlayerCharacterFactory.getBaseXPNeededToAttainLevelFromPrevious(4);
		assertEquals(12, xpNeeded);
		}

	@Test
	public void shouldReturn72ForLevel9()
		{
		int xpNeeded = PlayerCharacterFactory.getBaseXPNeededToAttainLevelFromPrevious(9);
		assertEquals(72, xpNeeded);
		}

	@Test
	public void shouldReturn261ForLevel17()
		{
		int xpNeeded = PlayerCharacterFactory.getBaseXPNeededToAttainLevelFromPrevious(17);
		assertEquals(261, xpNeeded);
		}

	@Test
	public void shouldReturnLevel13For747XP()
		{
		int experience = 747;
		int level = PlayerCharacterFactory.getLevelForGivenXP(experience);
		assertEquals(13, level);
		}

	@Test
	public void shouldReturn747ForLevel13()
		{
		int level = 13;
		int experience = PlayerCharacterFactory.getXPForGivenLevel(level);
		assertEquals(747, experience);
		}
}
