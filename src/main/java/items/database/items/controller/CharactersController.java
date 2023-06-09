package items.database.items.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import items.database.items.data.Character;
import items.database.items.data.Profession;
import items.database.items.services.CharactersServices;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/characters")
public class CharactersController {

	private final CharactersServices charachtersServices;

	@GetMapping("/listofcharacters")
	public String listOfCharacters() throws IOException {
		return charachtersServices.getListOfCharacters();
	}
	@PostMapping("/charProfession")
	public ArrayList<Profession> charachterProfessions(@RequestBody Character character) throws IOException {
		return charachtersServices.getCharactersProfessions(character);
	}
	@PostMapping("/addnewcharacter")
	public void addNewCharacter(@RequestBody Character character)
	{
		charachtersServices.addNewCharacter(character);
	}
}
