package wcci.swnb.entities.factories;

import java.util.ArrayList;

public class PlayerCharacterFactory {

	public static final int[] XP_TO_ADVANCE_LEVEL = { 3, 6, 12, 18, 27, 39, 54, 72, 93 };
	public static final int TOTAL_XP_OF_ALL_EXPLICIT_LEVELS = getTotalXPOfExplicitlyMappedLevels();
	public static final int XP_MODIFIER_OVER_EXPLICIT = 24;

	private PlayerCharacterFactory()
		{
		}

	public static int getXPForGivenLevel(int level)
		{
		int experience = 0;
		for (int i = 0; i <= level; i++)
			{
			experience += getBaseXPNeededToAttainLevelFromPrevious(i);
			}
		return experience;
		}

	public static int getLevelForGivenXP(int experience)
		{
		int level = 1;
		int xpForLevel = getBaseXPNeededToAttainLevelFromPrevious(level);
		int currentXP = experience;
		while (currentXP >= xpForLevel)
			{
			currentXP -= xpForLevel;
			level++;
			xpForLevel = getBaseXPNeededToAttainLevelFromPrevious(level);
			}
		return level - 1;
		}

	public static int getBaseXPNeededToAttainLevelFromPrevious(int level)
		{
		if (level < 2)
			{
			return 0;
			}
		if (level - 2 < XP_TO_ADVANCE_LEVEL.length)
			{
			return XP_TO_ADVANCE_LEVEL[level - 2];
			}
		return XP_TO_ADVANCE_LEVEL[XP_TO_ADVANCE_LEVEL.length - 1] + ((level - 1 - XP_TO_ADVANCE_LEVEL.length) * XP_MODIFIER_OVER_EXPLICIT);
		}

	private static int getTotalXPOfExplicitlyMappedLevels()
		{
		int experience = 0;
		for (int i = 0; i < XP_TO_ADVANCE_LEVEL.length; i++)
			{
			experience += XP_TO_ADVANCE_LEVEL[i];
			}
		return experience;
		}
}
