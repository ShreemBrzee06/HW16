package com.api.storeinfo;

import com.api.bestbuytestbase.StoreTestBase;
import com.api.model.StorePojo;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import org.junit.Test;

import static com.api.storeinfo.StorePostTest.idNumber;
import static io.restassured.RestAssured.given;

public class StorePutTest extends StoreTestBase {

@Test// get store with id and update with id

    public void updateWithStoreId(){


    StorePojo storePojo = new StorePojo();

    /*storePojo.setName("DevRishi Consultancy");
    storePojo.setAddress("123458 Test Road");
    storePojo.setAddress2(" ");
    storePojo.setCity("city");
    storePojo.setState("NY");
    storePojo.setType("IT");
    storePojo.setZip("5555");*/

    storePojo.setName("Tata Consultancy");
    storePojo.setAddress("5555 Test Road");
    storePojo.setCity("Test City");
    storePojo.setType("nano");
    storePojo.setState("NY");
    storePojo.setZip("8787");

   Response response = given()
            .log().all()
            .header("Content-Type", "application/json")
            .pathParam("id", "8928")
            .body(storePojo)
            .put("/{id}");
          response  .then()
            .statusCode(200);

}
}
