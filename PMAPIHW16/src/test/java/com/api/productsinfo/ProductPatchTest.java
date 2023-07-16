package com.api.productsinfo;

import com.api.bestbuytestbase.TestBase;
import com.api.model.ProductsPojo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPatchTest extends TestBase {
@Test// Upate product with patch

    public void updateProductWithPatch(){
    ProductsPojo productsPojo = new ProductsPojo();
    productsPojo.setModel("Alkaline batteries");
    productsPojo.setType("RangeRover");
    productsPojo.setPrice(699);
    productsPojo.setUpc("123456789145");
    given()
            .log().all()
            .header("Content-Type", "application/json")
            .pathParams("id","9999687")
            .when()
            .body(productsPojo)
            .patch("/{id}")
            .then().log().all().statusCode(200);
}
}
