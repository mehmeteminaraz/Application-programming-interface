package com.techproed.day07;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest11 extends JsonPlaceHolderTestBase {

    @Test
    public void test(){

        spec01.pathParams("parametre1", "todos",
                "parametre2",2);

        HashMap<String,Object> expectedData = new HashMap<String,Object>();

                expectedData.put("statusCode",200);
                expectedData.put("Via","1.1 vegur");
                expectedData.put("Server","cloudflare");
                expectedData.put("userId",1);
                expectedData.put("completed",false);
                expectedData.put("title","quis ut nam facilis et officia qui");
        System.out.println("expectedData = " + expectedData);
        System.out.println("==============================================================");
        Response response = given().accept("application/json").spec(spec01).when().get("/{parametre1}/{parametre2}");

        response.prettyPrint();


    }


}
