package wcci.swnb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import wcci.swnb.entities.factories.CareerFactory;

@Entity
public class Career {

	@Id
	@GeneratedValue
	private Long Id;

	@JsonIgnore
	@OneToOne
	private PlayerCharacter playerCharacter;

	String typeName;

	protected Career()
		{
		}

	public Career(PlayerCharacter playerCharacter)
		{
		this.typeName = CareerFactory.UNSPECIFIED;
		}

	public Career(PlayerCharacter playerCharacter, String typeName)
		{
		this.playerCharacter = playerCharacter;
		this.typeName = typeName;
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

	public void setTypeName(String typeName)
		{
		this.typeName = typeName;
		}

	@Override
	public int hashCode()
		{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
		Career other = (Career) obj;
		if (Id == null)
			{
			if (other.Id != null)
				return false;
			}
		else if (!Id.equals(other.Id))
			return false;
		if (typeName == null)
			{
			if (other.typeName != null)
				return false;
			}
		else if (!typeName.equals(other.typeName))
			return false;
		return true;
		}

}
