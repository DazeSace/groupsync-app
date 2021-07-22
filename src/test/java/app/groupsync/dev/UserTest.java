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

}