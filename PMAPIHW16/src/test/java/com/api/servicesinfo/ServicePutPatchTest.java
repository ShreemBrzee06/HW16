package com.api.servicesinfo;

import com.api.bestbuytestbase.ServicesTestBase;
import com.api.model.ServicesPojo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicePutPatchTest extends ServicesTestBase {
    @Test
    public void putTestForServices(){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Ganesha Shiva");
        given()
                .log().all()
                .pathParam("id","22")
                .when()
                .patch("/{id}")
                .then().log().all().statusCode(200);
    }
}
