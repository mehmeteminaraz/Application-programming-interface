package com.techproed.day04;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JsonPathKullanimi {

    @Test
    public void jsonObjesiOlusturma(){

        JSONObject kisiBilgisi = new JSONObject();
        JSONObject adresBilgisi = new JSONObject();

        JSONObject cepTel = new JSONObject();
        JSONObject evTel = new JSONObject();

        JSONArray telbilgileri = new JSONArray();

        // Once tel bilgilerini iki JSON objesine ekliyoruz

        cepTel.put("type","Cep Telefonu");
        cepTel.put("number","555-123-4567");

        evTel.put("type","Ev telefonu");
        evTel.put("number","312-123-4567");

        telbilgileri.put(cepTel);
        telbilgileri.put(evTel);

        // Adres Json objesini olusturalim

        adresBilgisi.put("streetAddress","Yenimahalle Kurtulus Cad.");
        adresBilgisi.put("city","Ankara");
        adresBilgisi.put("postalCode","06100");

        // Kisi Bilgisi objesini olusturabiliriz

        kisiBilgisi.put("firstName","Ali");
        kisiBilgisi.put("lastName","Bak");
        kisiBilgisi.put("age",25);
        kisiBilgisi.put("address",adresBilgisi);
        kisiBilgisi.put("phoneNumbers",telbilgileri);

        System.out.println(kisiBilgisi);

        /*
        {
        "firstName":"Ali",
        "lastName":"Bak",
        "address":
                 {
                 "streetAddress":"Yenimahalle Kurtulus Cad.",
                 "city":"Ankara",
                 "postalCode":"06100"},
        "age":25,
        "phoneNumbers":[
                          {
                             "number":"555-123-4567",
                             "type":"Cep Telefonu"
                             },
                          {
                              "number":"312-123-4567",
                              "type":"Ev telefonu"
                              }
                         ]
        }
        */


    // Olusturdugumuz kompleks JSON objesindeki degerlere NASIL ULASABILIRIZ?

        System.out.println("Isim : " + kisiBilgisi.get("firstName") );
        System.out.println("Soyisim : " + kisiBilgisi.get("lastName"));
        System.out.println("Yas : " + kisiBilgisi.get("age"));

        System.out.println("Cadde adresi : " + kisiBilgisi.getJSONObject("address").get("streetAddress"));
        System.out.println("Sehir : " + kisiBilgisi.getJSONObject("address").get("city"));
        System.out.println("Posta kodu : " + kisiBilgisi.getJSONObject("address").get("postalCode"));

        System.out.println("Cep Tel No : " + kisiBilgisi.
                                                getJSONArray("phoneNumbers").
                                                getJSONObject(0).
                                                get("number"));

        System.out.println("Ev Tel No : " + kisiBilgisi.
                                                getJSONArray("phoneNumbers").
                                                getJSONObject(1).
                                                get("number"));
    }
}
