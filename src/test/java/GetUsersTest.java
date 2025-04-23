import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetUsersTest {
    @Test
    public void verifyGetUsersAPI() {
        RestAssured
                .given()
                .baseUri("https://reqres.in/api")
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data", notNullValue());
    }
}