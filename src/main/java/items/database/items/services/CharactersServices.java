package items.database.items.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import items.database.items.data.Character;
import items.database.items.data.Profession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CharactersServices {

	final ObjectMapper objectMapper = new ObjectMapper();

	private static Connection dbConnection() {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/item_database?useSSL=false&serverTimezone=GMT", "root", "1234");
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	private static ArrayList<Character> getCharactersFromDB() throws IOException {
		try {
			ArrayList<Character> result = new ArrayList<>();
			Statement stmt = dbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from Characters");
			while (rs.next()) {
				result.add(new Character(rs.getString(1), rs.getString(2)));
			}
			dbConnection().close();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public String getListOfCharacters() throws IOException {
		return new Gson().toJson(getCharactersFromDB());
	}

	public static ArrayList<Profession> getCharactersProfessionsPost(Character character) {
		try {
			ArrayList<Profession> result = new ArrayList<>();
			Statement stmt = dbConnection().createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from professions where CharacterThatHasIt=\"" + character.getCharacterName() + "\"");
			while (rs.next()) {
				result.add(new Profession(rs.getString(1), rs.getString(2)));
			}
			dbConnection().close();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<Profession> getCharactersProfessions(Character character) {
		return getCharactersProfessionsPost(character);
	}
}
