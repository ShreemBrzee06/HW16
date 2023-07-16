package com.api.productsinfo;
import com.api.bestbuytestbase.TestBase;
import com.api.model.ProductsPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsCRUDTest extends TestBase {
    static int idNumber;


    @Test// get all list
    public void test01(){
        given()
                .when()
                .log().all()
                .get()
                .then().log().all().statusCode(200);
    }

    @Test//post new and retrieve ID

    public void test02(){
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("Duracell - AA 1.5V CopperTop Batteries (4-Pack)");
        productsPojo.setType("HarGood");
        productsPojo.setPrice(499);
        productsPojo.setUpc("125487963212");
        productsPojo.setShipping(0);
        productsPojo.setDescription("4-pack AA alkaline batteries; battery tester included");
        productsPojo.setManufacturer("nike");
        productsPojo.setModel("nano");
        productsPojo.setUrl("http://www.bestbuy.com/site/energizer-max-batteries-aa-4-pack/150115.p?id=1051384046217&skuId=150115&cmp=RMXCC");

       Response response= given()
                .log().all()
                .header("Content-Type","application/json")
                .when()
                .body(productsPojo)
                .post();

       response.then().statusCode(201);
       idNumber =response.then().extract().path("id");
        System.out.println(idNumber);
    }
    @Test// update id
    public void test03(){
        ProductsPojo productsPojo = new ProductsPojo();
        Response response = given()
                .log().all()
                .header("Content-Type","application/json")
                 .pathParams("id",idNumber)
                 .when()
                 .body(productsPojo)
                 .patch("/{id}");
         response.then().statusCode(200);

    }

    @Test// delete id
    public void test04(){
      Response response=  given()
                .log().all()
                .pathParams("id",idNumber)
                .when()
                .delete("/{id}");
      response.then().statusCode(200);
    }

    @Test// get only 1 by query parameter
    public void test06(){
        given()
                .queryParam("$limit","1")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
}
