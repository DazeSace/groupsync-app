package app.groupsync.dev.resources;

import app.groupsync.dev.entities.Offer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

import javax.transaction.Transactional;

import static io.restassured.RestAssured.given;

@QuarkusTest
class OfferResourceTest {

    @BeforeEach
    @Transactional
    void setup() {
        Offer.deleteAll();
    }

    Offer createTestOffer(String offerer, String name) {
        return Offer.create(offerer, name, 5, 4.5, 4.5, "Konstanz");
    }

    @Test
    void offerCreate() {
        given()
                .when()
                .formParams("offerer", "DB")
                .formParams("name", "BW-Ticket")
                .formParams("capacity", 4)
                .formParams("price", 4.5)
                .formParams("length", 4)
                .formParams("location", "Konstanz")
                .post("/offer/create")
                .then()
                .statusCode(200)
                .body("offerer", is("DB"));
    }

    @Test
    void getAllOffers() {
        Offer offer1 = createTestOffer("DB", "Corelli");
        Offer offer2 = createTestOffer("SUP", "Paddel");
        given()
                .when()
                .get("/offer/getAll")
                .then()
                .statusCode(200)
                .body("$.size()", is(2))
                .body("[0].offerer", is(offer1.getOfferer()))
                .body("[1].offerer", is(offer2.getOfferer()));
    }

    @Test
    void getOfferByUuid() {
        String uuid = createTestOffer("DB", "Corelli").getUuid();
        given()
                .when()
                .formParams("uuid", uuid)
                .post("/offer/getById")
                .then()
                .statusCode(200)
                .body("uuid", is(uuid));
    }
}
