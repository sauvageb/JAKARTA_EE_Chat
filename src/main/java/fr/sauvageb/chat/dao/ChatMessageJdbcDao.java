package fr.sauvageb.chat.dao;

import fr.sauvageb.chat.dao.base.ConnectionManager;
import fr.sauvageb.chat.model.ChatMessage;
import fr.sauvageb.chat.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatMessageJdbcDao implements ChatMessageDao {


    @Override
    public boolean create(ChatMessage chatMessage) {
        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO chat_messages(message, created_at, sender_fk ) VALUES(?,?,?)";
        boolean insertOk = false;
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setString(1, chatMessage.getMessage());
            prepareStatement.setObject(2, Timestamp.valueOf(chatMessage.getCreatedAt()));
            prepareStatement.setLong(3, chatMessage.getSender().getId());

            int rowsAffected = prepareStatement.executeUpdate();

            insertOk = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertOk;
    }

    @Override
    public List<ChatMessage> findAll() {
        List<ChatMessage> messages = new ArrayList<>();
        UserDao userDao = new UserJdbcDao();

        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, message, created_at, sender_fk FROM chat_messages";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User sender = userDao.findById(resultSet.getLong("sender_fk"));
                ChatMessage chatMessage = new ChatMessage(
                        resultSet.getLong("id"),
                        resultSet.getString("message"),
                        sender,
                        resultSet.getTimestamp("created_at").toLocalDateTime()
                );
                messages.add(chatMessage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }


    @Override
    public ChatMessage findById(Long aLong) {
        return null;
    }

    @Override
    public void update(ChatMessage entity) {

    }

    @Override
    public void delete(ChatMessage entity) {

    }

}
