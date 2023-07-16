package com.api.productsinfo;

import com.api.bestbuytestbase.TestBase;
import com.api.model.ProductsPojo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsDeleteTest extends TestBase {
    @Test//delete the product
    public void deleteProductsTest() {
        ProductsPojo productsPojo = new ProductsPojo();
        given()
                .log().all()
                .pathParams("id","9999687")
                .when()
                .delete("/{id}")
                .then().log().all().statusCode(200);
    }

}
