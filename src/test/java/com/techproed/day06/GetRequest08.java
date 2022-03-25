package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest08 extends DummyTestBase {

    @Test
    public void test() {

        spec03.pathParams("parametre1", "employees");

        Response response = given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parametre1}");

        response.prettyPrint();


        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getList("data.employee_name"));
        System.out.println(jsonPath.getString("data.employee_name"));


    }

}

