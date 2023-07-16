package com.api.categoryinfo;

import com.api.bestbuytestbase.CategoryTestBase;
import com.api.model.CategoryPojo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoryPostTest extends CategoryTestBase {

    @Test
    public void postTestForCatergory() {
        CategoryPojo categoryPojo = new CategoryPojo();

        categoryPojo.setName("Ganesha");
        categoryPojo.setId("mn5555");

        given()
                .header("Content-Type","application/json")
                .body(categoryPojo)
                .when()
                .post()
                .then().log().all().statusCode(201);

    }

    @Test

    public void getById(){
        given()
                .pathParam("id","mn5555")
                .when()
                .get("/{id}")
                .then()
                .log().all().statusCode(200);


    }
}
