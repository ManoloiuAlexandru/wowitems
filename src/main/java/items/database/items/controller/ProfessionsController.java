package items.database.items.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import items.database.items.data.Profession;
import items.database.items.services.ProfessionsServices;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professions")
public class ProfessionsController {

	private final ProfessionsServices professionsServices;

	@GetMapping("/listofprofessions")
	public String getListOfProfessions() throws IOException {
		return professionsServices.getListOfProfessions();
	}

	@GetMapping("/listofprofessionsnames")
	public String getListOfProfessionsNames() throws IOException {
		return professionsServices.getListOfProfessionsNames();
	}

	@PostMapping("/listofcharsthathavethatprofession")
	public String getListOfCharsThatHaveThatProfession(@RequestBody Profession profession) throws IOException {
		return professionsServices.getListOfCharactersThatHaveThatProfession(profession);
	}
}
