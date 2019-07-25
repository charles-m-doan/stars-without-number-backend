package wcci.swnb;

import org.springframework.beans.factory.annotation.Autowired;

import wcci.swnb.entities.Attribute;
import wcci.swnb.entities.Career;
import wcci.swnb.entities.PlayerCharacter;
import wcci.swnb.repos.AttributeRepository;
import wcci.swnb.repos.CareerRepository;
import wcci.swnb.repos.PlayerCharacterRepository;

public class Initializer {

	@Autowired
	private PlayerCharacterRepository pcRepo;
	@Autowired
	private AttributeRepository attributeRepo;
	@Autowired
	private CareerRepository careerRepo;

	public void run(String... args) throws Exception {
		Attribute axleAttribute = new Attribute(1);
		attributeRepo.save(axleAttribute);
		Career warrior = new Career("Change the result of an attack once per scene");
		careerRepo.save(warrior);
		PlayerCharacter axle = new PlayerCharacter("axle", warrior, axleAttribute);
		pcRepo.save(axle);
	}
}
