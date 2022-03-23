package com.techproed.day05;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest04 {

    @Test
    public void test01() {



        String url = "https://restful-booker.herokuapp.com/booking/5";

        Response response =given().accept("application/json").when().get(url);
        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Mary"),
                        "totalprice",Matchers.equalTo(230),
                        "bookingdates.checkin",Matchers.equalTo("2021-05-29"));
    }

}
