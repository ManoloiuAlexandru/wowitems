package items.database.items.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Profession {

	@JsonProperty("ProfessionName")
	private String professionName;
	@JsonProperty("CharacterThatHasIt")
	private String characterThatHasIt;
	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getCharacterThatHasIt() {
		return characterThatHasIt;
	}

	public void setCharacterThatHasIt(String characterThatHasIt) {
		this.characterThatHasIt = characterThatHasIt;
	}

}
