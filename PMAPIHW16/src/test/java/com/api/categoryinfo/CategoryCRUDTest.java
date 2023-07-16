package com.api.categoryinfo;

import com.api.bestbuytestbase.CategoryTestBase;
import com.api.model.CategoryPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoryCRUDTest extends CategoryTestBase {
    static String idNumber;
    @Test//get all categories
    public void test001(){
        given()
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test//get a single category with id
    public void test002(){
        given()
                .pathParam("id","abcat0010000")
                .when()
                .get("/{id}")
                .then()
                .log().all().statusCode(200);

    }

    @Test//create a post
    public void test003(){
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setId("q5555");
        categoryPojo.setName("Ganesha");
        Response response = given()
                .header("Content-Type","application/json")
                .body(categoryPojo)
                .when()
                .post();
                response.then().log().all().statusCode(201);
                idNumber= response.then().extract().path("id");
        System.out.println(idNumber);
    }
@Test// update category
    public void test004(){
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setName("Shiva");
        categoryPojo.setId(idNumber);
    Response response = given()
            .header("Content-Type","application/json")
            .pathParam("id",idNumber)
            .body(categoryPojo)
            .when()
            .patch("/{id}");
    response.then().log().all().statusCode(200);
}

@Test//update category
    public void test005(){
    CategoryPojo categoryPojo = new CategoryPojo();
    categoryPojo.setName("Shiva");
    categoryPojo.setId("P5555");
    Response response = given()
            .header("Content-Type","application/json")
            .pathParam("id",idNumber)
            .body(categoryPojo)
            .when()
            .put("/{id}");
    response.then().log().all().statusCode(200);

}

@Test
    public void test006(){
    CategoryPojo categoryPojo = new CategoryPojo();

    Response response = given()
            .header("Content-Type","application/json")
            .pathParam("id",idNumber)
            .body(categoryPojo)
            .when()
            .delete("/{id}");
    response.then().log().all().statusCode(200);


}

}
