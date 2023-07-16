package com.api.categoryinfo;

import com.api.bestbuytestbase.CategoryTestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoryDeleteTest extends CategoryTestBase {

    @Test
    public void deleteTestForCategory(){
        given()
                .pathParam("id","mn5555")
                .when()
                .delete("/{id}")
                .then()
                .log().all().statusCode(200);
    }
}
