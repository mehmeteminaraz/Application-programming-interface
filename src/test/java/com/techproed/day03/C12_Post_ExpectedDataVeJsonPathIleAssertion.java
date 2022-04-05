package com.techproed.day03;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

    @Test
    public void postTest (){
        /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }
    	            	Response Body
    	            	{
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }
         */

        // 1- Request icin url ve body olustur

        String url= "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody =new JSONObject();
        JSONObject innerBody= new JSONObject();

        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("additionalneeds","wi-fi");
        requestBody.put("bookingdates",innerBody);
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("lastname","Bulut");

        // 2- Expected Datayi olustur

        JSONObject bookingDatesBody = new JSONObject();
        JSONObject bookingBody = new JSONObject();
        JSONObject expData = new JSONObject();

        bookingDatesBody.put("checkin","2021-06-01");
        bookingDatesBody.put("checkout","2021-06-10");

        bookingBody.put("firstname","Ahmet");
        bookingBody.put("lastname","Bulut");
        bookingBody.put("totalprice",500);
        bookingBody.put("depositpaid",false);
        bookingBody.put("bookingdates",bookingDatesBody);
        bookingBody.put("additionalneeds","wi-fi");

        expData.put("bookingId",24);
        expData.put("booking",bookingBody);

        // 3- Response olustur, request gonderip donen response'i kaydet

        Response response = given().
                                contentType(ContentType.JSON).
                                when().
                                body(requestBody.toString()).
                                post(url);

        response.prettyPrint();

        // 4 - Assertion

            // Assert methodu kullanacaksak once response'i JsonPath objesine cevirmeliyiz

        JsonPath respJSPath = response.jsonPath();

        Assert.assertEquals("Firstname Testi calismadi",expData.getJSONObject("booking").get("firstname"),respJSPath.get("booking.firstname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("lastname"),respJSPath.get("booking.lastname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("totalprice"),respJSPath.get("booking.totalprice"));
        Assert.assertEquals(expData.getJSONObject("booking").get("depositpaid"),respJSPath.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                            respJSPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                            respJSPath.get("booking.bookingdates.checkout"));
        Assert.assertEquals(expData.getJSONObject("booking").get("additionalneeds"),respJSPath.get("booking.additionalneeds"));

    }
}
