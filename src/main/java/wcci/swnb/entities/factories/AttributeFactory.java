package wcci.swnb.entities.factories;

import java.util.ArrayList;

import wcci.swnb.entities.Attribute;
import wcci.swnb.entities.PlayerCharacter;
import wcci.swnb.utility.Dice;

public class AttributeFactory {

	public static final int STRENGTH = 0;
	public static final int DEXTERITY = 1;
	public static final int CONSTITUTION = 2;
	public static final int INTELLIGENCE = 3;
	public static final int WISDOM = 4;
	public static final int CHARISMA = 5;
	public static final String[] TYPE_NAMES = { "Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma" };
	public static final String UNRECOGNIZED_TYPE_NAME = "Unknown";

	public static final int MIN_VALUE = 3;
	public static final int MAX_VALUE = 18;

	private AttributeFactory()
		{
		}

	public static ArrayList<Attribute> generateAllAttributes(PlayerCharacter playerCharacter)
		{
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		for (int i = 0; i < TYPE_NAMES.length; i++)
			{
			int type = i;
			Attribute attribute = generateAttribute(playerCharacter, type);
			attributes.add(attribute);
			}
		return attributes;
		}

	public static Attribute generateAttribute(PlayerCharacter playerCharacter, int type)
		{
		String typeName = getTypeName(type);
		int value = Dice.rollXDiceWithYSides(3, 6);
		int modifier = calculateModifier(value);
		Attribute attribute = new Attribute(playerCharacter, typeName, value, modifier);
		return attribute;
		}

	public static Attribute generateAttribute(PlayerCharacter playerCharacter, int type, int value)
		{
		String typeName = getTypeName(type);
		int modifier = calculateModifier(value);
		Attribute attribute = new Attribute(playerCharacter, typeName, value, modifier);
		return attribute;
		}

	public static int calculateModifier(int value)
		{
		if (value <= MIN_VALUE)
			{
			return -2;
			}
		else if (value >= 4 && value <= 7)
			{
			return -1;
			}
		else if (value >= 8 && value <= 13)
			{
			return 0;
			}
		else if (value >= 14 && value < MAX_VALUE)
			{
			return 1;
			}
		else
			{
			// Greater than or equal to MAX_VALUE (18 following standard rules)
			return 2;
			}
		}

	public static String getTypeName(int type)
		{
		if (typeIsValid(type))
			{
			return TYPE_NAMES[type];
			}
		return UNRECOGNIZED_TYPE_NAME;
		}

	public static boolean typeIsValid(int type)
		{
		if (type >= 0 && type < TYPE_NAMES.length)
			{
			return true;
			}
		return false;
		}

}
