package DBAnalyser;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class sqlConnector {
   public static Connection connector() {
      Connection connection = null;
      try
      {
         Class.forName("com.mysql.cj.jdbc.Driver"); // This is for MySQL. Add your own database connector class here.
         connection = DriverManager.getConnection("jdbc:mysql://", "", "");
         // getConnection has 3 arguments, the DB URL, the username and the password
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