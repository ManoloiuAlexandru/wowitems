package items.database.items.services;

import java.io.IOException;
import java.sql.*;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetListOfItems {
	private final ObjectMapper objectMapper;

	public void connectToDB() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/item_database?useSSL=false&serverTimezone=GMT", "root", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int getListOfItems() throws IOException {
		connectToDB();
		return 5;
	}
}