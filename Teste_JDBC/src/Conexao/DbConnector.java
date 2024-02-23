package Conexao;

//conexão do banco 
import java.sql.Connection;
//leitor do driver .jar do projeto
import java.sql.DriverManager;
//printa erro em caso de falha de query SQL
import java.sql.SQLException;

//classe que cria conexão
public class DbConnector {

    //variável que contém url do com nome do banco na ultima rota
    private static final String url = "jdbc:mysql://localhost:3306/teste_jdbc";
    //usuário do banco MySQL
    private static final String user = "root";
    //senha do banco MySQL
    private static final String password = "1234";

    //instanciando a classe Connection em uma variavel
    public static Connection connect;

    //método que irá criar a conexão 
    public static Connection getConnector() {

        //nesse try ele irá criar a conexão
        try {
            //caso a variável com a instância Connection esteja nula, ele criar uma nova conexão
            if (connect == null) {
                connect = DriverManager.getConnection(url, user, password);
                return connect;
                //caso essa conexão já exista, será usada a já existente
            } else {
                return connect;
            }
            //em caso de erro, o catch retornará o tipo de erro através do SQLException
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
