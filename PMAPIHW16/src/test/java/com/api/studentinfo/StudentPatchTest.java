package com.api.studentinfo;

import com.api.bestbuytestbase.StudentTestBase;
import com.api.model.StudentPojo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentPatchTest extends StudentTestBase {

    @Test
    public void PatchForStudent() {
        StudentPojo studentPojo = new StudentPojo();
            studentPojo.setFirstName("Krishna");
            studentPojo.setLastName("Govinda");
            studentPojo.setEmail("krishna@gmail.com");
            given()
                    .log().all()
                    .header("Content-Type", "application/json")
                    .pathParam("id","104")
                    .body(studentPojo)
                    .when()
                    .patch("/{id}")
                    .then().log().all().statusCode(200);

    }
}