package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import src.config.ConnectionDB;
import src.utils.*;

public class ClienteDAO {
    private Connection con;

    public ClienteDAO(){
        this.con = ConnectionDB.Connect();
    }

    public void CadastrarCliente(Client client){
        final String query = 
        "INSERT INTO Client(name,cpf,email,phone,street,num,district,city,state) VALUES(?,?,?,?,?,?,?,?,?)";

        try{
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getCPF());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhone());
            /* stmt.setString(5, client.getAddress().getStreet());
            stmt.setString(6, client.getAddress().getNumber());
            stmt.setString(7, client.getAddress().getDistrict());
            stmt.setString(8, client.getAddress().getCity());
            stmt.setString(9, client.getAddress().getUF()); */

            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
