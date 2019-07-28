package wcci.swnb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.swnb.entities.PlayerCharacter;
import wcci.swnb.repos.AttributeRepository;
import wcci.swnb.repos.CareerRepository;
import wcci.swnb.repos.PlayerCharacterRepository;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private PlayerCharacterRepository pcRepo;
	@Autowired
	private AttributeRepository attributeRepo;
	@Autowired
	private CareerRepository careerRepo;

	public void run(String... args) throws Exception
		{
		System.out.println("Running Initializer...");

		PlayerCharacter playerCharacter01 = new PlayerCharacter("Poopman the Great");
		pcRepo.save(playerCharacter01);
		}
}
