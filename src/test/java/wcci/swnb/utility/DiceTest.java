package wcci.swnb.utility;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiceTest {

	@Test
	public void shouldThrowExceptionForInvalidDiceString()
		{
		int result = Dice.roll("this is an invalid string");
		assertEquals(-1, result);
		}

	@Test
	public void shouldRoll2d4()
		{
		// Arrange
		int diceCount = 2;
		int sidesPerDie = 4;
		String diceToRoll = diceCount + Dice.DICE_TOKENIZER + sidesPerDie;

		// Action
		int result = Dice.roll(diceToRoll);
		System.out.println(diceToRoll + " = " + result);

		// Assert
		int lowerBound = diceCount * 1;
		int upperBound = diceCount * sidesPerDie;
		assertResultIsWithinRange(result, lowerBound, upperBound);
		}

	private static void assertResultIsWithinRange(int result, int lowerBound, int upperBound)
		{
		assertThat(result, greaterThanOrEqualTo(lowerBound));
		assertThat(result, lessThanOrEqualTo(upperBound));
		}
}
