package com.techproed.day05;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_Get_BodyTekrarlardanKurtulma {
    @Test
    public void get01() {
        /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,

                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"Susan",
                    ve "lastname“in, "Jackson",
                    ve "totalprice“in,612,
                    ve "depositpaid“in,false,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */

        // 1- request url ve body'sini olusturalim

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Soruda varsa expected data olustur
        // 3- Response objesi olustur ve request'i gonderip response'i kaydet

        Response response= given().when().get(url);
        response.prettyPrint();

        // 4- Assertion

       /* response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", Matchers.equalTo("Jim")).
                body("lastname", Matchers.equalTo("Smith")).
                body("totalprice", Matchers.equalTo(399)).
                body("depositpaid", Matchers.equalTo(true));

        // once body'lerden kurtulalim
        response.
                then().
                assertThat().
                body("firstname",Matchers.equalTo("Jim"),
                        "lastname",Matchers.equalTo("Smith"),
                        "totalprice",Matchers.equalTo(399),
                        "depositpaid",Matchers.equalTo(true));
        */

        // Matchers'dan kurtulalim

        response.
                then().
                assertThat().
                body("firstname",equalTo("Jim"),
                        "lastname", equalTo("Smith"),
                        "totalprice", equalTo(399),
                        "depositpaid", equalTo(true));

    }
}
