package fr.sauvageb.chat.dao;

import fr.sauvageb.chat.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao {

    @Override
    public boolean create(User entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO user(username, firstname, lastname, email, password, pictureUrl) VALUES(?,?,?,?,?,?)";
        boolean insertOk = false;
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, entity.getUsername());
            prepareStatement.setString(2, entity.getFirstname());
            prepareStatement.setString(3, entity.getLastname());
            prepareStatement.setString(4, entity.getEmail());
            prepareStatement.setString(5, entity.getPassword());
            prepareStatement.setString(6, entity.getPictureUrl());

            int rowsAffected = prepareStatement.executeUpdate();

            insertOk = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertOk;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, username, firstname, lastname, email, password, pictureUrl FROM user";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String pictureUrl = resultSet.getString("pictureUrl");
                userList.add(new User(id, username, firstname, lastname, email, password, pictureUrl));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public User findByUsername(String usernameFind) {
        User userFound = null;
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, username, firstname, lastname, email, password, pictureUrl FROM user WHERE username=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usernameFind);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String pictureUrl = resultSet.getString("pictureUrl");
                userFound = new User(id, username, firstname, lastname, email, password, pictureUrl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFound;
    }
}
