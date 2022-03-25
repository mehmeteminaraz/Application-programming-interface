package com.techproed.day03;


import org.json.JSONObject;
import org.junit.Test;

public class C3_JsonObjesiOlusturma {

    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

	{
	"title":"Ahmet",
	"body":"Merhaba",
	"userId":1
	}

    */
    @Test
    public void jsonObjeOlusturma(){
        JSONObject ilkObje = new JSONObject();
        ilkObje.put("title","Ahmet");
        ilkObje.put("body","Merhaba");
        ilkObje.put("userId",1);

        System.out.println(ilkObje);

    }

    @Test
    public void jsonObject2(){
/*
{
     "firstname":"Jim",
     "additionalneeds":"Breakfast",
     "bookingdates":{
             "checkin":"2018-01-01",
             "checkout":"2019-01-01"
	},
      "totalprice":111,
      "depositpaid":true,
      "lastname":"Brown"
 }
 */

        JSONObject innerJson = new JSONObject();
        JSONObject jsonObje = new JSONObject();

        innerJson.put("checkin","2018-01-01");
        innerJson.put("checkout","2019-01-01");

        jsonObje.put("firstname","Jim");
        jsonObje.put("lastname","Brown");
        jsonObje.put("additionalneeds","Breakfast");
        jsonObje.put("bookingdates",innerJson);
        jsonObje.put("totalprice",111);
        jsonObje.put("depositpaid",true);

        System.out.println(jsonObje);

        /*
        {
        "firstname":"Jim",
        "additionalneeds":"Breakfast",
        "bookingdates":{
                        "checkin":"2018-01-01",
                        "checkout":"2019-01-01"},
        "totalprice":111,
        "depositpaid":true,
        "lastname":"Brown"
        }

         */

    }
}
