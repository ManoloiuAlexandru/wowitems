package items.database.items.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import items.database.items.data.Profession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessionsServices {

	private final ObjectMapper objectMapper;

	private static ArrayList<Profession> getProfessionsFromDB() throws IOException {
		try {
			ArrayList<Profession> result = new ArrayList<>();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/item_database?useSSL=false&serverTimezone=GMT", "root", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from professions");
			while (rs.next()) {
				result.add(new Profession(rs.getString(1), rs.getString(2)));
			}
			con.close();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public String getListOfProfessions() throws IOException {
		return new Gson().toJson(getProfessionsFromDB());
	}
}
