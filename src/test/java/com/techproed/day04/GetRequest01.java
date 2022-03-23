package com.techproed.day04;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    @Test
    public void test01() {

        String url = "https://restful-booker.herokuapp.com/booking/3";

        Response response = given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();

        System.out.println("StatusCode:" + response.getStatusCode());
        System.out.println("ContentType:" + response.getContentType());
        System.out.println("StatusLine:" + response.getStatusLine());
        System.out.println("===================================================");
        System.out.println("response.getHeaders() = " + response.getHeaders());
        System.out.println("===================================================");

       // Assert.assertEquals(200, response.getStatusCode());
       // Assert.assertEquals("application/json; charset=utf-8", response.getContentType());
       // Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
       // System.out.println("===================================================");
        System.out.println("===================================================");

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").statusLine("HTTP/1.1 200 OK");
      //  System.out.println("===================================================");
    }


}
