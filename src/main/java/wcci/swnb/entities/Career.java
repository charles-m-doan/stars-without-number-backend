package wcci.swnb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import wcci.swnb.entities.factories.CareerFactory;

@Entity
public class Career {

	@Id
	@GeneratedValue
	private Long Id;

	@OneToOne
	private PlayerCharacter playerCharacter;

	String careerName;

	public Career(PlayerCharacter playerCharacter)
		{
		this.careerName = CareerFactory.UNSPECIFIED;
		}

	public Career(PlayerCharacter playerCharacter, String careerName)
		{
		this.playerCharacter = playerCharacter;
		this.careerName = careerName;
		}

	public Long getId()
		{
		return Id;
		}

	public PlayerCharacter getPlayerCharacter()
		{
		return playerCharacter;
		}

	public String getCareerName()
		{
		return careerName;
		}

	public void setCareerName(String careerName)
		{
		this.careerName = careerName;
		}

	@Override
	public int hashCode()
		{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((careerName == null) ? 0 : careerName.hashCode());
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
		if (careerName == null)
			{
			if (other.careerName != null)
				return false;
			}
		else if (!careerName.equals(other.careerName))
			return false;
		return true;
		}

}
