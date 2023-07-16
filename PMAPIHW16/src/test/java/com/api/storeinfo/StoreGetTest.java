package com.api.storeinfo;

import com.api.bestbuytestbase.StoreTestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreGetTest extends StoreTestBase {
 @Test// get all the store data
    public void test001(){
     given()
             .when()
             .get()
             .then().log().all()
             .statusCode(200);

 }

 @Test// limit number of store per query
    public void test002(){
     given()
             .log().all()
             .queryParam("$limit","2")
             .when()
             .get()
             .then().log().all().statusCode(200);
 }

 @Test// skip number of stores per query
    public void test003(){
     given()
             .log().all()
             .queryParam("$skip","10")
             .when()
             .get()
             .then().log().all().statusCode(200);
 }

}
