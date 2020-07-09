package com.upgrad.blog.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TODO 6.2: Implement the DatabaseConnection class using the Singleton Pattern (Hint. Should have the 
 * private no-arg constructor).
 * TODO 6.3: The getInstance() method should create a connection object which is
 * connected with the local database and return this connection object.
 * TODO 6.4: You should handle the ClassNotFoundException and SQLException individually,
 * and not using the Exception class.
 */
public class DatabaseConnection {
  private static Connection con=null;
   private DatabaseConnection()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String username = "adeeba_db"; //Provide username for your database
            String password = "oracle"; //provide password for your database

            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println(e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
    }
    public static Connection getInstance() {
        if (con == null) {
             new DatabaseConnection();
             return con;
        }
    return con;
    }

    public static void main(String[] args) throws SQLException {
        try {
        	DatabaseConnection.getInstance();
        	System.out.println("Connected");
        } catch (Exception e) {
        	System.out.println("Not Connected");
        }
    }
}
