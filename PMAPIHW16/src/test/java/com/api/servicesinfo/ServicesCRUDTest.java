package com.api.servicesinfo;

import com.api.bestbuytestbase.ServicesTestBase;
import com.api.model.ServicesPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesCRUDTest extends ServicesTestBase {
    static int idNumber;
    @Test// get all services available
    public void test001(){
        given()
                .when()
                .get()
                .then().log().all().statusCode(200);
    }

    @Test// create one service post
    public void test002(){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Test Not Mobile");
       Response response= given()
                .log().all()
                .header("Content-Type","application/json")
               .body(servicesPojo)
                .when()
                .post();

                response.then().log().all().statusCode(201);
                idNumber = response.then().extract().path("id");
        System.out.println(idNumber);
    }

    @Test// update service using id
    public void test003(){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Aashirwaad services");
        given()
                .log().all()
                .pathParam("id",idNumber)
                .when()
                .patch("/{id}")
                .then().log().all().statusCode(200);
    }

    @Test// delete by using id
    public void test004(){
        given()
                .log().all()
                .pathParam("id",idNumber)
                .when()
                .delete("/{id}")
                .then().log().all().statusCode(200);

    }
}
