package app.groupsync.dev;

import app.groupsync.dev.entities.User;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

@QuarkusTest
class UserResourceTest {

    @BeforeEach
    @Transactional
    void setup() {
        User.deleteAll();
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
}
