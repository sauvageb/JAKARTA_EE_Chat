package fr.sauvageb.chat.service;

import fr.sauvageb.chat.dao.ChatMessageDao;
import fr.sauvageb.chat.dao.ChatMessageJdbcDao;
import fr.sauvageb.chat.model.ChatMessage;
import fr.sauvageb.chat.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class ChatMessageService {

    private ChatMessageDao chatMessageDao = new ChatMessageJdbcDao();
    private UserService userService = new UserService();


    public List<ChatMessage> fetchAllMessages() {
        return chatMessageDao.findAll();
    }

    public boolean addChat(String message, String usernameSender) {
        User userSender = userService.fetchUserByUsername(usernameSender);
        return chatMessageDao.create(new ChatMessage(message, userSender, LocalDateTime.now()));
    }

}
