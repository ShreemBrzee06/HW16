package com.api.productsinfo;

import com.api.bestbuytestbase.TestBase;
import com.api.model.ProductsPojo;
import io.restassured.response.Response;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ProductPostTest extends TestBase {
    static int idNumber;
    @Test//create product and retrieve id
    public void createProduct(){
        ArrayList<String>products = new ArrayList<>();
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("Test Batteries");
        productsPojo.setType("Alkaline batteries");
        productsPojo.setPrice(599);
        productsPojo.setShipping(0);
        productsPojo.setUpc("123456789145");
        productsPojo.setDescription("4-pack AA alkaline batteries; battery tester included");
        productsPojo.setManufacturer("Tata");
        productsPojo.setModel("nano");
        productsPojo.setUrl("http://www.bestbuy.com/site/energizer-max-batteries-aa-4-pack/150115.p?id=1051384046217&skuId=150115&cmp=RMXCC");

       Response response= given()
                .log().all()
                .header("Content-Type","application/json")
                .when()
                .body(productsPojo)
                .post();
               response .then()
                .log().all().statusCode(201);
               idNumber=response.then().extract().path("id");
        System.out.println(idNumber);
    }


}
