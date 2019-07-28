package wcci.swnb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import wcci.swnb.repos.AttributeRepository;
import wcci.swnb.repos.CareerRepository;
import wcci.swnb.repos.PlayerCharacterRepository;

@Component
public class RandomEntityGenerator implements CommandLineRunner {

	private static final Lorem LOREM = LoremIpsum.getInstance();

	@Autowired
	private PlayerCharacterRepository pcRepo;
	@Autowired
	private AttributeRepository attributeRepo;
	@Autowired
	private CareerRepository careerRepo;

	public void run(String... args) throws Exception
		{
		System.out.println("Loading Random Entity Generator");
		}

	public void generateRandomCharacter()
		{
		
		}
}
