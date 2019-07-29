package wcci.swnb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wcci.swnb.entities.Attribute;
import wcci.swnb.entities.Career;
import wcci.swnb.entities.PlayerCharacter;
import wcci.swnb.entities.factories.AttributeFactory;
import wcci.swnb.entities.factories.CareerFactory;
import wcci.swnb.repos.AttributeRepository;
import wcci.swnb.repos.CareerRepository;
import wcci.swnb.repos.PlayerCharacterRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CharacterController {

	@Autowired
	private PlayerCharacterRepository pcRepo;
	@Autowired
	private AttributeRepository attributeRepo;
	@Autowired
	private CareerRepository careerRepo;

	@GetMapping("/characters")
	public Iterable<PlayerCharacter> sendCharacters()
		{
		return pcRepo.findAll();
		}

	@GetMapping("/characters/{id}")
	public PlayerCharacter sendCharacter(@PathVariable Long id)
		{
		return pcRepo.findById(id).get();
		}

	@PostMapping("/characters")
	public PlayerCharacter createCampus(@RequestBody CharacterDetailsPostModel characterDetails)
		{
		PlayerCharacter playerCharacter = new PlayerCharacter(characterDetails.getName());
		pcRepo.save(playerCharacter);
		Career career = CareerFactory.generateCareer(playerCharacter, characterDetails.getCareerType());
		careerRepo.save(career);

		Attribute a1 = AttributeFactory.generateAttribute(playerCharacter, AttributeFactory.STRENGTH, characterDetails.getStrength());
		attributeRepo.save(a1);
		Attribute a2 = AttributeFactory.generateAttribute(playerCharacter, AttributeFactory.DEXTERITY, characterDetails.getDexterity());
		attributeRepo.save(a2);
		Attribute a3 = AttributeFactory.generateAttribute(playerCharacter, AttributeFactory.CONSTITUTION, characterDetails.getConstitution());
		attributeRepo.save(a3);
		Attribute a4 = AttributeFactory.generateAttribute(playerCharacter, AttributeFactory.INTELLIGENCE, characterDetails.getIntelligence());
		attributeRepo.save(a4);
		Attribute a5 = AttributeFactory.generateAttribute(playerCharacter, AttributeFactory.WISDOM, characterDetails.getWisdom());
		attributeRepo.save(a5);
		Attribute a6 = AttributeFactory.generateAttribute(playerCharacter, AttributeFactory.CHARISMA, characterDetails.getCharisma());
		attributeRepo.save(a6);

		// Give character random attributes and career just because these are needed to render properly on the front end.
//		RandomEntityGenerator.assignRandomAttributesToPC(attributeRepo, playerCharacter);
//		RandomEntityGenerator.assignRandomCareerToPC(careerRepo, playerCharacter);
		return pcRepo.findById(playerCharacter.getId()).get();
		}
}
