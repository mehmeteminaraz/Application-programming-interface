package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest08 extends DummyTestBase {

    @Test
    public void test(){

    spec03.pathParams("parametre1","employees");

    Response response=given().
            accept("appl'cation/json").
            spec(spec03).
            when().
            get("/{parametre1}");

    response.prettyPrint();


    }

}

