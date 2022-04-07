package com.techproed.day03;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C15_BaseUrlDummyRestapi extends JsonPlaceHolderBaseUrl {

    //Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    @Test
    public void test01() {
        /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
 request gonderdigimizde donen response’un status code’unun 200 oldugunu
 ve Response’ta 100 kayit oldugunu test edin
         */

        // 1- Request Url ve body olustur

        specJsonPlace.pathParam("pp1", "posts");

        // Framework'umuzu dinamik yapmak ve base url'de bir degisiklik oldugunda
        // tek tek tum tast class'larini incelemek yerine sadece BaseUrl class'ina
        // gidip oradan gerekli degisikligi yapmak icin bu yontem tercih edilir

        // 2- Expected Data
        // 3- Response
        Response response = given().
                spec(specJsonPlace).
                when().
                get("/{pp1}");

        response.prettyPrint();

        // 4- Assertions
        response.
                then().
                assertThat().
                statusCode(200).
                body("title", hasSize(100));

    }

    @Test
    public void test02() {
        /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
request gonderdigimizde donen response’un status code’unun 200 oldugunu
ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
         */

        // 1 - Url ve body olustur

        specJsonPlace.pathParams("pp1", "posts", "pp2", 44);

        // 2 - Expected Data
        // 3 - Response
        Response response = given().
                spec(specJsonPlace).
                when().
                get("/{pp1}/{pp2}");
        response.prettyPrint();
        // 4 - Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("title", equalTo("optio dolor molestias sit"));

    }

    @Test
    public void test03() {
        /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
response body’sinin null oldugunu test edin
         */

        // 1 - Url ve Body
        specJsonPlace.pathParams("pp1", "posts", "pp2", 50);

        // 2 - Expected Data
        // 3 - Response
        Response response = given().
                spec(specJsonPlace).
                when().
                delete("/{pp1}/{pp2}");

        // 4 - Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("id", nullValue());
    }

}
