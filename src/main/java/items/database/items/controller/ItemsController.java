package items.database.items.controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import items.database.items.services.GetListOfItems;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemsController {

	private final GetListOfItems getListOfItems;

	@GetMapping("/listofitems")
	public int getItemsList() throws IOException {
		return getListOfItems.getListOfItems();
	}

}