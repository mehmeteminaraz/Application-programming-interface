package com.techproed.day05;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest05 {

    @Test
    public void test(){

        String url="http://dummy.restapiexample.com/api/v1/employees";

        Response response =given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("data.id",hasSize(24),
                        "data.employee_name",hasItem("Aston Cox"),
                        "data.employee_age",hasItems(21,61,23));


    }
}
