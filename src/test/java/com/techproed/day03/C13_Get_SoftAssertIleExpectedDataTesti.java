package com.techproed.day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

Response Body
{
"status":"success",
"data":{
"id":3,
"employee_name":"Ashton Cox",
"employee_salary":86000,
"employee_age":66,
"profile_image":""
},
"message":"Successfully! Record has been fetched."
}

     */
@Test
public void get01(){
    // 1 - Url ve body
    String url = "http://dummy.restapiexample.com/api/v1/employee/3";

    // 2- Expected Data
    JSONObject dataBody = new JSONObject();
    JSONObject expData = new JSONObject();

    dataBody.put("id",3);
    dataBody.put("employee_name","Ashton Cox");
    dataBody.put("employee_salary",86000);
    dataBody.put("employee_age",66);
    dataBody.put("profile_image","");

    expData.put("status","success");
    expData.put("data",dataBody);
    expData.put("message","Successfully! Record has been fetched.");

    // 3- Response

    Response response = given().when().get(url);
    response.prettyPrint();

    // 4- Assertion
    JsonPath respJsPath = response.jsonPath();

    SoftAssert softAssert = new SoftAssert();


    softAssert.assertEquals(respJsPath.get("status"),expData.get("status"),"Status Testi calismadi");
    softAssert.assertEquals(respJsPath.get("data.id"),
                            expData.getJSONObject("data").get("id"));
    softAssert.assertEquals(respJsPath.get("data.employee_name"),
                            expData.getJSONObject("data").get("employee_name"));
    softAssert.assertEquals(respJsPath.get("data.employee_salary"),
                            expData.getJSONObject("data").get("employee_salary"));
    softAssert.assertEquals(respJsPath.get("data.employee_age"),
                            expData.getJSONObject("data").get("employee_age"));
    softAssert.assertEquals(respJsPath.get("data.profile_image"),
                            expData.getJSONObject("data").get("profile_image"));
    softAssert.assertEquals(respJsPath.get("message"),expData.get("message"));


    softAssert.assertAll();

}
}
