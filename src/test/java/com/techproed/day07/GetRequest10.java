package com.techproed.day07;

import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest10 extends DummyTestBase {

    @Test
    public void test() {

        spec03.pathParam("parametre1", "employees");

        Response response = given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parametre1}");

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(200, response.getStatusCode());

        List<Integer> idList = jsonPath.getList("data.findAll{it.id>10}.id");
        System.out.println("idList = " + idList);

        Assert.assertEquals(14,idList.size());

        List<Integer> yasListesi = jsonPath.getList("data.findAll{it.employee_age<30}.id");
        System.out.println("yasListesi = " + yasListesi);

        Collections.sort(yasListesi);
        Assert.assertEquals((Integer) 24,yasListesi.get(yasListesi.size()-1));       // 1.Kullanim Sekli
        Assert.assertEquals(  24,(int)yasListesi.get(yasListesi.size()-1));  // 2.Kullanim Sekli

        List<String> isimListesi=jsonPath.getList("data.findAll{it.employee_salary>350000}.employee_name");
        System.out.println("isimListesi = " + isimListesi);

        Assert.assertTrue(isimListesi.contains("Charde Marshall"));

    }
}


