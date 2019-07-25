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
	private Attribute attribute;
	@OneToOne(mappedBy = "playerCharacter")
	private Career career;

	String name;

	private PlayerCharacter() {
	}

	public PlayerCharacter(String name, Career career, Attribute attribute) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

}
