package com.api.storeinfo;

import com.api.bestbuytestbase.StoreTestBase;
import com.api.model.StorePojo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreDeleteTest extends StoreTestBase {

    @Test// delete request using id
    public void deleteStoreRequestById() {
        StorePojo storePojo = new StorePojo();
        given()
                .log().all()
                .pathParam("id","8928")
                .when()
                .delete("/{id}")
                .then().log().all().statusCode(404);

    }
}