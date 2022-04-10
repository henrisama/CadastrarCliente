package src.config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Migration {
    public static void main(String[] args) {
        String query = 
            "CREATE TABLE IF NOT EXISTS Cliente("
        +   "id INT AUTO_INCREMENT,"
        +   "name VARCHAR(50),"
        +   "cpf VARCHAR(11),"
        +   "email VARCHAR(50),"
        +   "phone VARCHAR(20),"
        +   "PRIMARY KEY (id));";

        try{
            Connection con = ConnectionDB.Connect();
            Statement stmt = con.createStatement();
            //stmt.executeUpdate(query);
            ResultSet rs = stmt.executeQuery("show databases;");
            System.out.println(rs.toString());
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            rs.close();
            con.close();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
