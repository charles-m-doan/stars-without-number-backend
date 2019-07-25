package wcci.swnb.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Career {
	@Id
	@GeneratedValue
	private Long Id;
	@OneToOne
	private PlayerCharacter playerCharacter;
	String description;

	private Career() {
	}

	public Career(String description) {
		this.description = description;
		this.playerCharacter = playerCharacter;
	}

	public String getDescription() {
		return description;
	}

}
