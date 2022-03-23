package com.techproed.day04;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static io.restassured.RestAssured.given;

public class GetRequest02 {

    @Test
            public void test01(){
        String url="https://restful-booker.herokuapp.com/booking/";

        Response response =given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json");

    }

@Test
    public void test02(){

        String url="https://restful-booker.herokuapp.com/booking/101";

      Response response=given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();

        response.then().assertThat().statusCode(404);
    Assert.assertTrue(response.asString().contains("Not Found"));
    Assert.assertFalse(response.asString().contains("API"));
}


}
