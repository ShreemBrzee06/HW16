package com.api.bestbuytestbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class ServicesTestBase {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";

    }
}
