package com.api.storeinfo;

import com.api.bestbuytestbase.StoreTestBase;
import com.api.model.ProductsPojo;
import com.api.model.StorePojo;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.PriorityQueue;

import static io.restassured.RestAssured.given;

public class StoreCRUDTest extends StoreTestBase {
    ProductsPojo productsPojo = new ProductsPojo();
    static int idNumber;

@Test// get all store information
    public void test001(){
    given()
            .log().all()
            .when()
            .get()
            .then().log().all().statusCode(200);
}

@Test//post new and retrieve ID
    public void test002(){
    StorePojo storePojo = new StorePojo();
    storePojo.setName("Minnetonkar");
    storePojo.setAddress("BigBoxer road");
    storePojo.setType("15515 Ridgedale drive");
    storePojo.setAddress2(" ");
    storePojo.setCity("Handlewood");
    storePojo.setState("NY");
    storePojo.setZip("55555");
   Response response = given()
            .log().all()
            .header("Content-Type","application/json")
            .body(storePojo)
            .when()
            .post();
            response.then().log().all().statusCode(201);
        idNumber=    response.then().extract().path("id");
    System.out.println(idNumber);

}

@Test//update id
    public void test003(){
    StorePojo storePojo = new StorePojo();
    storePojo.setName("Pizza Hut");
    storePojo.setAddress("BigBoxer road");
    storePojo.setAddress2(" ");
    storePojo.setCity("Handlewood");
    storePojo.setType("125424 example road");
    given()
            .log().all()
            .header("Content-Type","application/json")
            .pathParams("id",idNumber)
            .when()
            .patch("/{id}")
            .then().log().all().statusCode(200);


}

@Test// delete id
    public void test004(){
   Response response= given()
            .log().all()
            .pathParams("id",idNumber)
            .when()
            .delete("/{id}");
           response .then().log().all().statusCode(200);
           response.then().extract().path("id");

}
@Test// retrieve ID and validate that id has been deleted
    public void test005(){
    given()
            .log().all()
            .pathParams("id",idNumber)
            .when()
            .get("/{id}")
            .then().log().all().statusCode(404);
}

}
