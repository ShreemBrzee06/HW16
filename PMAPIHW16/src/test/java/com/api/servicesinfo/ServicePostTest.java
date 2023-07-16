package com.api.servicesinfo;

import com.api.bestbuytestbase.ServicesTestBase;
import com.api.model.ServicesPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicePostTest extends ServicesTestBase {
    static int idNumber;
 @Test
    public void createPost(){

     ServicesPojo servicesPojo = new ServicesPojo();
     servicesPojo.setName("Janaki Mata");
    Response response= given()
             .log().all()
             .header("Content-Type","application/json")
             .body(servicesPojo)
             .when()
             .post();
    response.then().log().all().statusCode(201);
    idNumber = response.then().extract().path("id");
 }

}
