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
import items.database.items.data.Professions;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CharactersServices {

	private final ProfessionsServices professionsServices;
	final ObjectMapper objectMapper = new ObjectMapper();

	private static ArrayList<Character> getCharactersFromDB() throws IOException {
		try {
			ArrayList<Character> result = new ArrayList<>();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/item_database?useSSL=false&serverTimezone=GMT", "root", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Characters");
			while (rs.next()) {
				result.add(new Character(rs.getString(1), rs.getString(2)));
			}
			con.close();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public String getListOfCharacters() throws IOException {
		return new Gson().toJson(getCharactersFromDB());
	}

}
