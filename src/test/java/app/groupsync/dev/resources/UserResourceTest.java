package app.groupsync.dev.resources;

import app.groupsync.dev.entities.User;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class UserResourceTest {

    @BeforeEach
    @Transactional
    void setup() {
        User.deleteAll();
    }

    User createTestUser() {
        return User.create("Jongo", "Jängo", "2000-09-15");
    }

    @Test
    void userRegister() {
        String birthday = LocalDateTime.now().toString();
        given()
                .when()
                .formParams("firstName", "Jimmy")
                .formParams("lastName", "Choo")
                .formParams("birthday", birthday)
                .post("/user/register")
                .then()
                .statusCode(200)
                .body("firstname", is("Jimmy"))
                .body("lastname", is("Choo"))
                .body("birthday", is(birthday));
    }

    @Test
    void getAllUsers() {
        int userCount = 2;
        for (int i = 0; i < userCount; i++) {
            createTestUser();
        }
        given()
                .when()
                .get("/user/getAll")
                .then()
                .statusCode(200)
                .body("$.size()", is(userCount));
    }

    @Test
    void getUserByUuid() {
        User user1 = createTestUser();
        given()
                .when()
                .formParams("uuid", user1.getUuid())
                .post("/user/getById")
                .then()
                .statusCode(200)
                .body("uuid", is(user1.getUuid()));
    }
}
