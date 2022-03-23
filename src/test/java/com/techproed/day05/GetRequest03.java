package com.techproed.day05;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest03 {

    @Test
    public void test01(){

        //{
        //    "firstname": "Jim",
        //    "lastname": "Jackson",
        //    "totalprice": 688,
        //    "depositpaid": true,
        //    "bookingdates": {
        //        "checkin": "2016-04-25",
        //        "checkout": "2020-03-24"
        //    },
        //    "additionalneeds": "Breakfast"
        //}

        String url="https://restful-booker.herokuapp.com/booking/7";

        Response response =given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();

        /*
       response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Jim")).
                body("lastname",Matchers.equalTo("Jackson")).
                body("totalprice",Matchers.equalTo(688)).
                body("depositpaid", Matchers.equalTo(true)).
                body("bookingdates.checkin", Matchers.equalTo("2016-04-25"))
                .body("bookingdates.checkout", Matchers.equalTo("2020-03-24"));
         */

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", equalTo("Jim"),
                        "lastname",equalTo("Jackson"),
                        "totalprice",equalTo(688),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2016-04-25"),
                        "bookingdates.checkout",equalTo("2020-03-24"));
    }


}
