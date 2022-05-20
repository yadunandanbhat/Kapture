package DBAnalyser;

import java.util.*;
import java.sql.*;

public class Analyser {
        Connection connection = sqlConnector.connector();
        Statement statement = null;
        ResultSet rs = null;
        Scanner in = new Scanner(System.in);
        String tableName = ""; // Enter your tablename here
    public Analyser() {
        try {
            statement = connection.createStatement();
            System.out.println("*****************************************************************************");
            System.out.println("\tDATABASE ANALYSER\t");
            System.out.println("*****************************************************************************");
            System.out.println("Choices:\n");
            System.out.println("1. Hour of the day when the call volume is highest.\n");
            System.out.println("2. Hour of the day when the calls are longest.\n");
            System.out.println("3. Day of the week when the call volume is highest.\n");
            System.out.println("4. Day of the week when the calls are longest.\n");
            System.out.println("*****************************************************************************");
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1: rs = statement.executeQuery("select HOUR(End_time) as Hour, count(Hour(End_time)) as TotalCalls from " + tableName + " group by Hour order by TotalCalls desc limit 1");
                        while (rs.next()) {
                            System.out.print("\nHour of the day when the call volume is highest is:\n" + rs.getInt("Hour") + " with " + rs.getInt("TotalCalls") + " calls.\n");
                        }
                        System.out.println("*****************************************************************************");
                        break;

                case 2: rs = statement.executeQuery("select HOUR(End_time) as Hour, sum(Duration) as TotalDuration from " + tableName + " group by Hour order by TotalDuration desc limit 1");
                        while (rs.next()) {
                            System.out.print("\nHour of the day when the call duration is longest is:\n" + rs.getInt("Hour") + " with " + rs.getInt("TotalDuration") + " duration.\n");
                        }
                        System.out.println("*****************************************************************************");
                        break;

                case 3: rs = statement.executeQuery("select DAYOFWEEK(End_time) as DayOfWk, count(DAYOFWEEK(End_time)) as TotalCalls from " + tableName + " group by DayOfWk order by TotalCalls desc limit 1");
                        while(rs.next()) {
                            System.out.print("\nDay of the week when the call volume is highest is:\n" + rs.getInt("DayOfWk") + " with " + rs.getInt("TotalCalls") + " calls.\n");
                        }
                        System.out.println("*****************************************************************************");
                        break;

                case 4: rs = statement.executeQuery("select DAYOFWEEK(End_time) as DayOfWk, sum(Duration) as TotalDuration from " + tableName + " group by DayOfWk order by TotalDuration desc limit 1");
                        while(rs.next()) {
                            System.out.print("\nDay of the week when the call duration is longest is:\n" + rs.getInt("DayOfWk") + " with " + rs.getInt("TotalDuration") + " duration.\n");
                        }
                        System.out.println("*****************************************************************************");
                        break;

                default: System.out.println("Enter correct choice!");
            }
            rs.close();
            statement.close();
            connection.close();
            in.close();
        } catch (SQLException e) {
            // Handles the SQLException
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Analyser();
    }
}