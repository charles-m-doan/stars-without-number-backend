package wcci.swnb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Attribute {
	@Id
	@GeneratedValue
	private Long Id;

	@JsonIgnore
	@ManyToOne
	private PlayerCharacter playerCharacter;

	private String typeName;
	private int value;
	private int modifier;

	protected Attribute()
		{
		}

	public Attribute(PlayerCharacter playerCharacter, String type, int value, int modifier)
		{
		super();
		this.playerCharacter = playerCharacter;
		this.typeName = type;
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

	public String getTypeName()
		{
		return typeName;
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
