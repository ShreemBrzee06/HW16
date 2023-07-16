package com.api.studentinfo;

import com.api.bestbuytestbase.StudentTestBase;
import com.api.model.StudentPojo;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;

public class StudentCRUDTest extends StudentTestBase {

    static int idNumber;
    @Test// get all students list
    public void test001(){
        given()
                .when()
                .get("/list")
                .then().log().all().statusCode(200);
    }

    @Test // get single student details
    public void test002(){
        Response response = given()
                .log().all()
                .pathParam("id","55")
                .when()
                .get("/{id}");
               response .then().log().all().statusCode(200);
    }
    /*"firstName": "Driscoll",
    "lastName": "Russell",
    "email": "Lorem.ipsum.dolor@eu.co.uk",
    "programme": "Computer Science",
    "courses": [
        "Calculus",
        "Algorithms",
        "Software Development",
        "Ethics"*/
    @Test// create a post for student
    public void test003(){


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Ganesha");
        studentPojo.setLastName("Shiva");
        studentPojo.setEmail("ganesha32@gmail.com");
        ArrayList<String> programmes = new ArrayList<String>();
        programmes.add("Rig Veda");
        programmes.add("Atharva Veda");
        programmes.add("Yajur Veda");
        programmes.add("Sama Veda");
        studentPojo.setProgramme("Indian Culture");

        studentPojo.setCourses(programmes);

       Response response= given()
                .log().all()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .when()
                .post();
               response .then().log().all().statusCode(201);


    }

    @Test// retrieve new data posted student info
    public void test004(){
        HashMap<String ,Object> studentMap = given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .extract()
                .path("findAll{it.firstName == 'Ganesha'}.get(0)");
        idNumber = (int)studentMap.get("id");
        System.out.println(idNumber);
    }
    @Test// update data with id
    public void test005(){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Ganesha");
        studentPojo.setLastName("Shiva");
        studentPojo.setEmail("ganesha33@gmail.com");

        given()
                .header("Content-Type", "application/json")
                .pathParam("id",idNumber)
                .body(studentPojo)
                .when()
                .patch("/{id}")
                .then().log().all()
                .statusCode(200);
    }

    @Test// delete created student
    public void test006(){
        given()
                .pathParam("id",idNumber)
                .when()
                .delete("/{id}")
                .then().log().all()
                .statusCode(204);
    }

    @Test//get deleted id
    public void test007(){
        given()
                .log().all()
                .pathParam("id",idNumber)
                .when()
                .get("/{id}")
                .then()
                .log().all()
                .statusCode(404);
    }
}
