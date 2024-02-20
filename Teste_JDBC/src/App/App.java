
package App;

import DAO.UserRegister;
import Entidades.User;

public class App {
    public static void main(String[] args) {
        User user = new User();
        
        user.setName("Felipe");
        user.setEmail("felipe@fgmail.com");
        
        new UserRegister().userRegister(user);
    }
}
