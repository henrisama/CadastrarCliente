package src.config;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.env.Env;

public class Migration {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = Env.PasswordDB;
    private static final String URL = "jdbc:mysql://localhost:3306/";

    public static void main(String[] args) {
        String query1 = "CREATE DATABASE IF NOT EXISTS RegisterClient;";
        String query2 = "use RegisterClient;";
        String query3 = 
            "CREATE TABLE IF NOT EXISTS Client("
        +   "CPF VARCHAR(11) NOT NULL,"
        +   "name VARCHAR(50) NOT NULL,"
        +   "email VARCHAR(50) UNIQUE NOT NULL,"
        +   "phone VARCHAR(20) NOT NULL,"
        +   "PRIMARY KEY (CPF));";

        String query4 = 
            "CREATE TABLE IF NOT EXISTS ClientAddress("
        +   "street VARCHAR(30) NOT NULL,"
        +   "num INT NOT NULL,"
        +   "district VARCHAR(30) NOT NULL,"
        +   "city VARCHAR(30) NOT NULL,"
        +   "state VARCHAR(2) NOT NULL,"
        +   "CPF_Client VARCHAR(11) NOT NULL,"
        +   "FOREIGN KEY (CPF_Client) REFERENCES Client(CPF));";

        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected");

            Statement stmt = con.createStatement();
            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query3);
            stmt.executeUpdate(query4);
            con.close();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
