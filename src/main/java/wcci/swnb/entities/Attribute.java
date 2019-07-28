package wcci.swnb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Attribute {
	@Id
	@GeneratedValue
	private Long Id;

	@OneToOne
	private PlayerCharacter playerCharacter;

	private String type;
	private int value;
	private int modifier;

	public Attribute(PlayerCharacter playerCharacter, String type, int value, int modifier)
		{
		super();
		this.playerCharacter = playerCharacter;
		this.type = type;
		this.value = value;
		this.modifier = modifier;
		}

	public Long getId()
		{
		return Id;
		}

	public PlayerCharacter getPlayerCharacter()
		{
		return playerCharacter;
		}

	public String getType()
		{
		return type;
		}

	public int getValue()
		{
		return value;
		}

	public int getModifier()
		{
		return modifier;
		}
}
