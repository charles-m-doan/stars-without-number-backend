package wcci.swnb.utility;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import wcci.swnb.entities.factories.PlayerCharacterFactory;

public class PlayerCharacterFactoryTest {

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
