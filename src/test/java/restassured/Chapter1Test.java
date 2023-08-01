package restassured;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Chapter1Test {

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                statusCode(200);

    }
    @Test
    public void requestUsZipCode90210_checkContentType_expectApplicationJson() {

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                contentType(ContentType.JSON);
    }

    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails() {

        given().
                log().all().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                log().body();
    }

    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetailsm() {

        given().
                log().all().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                assertThat().body("data.last_name", hasItem("Lawson"));
    }

    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetailsmx() {
        String endpoint ="https://reqres.in/api/users?page=2";


            var response = given().
                when().
                get(endpoint).
                then();
            response.log().body();

    }



}