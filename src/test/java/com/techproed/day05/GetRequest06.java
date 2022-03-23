package com.techproed.day05;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest06 {

    @Test
    public void test(){

        String url = "https://jsonplaceholder.typicode.com/todos/123";

        Response response =given().accept("aplication/json").when().get(url);

        response.prettyPrint();

    }

}
