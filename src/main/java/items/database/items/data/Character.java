package items.database.items.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Character {
	private String CharacterName;
	private String ArmorType;

	public String getCharacterName() {
		return CharacterName;
	}

	public void setCharacterName(String characterName) {
		CharacterName = characterName;
	}

	public String getArmorType() {
		return ArmorType;
	}

	public void setArmorType(String armorType) {
		ArmorType = armorType;
	}

}
