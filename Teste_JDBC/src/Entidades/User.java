package Entidades;

//classe que irá criar o objeto usuário  
public class User {

    //nome do usuário
    private String name;
    //email do usuário
    private String email;

    //método que retorna o nome do usuário
    public String getName() {
        return name;
    }

    //método que seta valor para variável que conterá o nome 
    public void setName(String name) {
        this.name = name;
    }

    //método que retorna o email do usuário
    public String getEmail() {
        return email;
    }

    //Setando valor para variável que conterá o email 
    public void setEmail(String email) {
        this.email = email;
    }

}
