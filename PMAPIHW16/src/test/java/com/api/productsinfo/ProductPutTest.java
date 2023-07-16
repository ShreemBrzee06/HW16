package com.api.productsinfo;

import com.api.bestbuytestbase.TestBase;
import com.api.model.ProductsPojo;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ProductPutTest extends TestBase {

    @Test
    public void updateTheProductDetailsWithPut() {
        ProductsPojo productsPojo = new ProductsPojo();
        ArrayList<String> products = new ArrayList<>();

        productsPojo.setName("Duracell - AA 1.5V CopperTop Batteries (4-Pack)");
        productsPojo.setType("HardGood");
        productsPojo.setPrice(899);
        productsPojo.setUpc("125487963212");
        productsPojo.setShipping(0);
        productsPojo.setDescription("4-pack AA alkaline batteries; battery tester included");
        productsPojo.setManufacturer("TataConsultancy");
        productsPojo.setModel("RangeRover");
        productsPojo.setUrl("http://www.bestbuy.com/site/energizer-max-batteries-aa-4-pack/150115.p?id=1051384046217&skuId=150115&cmp=RMXCC");

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParams("id","9999687")
                .body(productsPojo)
                .when()
                .put("/{id}")
                .then().log().all().statusCode(200);
    }
}
