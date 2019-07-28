package wcci.swnb.utility;

import java.util.ArrayList;
import java.util.Random;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import wcci.swnb.entities.Attribute;
import wcci.swnb.entities.Career;
import wcci.swnb.entities.PlayerCharacter;
import wcci.swnb.entities.factories.AttributeFactory;
import wcci.swnb.entities.factories.CareerFactory;
import wcci.swnb.entities.factories.PlayerCharacterFactory;
import wcci.swnb.repos.AttributeRepository;
import wcci.swnb.repos.CareerRepository;
import wcci.swnb.repos.PlayerCharacterRepository;

public class RandomEntityGenerator {

	private static final Random RANDOM = new Random(System.nanoTime());
	private static final Lorem LOREM = LoremIpsum.getInstance();

	private static final int MAX_LEVEL_FOR_RANDOM_CHARS = 20;
	private static final int MAX_XP_FOR_RANDOM_CHARS = PlayerCharacterFactory.getXPForGivenLevel(MAX_LEVEL_FOR_RANDOM_CHARS);

	public static PlayerCharacter generateRandomCharacter(PlayerCharacterRepository pcRepo)
		{
		String name = LOREM.getFirstName();
		int experience = RANDOM.nextInt(MAX_XP_FOR_RANDOM_CHARS);

		PlayerCharacter playerCharacter = new PlayerCharacter(name);
		playerCharacter.addExperience(experience);

		pcRepo.save(playerCharacter);
		return playerCharacter;
		}

	public static void assignRandomAttributesToPC(AttributeRepository attributeRepo, PlayerCharacter playerCharacter)
		{
		ArrayList<Attribute> attributes = AttributeFactory.generateAllAttributes(playerCharacter);
		for (Attribute attribute : attributes)
			{
			attributeRepo.save(attribute);
			}
		}

	public static void assignRandomCareerToPC(CareerRepository careerRepo, PlayerCharacter playerCharacter)
		{
		Career career = CareerFactory.generateRandomCareer(playerCharacter);
		careerRepo.save(career);
		}

}
