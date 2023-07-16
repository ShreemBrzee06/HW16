package com.api.studentinfo;

import com.api.bestbuytestbase.StudentTestBase;
import com.api.model.StudentPojo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends StudentTestBase {
    StudentPojo studentPojo = new StudentPojo();

    @Test//
    public void gettingStudentPojo(){
        given()
                .log().all()
                .pathParam("id","104")
                .when()
                .get("/{id}")
                .then().log().all().statusCode(200);
    }
}
