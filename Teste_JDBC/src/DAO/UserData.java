package DAO;

//Aqui é chamado a classe de conexão com o banco MySQL
import Conexao.DbConnector;
//Aqui é chamado minha classe usuário
import Entidades.User;
//Aqui é chamado a lib que executará as queries no MySQL
import java.sql.PreparedStatement;
//O SQLException irá printar erro em caso de falha de query SQL
import java.sql.SQLException;
//O ResultSet será usado para iterar valroes em caso de retorno de valores 
//Por exemplo em consultas tipo SELECT
import java.sql.ResultSet;

//Classe de maniuplação de Dados do usuário
public class UserData {

    //método que irá let dados do banco e retornará dados para usuário
    //ele fará um consulta do tipo SELECT
    public void userRead(User user) {
        //Variável tipo String com a query SQL
        String sql = "SELECT * FROM User";

        //Instanciando a lib PreparedStatement em uma variável
        PreparedStatement ps;

        //Aqui o try tentará executar o comando SQL
        try {
            //Aqui a variável com ps com a instância do PreparaedStatement
            //Isso será feito chamando a classe de conexão com o banco
            //usando o prepareStatement, passando nossa variável com a query SQL como parâmetro
            ps = DbConnector.getConnector().prepareStatement(sql);

            //Aqui instanciamos uma variável com a interfacew ResultSet
            //Em que nela será atribuido a execução do PreparedStatement com a função ExecuteQuery()
            ResultSet res = ps.executeQuery();

            //Neste laço de repeticção, será lido todos os valores da tabela de usuário do banco MySQL
            while (res.next()) {
                //Aqui transformamos em uma String o nome do usuário
                String nome = res.getString("nome");
                //Aqui trnaformamos em String o email do usuário
                String email = res.getString("email");

                //Aqui será printado o nome e o email do usuário
                System.out.println("nome: " + nome);
                System.out.println("email: " + email);
            }

            //caso dê algum erro na query, o SQLException irá mostrar um log com o erro ocorrido
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void userRegister(User user) {
        //Variável tipo String com a query SQL
        //Neste caso cada ponto de interrogação (?) será um valor inserido pelo usuário 
        String sql = "INSERT INTO User(NOME, EMAIL) VALUES(?, ?)";

        PreparedStatement ps;

        try {
            //Mesmo processo do método userRead()
            ps = DbConnector.getConnector().prepareStatement(sql);

            //Aqui passamos os tipos de dados usados no SQL em ordem
            //Neste caso a ordem é nome e email, assim com está na variável com nossa query SQL
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());

            //pedimos para o PreparedStattement executar a query
            ps.execute();

            //mesmo processo do método userRead
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void userDelete(User user) {
        String sql = "DELETE FROM User WHERE nome = ? and email = ?";

        PreparedStatement ps;

        try {
            ps = DbConnector.getConnector().prepareStatement(sql);

            //Mesmo processo do método userRegister
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void userUpdate(User user) {
        String sql = "UPDATE User SET email = ? WHERE nome = ?";

        PreparedStatement ps;

        try {
            ps = DbConnector.getConnector().prepareStatement(sql);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getName());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
