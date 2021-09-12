package api_tests;

import endpoints.ReqresURL;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API_get_AFE_tests {
    int id = 23;

    @Test(description = "a single resource is not found")
    public void singleResourceNotFoundTest() {
        given()
                .when()
                .get(String.format(ReqresURL.reqresURL + "api/unknown/%d", id))
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().body();
    }

    @Test (description = "a user is not found")
    public void singleUserNotFoundTest() {
        given()
                .when()
                .get(String.format(ReqresURL.reqresURL+ "api/users/%d", id))
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().body();
    }
}
