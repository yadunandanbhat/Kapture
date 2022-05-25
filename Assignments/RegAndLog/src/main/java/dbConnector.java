import java.sql.*;

public class dbConnector {

	public static Connection connector() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/regandlog", "yadunandanbhat", "242882");
			if (connection != null) {
				System.out.println("Database connection is successful!");
			}
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
