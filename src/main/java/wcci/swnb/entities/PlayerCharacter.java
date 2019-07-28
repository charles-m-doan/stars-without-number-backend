package wcci.swnb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PlayerCharacter {
	@Id
	@GeneratedValue
	private Long Id;

	@OneToOne(mappedBy = "playerCharacter")
	private Attribute strength;
	@OneToOne(mappedBy = "playerCharacter")
	private Attribute dexterity;
	@OneToOne(mappedBy = "playerCharacter")
	private Attribute constitution;
	@OneToOne(mappedBy = "playerCharacter")
	private Attribute intelligence;
	@OneToOne(mappedBy = "playerCharacter")
	private Attribute wisdom;
	@OneToOne(mappedBy = "playerCharacter")
	private Attribute charisma;

	@OneToOne(mappedBy = "playerCharacter")
	private Career career;

	private String name;
	private int level = 1;
	private int experience = 0;

	protected PlayerCharacter()
		{
		this.name = "";
		}

	public PlayerCharacter(String name)
		{
		super();
		this.name = name;
		}

	public Long getId()
		{
		return Id;
		}

	public Attribute getStrength()
		{
		return strength;
		}

	public Attribute getDexterity()
		{
		return dexterity;
		}

	public Attribute getConstitution()
		{
		return constitution;
		}

	public Attribute getIntelligence()
		{
		return intelligence;
		}

	public Attribute getWisdom()
		{
		return wisdom;
		}

	public Attribute getCharisma()
		{
		return charisma;
		}

	public Career getCareer()
		{
		return career;
		}

	public String getName()
		{
		return name;
		}

	public int getLevel()
		{
		return level;
		}

	public int getExperience()
		{
		return experience;
		}

	public void setName(String name)
		{
		this.name = name;
		}

	public void setLevel(int level)
		{
		this.level = level;
		}

	public void setExperience(int experience)
		{
		this.experience = experience;
		}

	@Override
	public int hashCode()
		{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + experience;
		result = prime * result + level;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
		}

	@Override
	public boolean equals(Object obj)
		{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerCharacter other = (PlayerCharacter) obj;
		if (Id == null)
			{
			if (other.Id != null)
				return false;
			}
		else if (!Id.equals(other.Id))
			return false;
		if (experience != other.experience)
			return false;
		if (level != other.level)
			return false;
		if (name == null)
			{
			if (other.name != null)
				return false;
			}
		else if (!name.equals(other.name))
			return false;
		return true;
		}

}
