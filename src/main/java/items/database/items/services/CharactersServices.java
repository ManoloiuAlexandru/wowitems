package items.database.items.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			System.out.println("Getting Characters from the database");
			ArrayList<Character> result = new ArrayList<>();
			Statement stmt = dbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from Characters");
			while (rs.next()) {
				result.add(new Character(rs.getString(1), rs.getString(2)));
			}
			dbConnection().close();
			return result;
		} catch (Exception e) {
			System.out.println("Error at getting Characters from the database");
			System.out.println("Error:" + e);
		}
		return null;
	}

	public String getListOfCharacters() throws IOException {
		return new Gson().toJson(getCharactersFromDB());
	}

	public static ArrayList<Profession> getCharactersProfessionsPost(Character character) {
		try {
			System.out.println("Getting Character professions from the database");
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
			System.out.println("Error at getting Character professions from the database");
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<Profession> getCharactersProfessions(Character character) {
		return getCharactersProfessionsPost(character);
	}

	public static void addNewCharacters(Character character) {
		System.out.println("Adding new character to database");
		try {
			Statement stmt = dbConnection().createStatement();
			stmt.executeUpdate("insert into Characters(CharacterName,ArmorType) values (\""
					+ character.getCharacterName() + "\",\"" + character.getArmorType() + "\");");
		} catch (SQLException e) {
			System.out.println("Error at adding new Character to database");
			System.out.println(e);
		}
	}

	public void addNewCharacter(Character character) {
		addNewCharacters(character);
	}
}
