package com.api.storeinfo;

import com.api.bestbuytestbase.StoreTestBase;
import com.api.model.StorePojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StorePostTest extends StoreTestBase {
    static int idNumber;
    @Test// create a post for store
    public void test001(){
        StorePojo storePojo = new StorePojo();
        storePojo.setName("Tata Consultancy");
        storePojo.setAddress("123458 Test Road");
        storePojo.setAddress2(" ");
        storePojo.setCity("Test");
        storePojo.setState("NY");
        storePojo.setType("Nano");
        storePojo.setZip("5203");

        Response response = given()
                .log().all()
                .header("Content-Type","application/json")
                .body(storePojo)
                .when()
                .post();
        response.then().log().all().statusCode(201);
       idNumber= response.then().extract().path("id");
        System.out.println(idNumber);
    }
    @Test// get store by id
    public void test002(){
        given()
                .log().all()
                .pathParams("id",idNumber)
                .when()
                .get("/{id}")
                .then().log().all().statusCode(200);
    }
}
