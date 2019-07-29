package wcci.swnb.controllers;

public class CharacterDetailsPostModel {

	private String name;
	private int careerType;
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;

	public String getName()
		{
		return name;
		}

	public void setName(String name)
		{
		this.name = name;
		}

	public int getCareerType()
		{
		return careerType;
		}

	public void setCareerType(int careerType)
		{
		this.careerType = careerType;
		}

	public int getStrength()
		{
		return strength;
		}

	public void setStrength(int strength)
		{
		this.strength = strength;
		}

	public int getDexterity()
		{
		return dexterity;
		}

	public void setDexterity(int dexterity)
		{
		this.dexterity = dexterity;
		}

	public int getConstitution()
		{
		return constitution;
		}

	public void setConstitution(int constitution)
		{
		this.constitution = constitution;
		}

	public int getIntelligence()
		{
		return intelligence;
		}

	public void setIntelligence(int intelligence)
		{
		this.intelligence = intelligence;
		}

	public int getWisdom()
		{
		return wisdom;
		}

	public void setWisdom(int wisdom)
		{
		this.wisdom = wisdom;
		}

	public int getCharisma()
		{
		return charisma;
		}

	public void setCharisma(int charisma)
		{
		this.charisma = charisma;
		}
}
