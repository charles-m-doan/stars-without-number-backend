package wcci.swnb.entities.factories;

import wcci.swnb.entities.Career;
import wcci.swnb.entities.PlayerCharacter;
import wcci.swnb.utility.Dice;

public class CareerFactory {

	public static final int WARRIOR = 0;
	public static final int EXPERT = 1;
	public static final int PSYCHIC = 2;
	public static final int WARRIOR_EXPERT = 3;
	public static final int PSYCHIC_EXPERT = 4;
	public static final int PSYCHIC_WARRIOR = 5;

	public static final String[] CAREER_NAMES = { "Warrior", "Expert", "Psychic", "Adventurer Warrior-Expert", "Adventurer Psychic-Expert", "Adventurer Psychic-Warrior" };
	public static final String UNSPECIFIED = "Unspecified";

	private CareerFactory()
		{
		}

	public static Career generateRandomCareer(PlayerCharacter playerCharacter)
		{
		int careerType = Dice.rollXDiceWithYSides(1, CAREER_NAMES.length) - 1;
		Career career = new Career(playerCharacter, getCareerName(careerType));
		return career;
		}

	public static Career generateCareer(PlayerCharacter playerCharacter, int careerType)
		{
		Career career = new Career(playerCharacter, getCareerName(careerType));
		return career;
		}

	public static String getCareerName(int careerType)
		{
		if (careerTypeIsValid(careerType))
			{
			return CAREER_NAMES[careerType];

			}
		return UNSPECIFIED;
		}

	public static boolean careerTypeIsValid(int careerType)
		{
		if (careerType >= 0 && careerType < CAREER_NAMES.length)
			{
			return true;
			}
		return false;
		}

}
