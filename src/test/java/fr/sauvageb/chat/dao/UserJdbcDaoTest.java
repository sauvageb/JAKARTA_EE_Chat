package fr.sauvageb.chat.dao;

import fr.sauvageb.chat.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserJdbcDaoTest {

    @Mock
    UserDao userJdbcDao = new UserJdbcDao();

    private static List<User> USERS_LIST = List.of(
            new User(1L, "username1", "firstname1", "lastname1", "email1", "password1", "pictureurl1"),
            new User(2L, "username2", "firstname2", "lastname2", "email2", "password2", "pictureurl2")
    );

    @Test
    void findAll() {
        // GIVEN
        when(userJdbcDao.findAll()).thenReturn(USERS_LIST);
        // WHEN
        List<User> result = userJdbcDao.findAll();
        // THEN
        Assertions.assertEquals(result.size(), USERS_LIST.size());
    }
}
