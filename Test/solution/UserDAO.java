package solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

	public User getUserByEmail(String email) throws Exception {
		Connection con = DriverManager.getConnection("Data Source=localhost;Initial Catalog=sqldb;Persist Security Info=True; MultipleActiveResultSets=true", "sa", "ThePassword123");

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

		while (rs.next()) {
			if (rs.getString(0) == email) {
				User user = new User();
				user.email = rs.getString(0);
				return user;
			}
		}

		throw new Exception("User not found");
	}
	
	public void createUser(User user) throws Exception {
		Connection con = DriverManager.getConnection("Data Source=localhost;Initial Catalog=sqldb;Persist Security Info=True; MultipleActiveResultSets=true", "sa", "ThePassword123");

		Statement stmt = con.createStatement();

		stmt.executeUpdate("INSERT INTO Users(Email) VALUES (" + user.email + ")");
	}
}
