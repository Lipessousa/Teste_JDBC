
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private static final String url = "jdbc:mysql://localhost:3306/teste_jdbc";
    private static final String user = "root";
    private static final String password = "1234";

    public static Connection connect;
    
    public static Connection getConnector(){
       try{
           if(connect == null){
               connect = DriverManager.getConnection(url, user, password);
               return connect;
           }else{
               return connect;
           }
       }catch(SQLException e){
           e.printStackTrace();
           return null;
       }
    }
}
