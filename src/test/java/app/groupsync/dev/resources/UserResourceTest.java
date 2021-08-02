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
        given()
                .when()
                .formParams("firstName", "Jimmy", "lastName", "Choo", "birthday", LocalDateTime.now().toString())
                .post("/user/register")
                .then()
                .statusCode(200);
    }

    @Test
    void getAllUsers() {
        for (int i = 0; i < 2; i++) {
            createTestUser();
        }
        given()
                .when()
                .get("/user/getAll")
                .then()
                .statusCode(200)
                .body("$.size()", is(2));
    }

    @Test
    void getUserByUuid() {
        User user1 = createTestUser();
        given()
                .when()
                .formParams("uuid", user1.getUuid())
                .post("/user/getById")
                .then()
                .statusCode(200);
    }
}
