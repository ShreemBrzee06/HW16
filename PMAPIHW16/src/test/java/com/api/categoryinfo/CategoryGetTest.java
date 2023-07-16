package com.api.categoryinfo;

import com.api.bestbuytestbase.CategoryTestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoryGetTest extends CategoryTestBase {
    @Test
    public void getTestForCategory(){
        given()
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    public void getLimitTestForCategory(){
        given()
                .queryParam("$limit","1")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    @Test
    public void getSkipTestForCategory(){
        given()
                .queryParam("$skip","10")
                .when()
                .get().then()
                .log().all().statusCode(200);
    }


}
