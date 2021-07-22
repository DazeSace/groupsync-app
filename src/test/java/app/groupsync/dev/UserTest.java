package app.groupsync.dev;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@QuarkusTest
class UserTest {

    @BeforeEach
    @Transactional
    void setup() {
        User.deleteAll();
    }

    @Test
    void addUserTest() {
        var user = User.userAdd("Jimmy", "Choo", LocalDateTime.now());
        List<User> users = User.listAll();
        assertEquals(1, users.size());
    }

    @Test
    void userHasFirstname() {
        var user = User.userAdd("Jimmy", "Choo", LocalDateTime.now());
        List<User> users = User.listAll();
        assertEquals("Jimmy", users.get(0).getFirstname());
    }

    @Test
    void userHasLastname() {
        var user = User.userAdd("Jimmy", "Choo", LocalDateTime.now());
        List<User> users = User.listAll();
        assertEquals("Choo", users.get(0).getLastname());
    }

    @Test
    void userHasBirthdate() {
        var birthday = LocalDateTime.now();
        var user = User.userAdd("Jimmy", "Choo", birthday);
        List<User> users = User.listAll();
        assertEquals(birthday, users.get(0).getBirthday());
    }

}