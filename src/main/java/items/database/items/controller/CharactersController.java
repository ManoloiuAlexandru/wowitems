package items.database.items.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import items.database.items.data.Character;
import items.database.items.services.CharactersServices;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/characters")
public class CharactersController {

	private final CharactersServices charachtersServices;

	@GetMapping("/listofcharacters")
	public String getItemsList() throws IOException {
		return charachtersServices.getListOfCharacters();
	}
}
