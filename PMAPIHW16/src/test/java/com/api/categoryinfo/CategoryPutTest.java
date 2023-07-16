package com.api.categoryinfo;

import com.api.bestbuytestbase.CategoryTestBase;
import com.api.model.CategoryPojo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoryPutTest extends CategoryTestBase {
    @Test
    public void putTestForCategory(){
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setName("Shiva");
        categoryPojo.setId("mn5555");
        given()
                .pathParam("id","mn5555")
                .when()
                .get("/{id}")
                .then().log().all().statusCode(200);

    }
}
