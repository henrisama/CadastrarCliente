package src.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import src.env.Env;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = Env.PasswordDB;
    private static final String URL = "jdbc:mysql://localhost:3306/RegisterClient";


    public static Connection Connect(){
        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected");
            return con;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}