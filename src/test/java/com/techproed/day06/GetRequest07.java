package com.techproed.day06;

import com.techproed.testBase.HerokuAppTestBase;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest07 extends HerokuAppTestBase {

    

    @Test
    public void test01() {



        spec02.pathParams("parametre1", "booking",
                "parametre2",5);

        Response response =given().
                accept("application/json").
                spec(spec02).
                get("/{parametre1}/{parametre2}");

        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

       // Assert.assertEquals(200, response.getStatusCode());

        Assert.assertEquals("Jim",jsonPath.getString("firstname"));
        Assert.assertEquals("Wilson",jsonPath.getString("lastname"));
        Assert.assertEquals(888,jsonPath.getInt("totalprice"));
        Assert.assertEquals(false,jsonPath.getBoolean("totalprice"));
        Assert.assertEquals("2018-03-20",jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals("2020-09-07",jsonPath.getString("bookingdates.checkout"));



    }


}
