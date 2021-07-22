package app.groupsync.dev;

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
                .formParams("firstName", "Peter", "lastName", "Huber", "birthday", LocalDateTime.now().toString()).post("/user/register")
                .then()
                .statusCode(200);
    }
}
