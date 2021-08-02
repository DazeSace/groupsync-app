package app.groupsync.dev.entities;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@QuarkusTest
class UserTest {

    @BeforeEach
    @Transactional
    void setup() {
        User.deleteAll();
    }

    @Test
    void addUserTest() {
        User.create("Jimmy", "Choo", LocalDateTime.now().toString());
        List<User> users = User.listAll();
        assertEquals(1, users.size());
    }

    @Test
    void userHasFirstname() {
        User.create("Jimmy", "Choo", LocalDateTime.now().toString());
        List<User> users = User.listAll();
        assertEquals("Jimmy", users.get(0).getFirstname());
    }

    @Test
    void userHasLastname() {
        User.create("Jimmy", "Choo", LocalDateTime.now().toString());
        List<User> users = User.listAll();
        assertEquals("Choo", users.get(0).getLastname());
    }

    @Test
    void userHasBirthdate() {
        var birthday = LocalDateTime.now().toString();
        User.create("Jimmy", "Choo", birthday);
        List<User> users = User.listAll();
        assertEquals(birthday, users.get(0).getBirthday());
    }

    @Test
    void getAllUsers() {
        User.create("Jimmy", "Choo", LocalDateTime.now().toString());
        User.create("Jerry", "Boo", LocalDateTime.now().toString());
        List<User> users = User.getAll();
        assertEquals(2, users.size());
    }

}