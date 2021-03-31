package solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import solution.exceptions.UserNotFoundException;

public class UserDAO {

	public User getUserByEmail(String email) throws Exception {
		Connection con = DriverManager.getConnection("Data Source=localhost;Initial Catalog=sqldb;Persist Security Info=True; MultipleActiveResultSets=true", "sa", "ThePassword123");


		Statement stmt = con.prepareStatement("SELECT * FROM Users WHERE email = 'email'");


		try (ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				if (rs.getString("email").equals(email)) {
					User user = new User();
					user.setEmail(rs.getString("email"));
					return user;
				}
			}
		}

		throw new UserNotFoundException("User not found");
	}
	
	public void createUser(User user) throws Exception {
		Connection con = DriverManager.getConnection("Data Source=localhost;Initial Catalog=sqldb;Persist Security Info=True; MultipleActiveResultSets=true", "sa", "ThePassword123");

		Statement stmt = con.createStatement();

		stmt.executeUpdate("INSERT INTO Users(Email) VALUES (" + user.getEmail() + ")");
	}
}
