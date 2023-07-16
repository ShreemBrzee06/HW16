package test.java.com.api.bestbuytestbase;


import org.junit.BeforeClass;

public class StudentTestBase {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";

    }
}
