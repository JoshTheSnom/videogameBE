package cz.educanet.videogame;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserManager {
    private List<User> userList = new ArrayList<User>();
    public boolean existByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    public User getUserByUsernameAndPass(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void userAdd(User addedUser) {
        userList.add(addedUser);
    }

}