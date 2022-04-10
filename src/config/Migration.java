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
        +   "id INT AUTO_INCREMENT,"
        +   "name VARCHAR(50),"
        +   "cpf VARCHAR(11),"
        +   "email VARCHAR(50),"
        +   "phone VARCHAR(20),"
        +   "PRIMARY KEY (id));";

        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected");

            Statement stmt = con.createStatement();
            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query3);
            con.close();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
