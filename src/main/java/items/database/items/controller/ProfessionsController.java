package items.database.items.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import items.database.items.services.ProfessionsServices;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professions")
public class ProfessionsController {

	private final ProfessionsServices professionsServices;

	@GetMapping("/listofprofessions")
	public String getItemsList() throws IOException {
		return professionsServices.getListOfProfessions();
	}
}
