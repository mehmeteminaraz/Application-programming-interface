package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
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

        //  response.prettyPrint();


        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getList("data.employee_name"));   // 1.Kullanim Sekli
        //System.out.println(jsonPath.getString("data.employee_name")); // 2.Kullanim Sekli

        System.out.println(jsonPath.getString("data[2].employee_name")); // 1.Kullanim Sek
        //System.out.println(jsonPath.getString("data.employee_name[2]")); // 2.Kullanim Sekli

        System.out.println(jsonPath.getString("data.employee_name[0,1,2,3,4]"));
        System.out.println(jsonPath.getString("data.employee_name[-1]")); // 1.Kullanim Sekli
        //System.out.println(jsonPath.getString("data[-1].employee_name")); // 2.Kullanim Sekli

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("Ashton Cox",jsonPath.getString("data[2].employee_name"));
        Assert.assertEquals("Doris Wilder",jsonPath.getString("data[-1].employee_name"));

    }

}

