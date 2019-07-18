package wcci.swnb.utility;

import java.util.Random;

public class Dice {

	public static final String DICE_TOKENIZER = "d";

	private static Random random = new Random(System.nanoTime());

	private Dice()
		{
		}

	public static int roll(String diceToRoll)
		{
		String[] tokens = diceToRoll.split(DICE_TOKENIZER);
		int diceCount = 0;
		int sidesPerDie = 0;
		try
			{
			diceCount = Integer.parseInt(tokens[0]);
			sidesPerDie = Integer.parseInt(tokens[1]);
			}
		catch (Exception ex)
			{
			System.out.println("\"" + diceToRoll + "\" is not a valid dice string. \nString should follow the format X" + DICE_TOKENIZER + "Y where X and Y are integers representing the number of dice and the sides per die respectively.");
			return -1;
			}
		return rollXDiceWithYSides(diceCount, sidesPerDie);
		}

	public static int rollXDiceWithYSides(int diceCount, int sidesPerDie)
		{
		int total = 0;

		for (int i = 0; i < diceCount; i++)
			{
			total += 1 + random.nextInt(sidesPerDie);
			}
		return total;
		}

}
