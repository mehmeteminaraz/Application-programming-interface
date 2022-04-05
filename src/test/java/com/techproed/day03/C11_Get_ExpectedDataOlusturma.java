package com.techproed.day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
   Response body :
{
"userId":3,
"id":22,
"title":"dolor sint quo a velit explicabo quia nam",
"body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}

     */
    @Test
    public void getTesti() {
        // 1- Request url olustur
        String url = "https://jsonplaceholder.typicode.com/posts/22";
        // 2- Expected Data hazirla

        JSONObject expData = new JSONObject();
        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3- Response kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion

        //Oncelikle yapilmasi gereken response'u JsonPath objesine cevirmek

        JsonPath respJSPath = response.jsonPath();
        respJSPath.prettyPrint();

        Assert.assertEquals(expData.get("userId"), respJSPath.get("userId"));
        Assert.assertEquals(expData.get("id"), respJSPath.get("id"));
        Assert.assertEquals(expData.get("title"), respJSPath.get("title"));
        Assert.assertEquals(expData.get("body"), respJSPath.get("body"));

    }

}