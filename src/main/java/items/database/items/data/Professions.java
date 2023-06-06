package items.database.items.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Professions {
	private ArrayList<Profession> listOfProfessions;

	public ArrayList<Profession> getListOfProfessions() {
		return listOfProfessions;
	}

	public void setListOfProfessions(ArrayList<Profession> listOfProfessions) {
		this.listOfProfessions = listOfProfessions;
	}

}
