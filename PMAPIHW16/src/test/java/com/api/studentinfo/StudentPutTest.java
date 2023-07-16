package com.api.studentinfo;

import com.api.bestbuytestbase.StudentTestBase;
import com.api.model.StudentPojo;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends StudentTestBase {
    @Test
    public void studentPutTest(){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("ganesha1@gamil.com");
        studentPojo.setFirstName("Kartikeya");
        studentPojo.setLastName("Shiva");
        studentPojo.setProgramme("Shiv Puran");
        ArrayList<String> programmes = new ArrayList<String>();
        programmes.add("Devi Puran");
        programmes.add("Bhagwat Puran");
        studentPojo.setCourses(programmes);
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id","101")
                .body(studentPojo)
                .when()
                .put("/{id}")
                .then().log().all().statusCode(200);
    }
}
