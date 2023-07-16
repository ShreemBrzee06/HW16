package com.api.storeinfo;

import com.api.bestbuytestbase.StoreTestBase;
import com.api.model.StorePojo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StorePatchTest extends StoreTestBase {

    @Test// update details with patchTest
    public void patchTest(){
        StorePojo storePojo = new StorePojo();

        storePojo.setName("Tata Consultancy ltd");
        storePojo.setAddress("123458 Test Road");
        storePojo.setAddress2(" ");
        storePojo.setCity("Test");
        storePojo.setState("Test");
        storePojo.setType("Nano");
        storePojo.setZip("5253");


        given()
                .log().all()
                .pathParams("id", "8928")
                .body(storePojo)
                .when()
                .patch("/{id}")
                .then().log().all().statusCode(200);
    }
}
