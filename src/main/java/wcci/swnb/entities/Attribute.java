package wcci.swnb.entities;

public class Attribute {

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

	private final int type;
	private int value = 0;

	public Attribute(int type)
		{
		this.type = type;
		}

	public int getValue()
		{
		return value;
		}

	public void setValue(int value)
		{
		this.value = value;
		}

	public void increaseValue(int amountToIncrease)
		{
		value += amountToIncrease;
		if (value > MAX_VALUE)
			{
			value = MAX_VALUE;
			}
		}

	public void decreaseValue(int amountToDecrease)
		{
		value -= amountToDecrease;
		if (value < MIN_VALUE)
			{
			value = MIN_VALUE;
			}
		}

	public int getModifier()
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

	public int getType()
		{
		return type;
		}

	public String getTypeName()
		{
		if (typeIsValid(type))
			{
			return UNRECOGNIZED_TYPE_NAME;
			}
		return TYPE_NAMES[type];
		}

	private static boolean typeIsValid(int type)
		{
		if (type < 0 || type > TYPE_NAMES.length)
			{
			return false;
			}
		return true;
		}
}
