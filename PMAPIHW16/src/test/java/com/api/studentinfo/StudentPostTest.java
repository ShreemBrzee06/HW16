package com.api.studentinfo;

import com.api.bestbuytestbase.ServicesTestBase;
import com.api.bestbuytestbase.StudentTestBase;
import com.api.model.StudentPojo;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class StudentPostTest extends StudentTestBase {
    @Test// creating

    public void CreatingPostForStudent() {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Kartikeya");
        studentPojo.setLastName("Shiva");
        studentPojo.setEmail("kartikeya@gmail.com");
        studentPojo.setProgramme("Shiv Puran");
        ArrayList<String> programmes = new ArrayList<String>();
        programmes.add("Devi Puran");
        programmes.add("Bhagwat Puran");
        studentPojo.setCourses(programmes);
        given()
                .log().all()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(201);
    }

}