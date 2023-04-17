package fr.sauvageb.chat.service;

import fr.sauvageb.chat.dao.UserDao;
import fr.sauvageb.chat.dao.UserJdbcDao;
import fr.sauvageb.chat.exception.UserAlreadyExistException;
import fr.sauvageb.chat.model.User;

import java.util.List;

public class UserService {

    UserDao userJdbcDao = new UserJdbcDao();

    public void register(String username, String firstname, String lastname, String email, String password, String pictureUrl) throws Exception {
        User user = userJdbcDao.findByUsername(username);
        if (user != null) {
            throw new UserAlreadyExistException(username);
        } else {
            User newUser = new User(username, firstname, lastname, email, password, pictureUrl);
            if (!userJdbcDao.create(newUser)) {
                throw new Exception("Cannot register user");
            }
        }
    }

    public User login(String username, String password) {
        User user = userJdbcDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    List<User> fetchAllUsers() {
        return userJdbcDao.findAll();
    }


}
