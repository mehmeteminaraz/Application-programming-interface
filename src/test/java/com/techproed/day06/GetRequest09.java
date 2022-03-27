package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest09 extends DummyTestBase {

    @Test
    public void test(){
        spec03.pathParams("parmetre1", "employees");

        Response response = given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parmetre1}");

        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(200,response.getStatusCode());
        //Assert.assertTrue(response.getStatusCode()==200);

        System.out.println(jsonPath.getList("data.id").size());
        Assert.assertEquals(24,jsonPath.getList("data.id").size());
        Assert.assertEquals("Airi Satou",jsonPath.getString("data[4].employee_name"));
        Assert.assertEquals(372000,jsonPath.getInt("data[5].employee_salary"));

        Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Rhona Davidson"));

        //List<Integer> arananyaslar= Arrays.asList(21,23,61);

        List<Integer> arananyaslar=new ArrayList<Integer>();
        arananyaslar.add(21);
        arananyaslar.add(23);
        arananyaslar.add(61);

        Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(arananyaslar));


    }


}
