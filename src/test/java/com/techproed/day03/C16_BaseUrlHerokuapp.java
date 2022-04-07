package com.techproed.day03;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class C16_BaseUrlHerokuapp extends HerokuAppBaseUrl {
    /*
    Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
     */
    @Test
    public void test01(){
        /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
request gonderdigimizde donen response’un status code’unun 200 oldugunu
ve Response’ta 48 booking oldugunu test edin
         */

        // 1 - Url Ve Body
        specHerokuApp.pathParam("pp1","booking");

        // 2 - Expectedn Data
        // 3 - Response
        Response response= given().
                            spec(specHerokuApp).
                            when().
                            get("/{pp1}");
        response.prettyPrint();
        // 4 - Assertion
        response.then().assertThat().statusCode(200).body("bookingid", hasSize(24 ));
    }
    @Test
    public void test02(){
        /*
        2- https://restful-booker.herokuapp.com/booking endpointine asagidaki
 body’ye sahip bir POST request gonderdigimizde donen response’un status
 code’unun 200 oldugunu ve “firstname” degerinin “Ali” oldugunu test edin

      {
      "firstname" : "Ali",
      "lastname" : “Bak",
      "totalprice" : 500,
      "depositpaid" : false,
      "bookingdates" : {
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
                    },
      "additionalneeds" : "wi-fi"
       }

         */


        // 1- Url ve body olustur
        specHerokuApp.pathParam("pp1","booking");

        JSONObject requestBody =new JSONObject();
        JSONObject innerBody= new JSONObject();

        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        requestBody.put("firstname","Ali");
        requestBody.put("lastname","Bak");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",innerBody);
        requestBody.put("additionalneeds","wi-fi");

        // 2 - Expected Data
        // 3 - Response
        Response response = given().
                                spec(specHerokuApp).
                                contentType(ContentType.JSON).
                            when().
                                body(requestBody.toString()).
                                post("/{pp1}");
        response.prettyPrint();
        // 4 - Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("booking.firstname",equalTo("Ali"));

    }
}
