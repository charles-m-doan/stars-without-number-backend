package wcci.swnb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wcci.swnb.entities.PlayerCharacter;
import wcci.swnb.repos.PlayerCharacterRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CharacterController {

	@Autowired
	PlayerCharacterRepository pcRepo;

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

}
