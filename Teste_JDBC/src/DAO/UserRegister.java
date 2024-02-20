
package DAO;

import Conexao.DbConnector;
import Entidades.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegister {
    public void userRegister(User user){
        String sql = "INSERT INTO User(NOME, EMAIL) VALUES(?, ?)";
        
        PreparedStatement ps;
        
        try{
            ps = DbConnector.getConnector().prepareStatement(sql);
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());

            ps.execute();
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
