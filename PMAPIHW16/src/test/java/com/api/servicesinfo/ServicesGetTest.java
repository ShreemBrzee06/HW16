package com.api.servicesinfo;

import com.api.bestbuytestbase.ServicesTestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesGetTest extends ServicesTestBase {
    @Test// get all services
    public void getAllServicesInfor(){
        given()
                .when()
                .get()
                .then().log().all().statusCode(200);
    }

    @Test// get it by single id
    public void getItById(){
        given()
                .log().all()
                .pathParam("id","3")
                .when()
                .get("/{id}")
                .then().log().body().statusCode(200);
    }

    @Test// limit for services
    public void getItByServices(){
        given()
                .log().all()
                .queryParam("$limit","10")
                .when()
                .get()
                .then().log().all().statusCode(200);

    }

    @Test// skip for services
    public void skipForServices(){
        given()
                .log().all()
                .queryParam("$skip","10")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
}
