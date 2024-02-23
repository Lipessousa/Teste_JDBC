package App;

import DAO.UserData;
import Entidades.User;

//Class que roda todo o projeto
public class App {

    //método que apaga usuário
    public static void delUser() {
        //Instnaciando uma variavel user que manipulará os dados da classe User
        User user = new User();

        //passando os valores que serão excluidos em seus respectivos camppos
        user.setName("Felipe");
        user.setEmail("felipe@fgmail.com");

        //Chamando método que da classe UserData que deleta usuários
        new UserData().userDelete(user);
    }

    //método que traz os dados da tabela de usuário
    public static void readUser() {
        //mesmo processo do método delUser()
        //porém neste caso não passaremos nenhum valor como parâmetro
        User user = new User();

        //chamando método que irá trazer todos os dados da tabela de usuários
        new UserData().userRead(user);

    }

    public static void insertUser() {
        User user = new User();

        user.setName("Augusto");
        user.setEmail("Augusto@gmail.com");

        new UserData().userRegister(user);
    }

    public static void updateUser() {
        User user = new User();

        user.setEmail("sousa@gmail.com");
        user.setName("Felipe");

        new UserData().userUpdate(user);
    }

    //método que inicializa todo o  projeto
    public static void main(String[] args) {

        //Aqui só chamamos os métodos para executa-los
//        insertUser();
//        
//        delUser();
//
        readUser();

//        updateUser();
    }
}
