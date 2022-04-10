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
        final String query1 = 
        "INSERT INTO Client(name,CPF,email,phone) VALUES(?,?,?,?)";

        final String query2 = 
        "INSERT INTO Client(street,num,district,city,state,CPF_Client) VALUES(?,?,?,?,?,?)";

        try{
            PreparedStatement stmt1 = this.con.prepareStatement(query1);
            stmt1.setString(1, client.getName());
            stmt1.setString(2, client.getCPF());
            stmt1.setString(3, client.getEmail());
            stmt1.setString(4, client.getPhone());
            stmt1.execute();
            stmt1.close();

            
            PreparedStatement stmt2 = this.con.prepareStatement(query2);
            stmt2.setString(1, client.getAddress().getStreet());
            stmt2.setString(2, Integer.toString(client.getAddress().getNumber()));
            stmt2.setString(3, client.getAddress().getDistrict());
            stmt2.setString(4, client.getAddress().getCity());
            stmt2.setString(5, client.getAddress().getState().toString());
            stmt2.setString(6, client.getCPF());
            stmt2.execute();
            stmt2.close();

        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
