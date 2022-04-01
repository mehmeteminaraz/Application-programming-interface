package com.techproed.day03;


import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
    @Test
    public void get01(){
        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */

        // 1 - Request url ve body'sini hazirlamak

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2 - Expected Data'yi hazirla
        // 3 - Response'u kaydet

        Response response = given().when().get(url);
        response.prettyPrint();

        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Content Type : " + response.getContentType());
        System.out.println("Server header degeri : " + response.getHeader("Server"));
        System.out.println("Status Line : " + response.getStatusLine());
        System.out.println("Response suresi : " + response.getTime());



    }
}
