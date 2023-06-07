package items.database.items.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import items.database.items.data.Profession;
import items.database.items.data.Character;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessionsServices {

	private final ObjectMapper objectMapper;

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

	private static ArrayList<Profession> getProfessionsFromDB() throws IOException {
		try {
			System.out.println("Getting professions from the database");
			ArrayList<Profession> result = new ArrayList<>();
			Statement stmt = dbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from professions");
			while (rs.next()) {
				result.add(new Profession(rs.getString(1), rs.getString(2)));
			}
			dbConnection().close();
			return result;
		} catch (Exception e) {
			System.out.println("Error at getting professions from the database");
			System.out.println(e);
		}
		return null;
	}

	private static ArrayList<String> getProfessionsNameFromDB() throws IOException {
		try {
			System.out.println("Getting All the professions name from the database");
			ArrayList<String> result = new ArrayList<>();
			Statement stmt = dbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select DISTINCT ProfessionName from professions");
			while (rs.next()) {
				result.add(rs.getString(1));
			}
			dbConnection().close();
			return result;
		} catch (Exception e) {
			System.out.println("Error at getting professions name from the database");
			System.out.println(e);
		}
		return null;
	}

	private static ArrayList<Character> getCharactersThatHaveThatProfession(Profession profession) throws IOException {
		try {
			System.out.println("Getting Characters from the database using the name of the Profession");
			ArrayList<Character> result = new ArrayList<>();
			Statement stmt = dbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from Characters where \r\n"
					+ "CharacterName in (select CharacterThatHasIt from professions where ProfessionName=\""
					+ profession.getProfessionName() + "\")");
			while (rs.next()) {
				result.add(new Character(rs.getString(1), rs.getString(2)));
			}
			dbConnection().close();
			return result;
		} catch (Exception e) {
			System.out.println("Error at getting Character professions from the database");
			System.out.println(e);
		}
		return null;
	}

	public String getListOfProfessions() throws IOException {
		return new Gson().toJson(getProfessionsFromDB());
	}

	public String getListOfProfessionsNames() throws IOException {
		return new Gson().toJson(getProfessionsNameFromDB());
	}

	public String getListOfCharactersThatHaveThatProfession(Profession profession) throws IOException {
		return new Gson().toJson(getCharactersThatHaveThatProfession(profession));
	}
}
