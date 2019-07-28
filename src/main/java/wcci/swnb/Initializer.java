package wcci.swnb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.swnb.entities.PlayerCharacter;
import wcci.swnb.repos.AttributeRepository;
import wcci.swnb.repos.CareerRepository;
import wcci.swnb.repos.PlayerCharacterRepository;
import wcci.swnb.utility.RandomEntityGenerator;

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

		for (int i = 0; i < 8; i++)
			{
			PlayerCharacter playerCharacter = RandomEntityGenerator.generateRandomCharacter(pcRepo);
			RandomEntityGenerator.assignRandomAttributesToPC(attributeRepo, playerCharacter);
			RandomEntityGenerator.assignRandomCareerToPC(careerRepo, playerCharacter);
			}

		}
}
