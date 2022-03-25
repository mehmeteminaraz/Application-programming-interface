package com.techproed.day03;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
public class C4_Put_ResponseBilgileriAssertion {
    @Test
    public void put01(){
        /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde
{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}
donen Response’un,
 	status code’unun 200,
	ve content type’inin application/json; charset=utf-8,
	ve Server isimli Header’in degerinin cloudflare,
	ve status Line’in HTTP/1.1 200 OK

         */

        // 1- Reguest Url ve body'sini hazirlamak

        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        // 2- Expected data hazirla
        // 3- Response'u kaydet
        Response response = given().accept(ContentType.JSON).when().body(reqBody.toString()).put(url);

        response.prettyPrint();
        // 4- Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("cemile").
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");

    }


}
