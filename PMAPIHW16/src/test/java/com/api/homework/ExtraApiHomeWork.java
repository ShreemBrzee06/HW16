package com.api.homework;

import com.api.bestbuytestbase.StoreTestBase;
import com.sun.xml.xsom.impl.scd.Iterators;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import jdk.nashorn.internal.objects.annotations.Where;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.sun.activation.registries.LogSupport.log;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class ExtraApiHomeWork extends StoreTestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    @Test//1. Verify the if the total is equal to 1561
    public void test002() {
        response.log().all().body("total", equalTo(1565));
    }

    @Test//2. Verify the if the stores of limit is equal to 10

    public void test003() {
        response.log().all().body("limit", equalTo(10));
    }

    @Test//3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
    public void test004() {
        response.body("data[1].name", containsString("Inver Grove Heights"));
    }

    @Test//Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    public void test005() {
        response.body("data.name", hasItems("Roseville", "Burnsville", "Maplewood"));
    }

    @Test//5. Verify the storied=7 inside storeservices of the third store of second services
    public void test006() {
        response.body("data[7].services[3].name", equalTo("Geek Services"));
    }

    @Test//6. Check hash map values ‘createdAt’ inside store services map where store name = Roseville

    public void test007() {
       /* HashMap<String,Object> map = given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .path("createdAt:", "2016-11-17T17:57:05.853Z");*/

        response.body("data[2].createdAt", containsString("2016-11-17T17:57:05.853Z"));

    }

    @Test//7.Verify the state = MN of forth store
    public void test008() {
        response.body("data[4].state", containsString("MN"));
    }

    @Test//8. Verify the store name = Rochester of 8th store
    public void test009() {
        response.body("data[8].name", containsString("Rochester"));
    }

    @Test//9. Verify the storeId = 11 for the 6th store
    public void test010() {
        response.body("data[5].id", equalTo(11));
    }

    @Test//10. Verify the serviceId = 4 for the 7th store of forth service
    public void test011() {
        response.body("data[6].services[3].id", equalTo(4));
    }

    @Test//1. Extract the limit
    public void test012() {
        response.extract().path("limit", "10");
    }

    @Test//2. Extract the total
    public void test013() {
        int total = response.extract().path("total");
        System.out.println("Total is " + total);
    }

    @Test//3. Extract the name of 5 th store
    public void test014() {

       String StoreNameOfTheFifthStore = response.extract().path("data[4].name");
        System.out.println(StoreNameOfTheFifthStore);
        /*String storeName = response.extract().path("data[4].name");
        System.out.println("Name of the fifthStore is " + storeName);*/
    }

    @Test//4. Extract the names of all the store
    public void test015() {
        ArrayList<String> nameOfAllStores = response.extract().path("data.name");
        System.out.println("Name of All the Stores: " + nameOfAllStores);
    }

    @Test//5. Extract the storeId of all the store
    public void test016() {
        ArrayList<String> idOfAllStores = response.extract().path("data.id");
        System.out.println("Name of All the Stores: " + idOfAllStores);
    }

    @Test//6. Print the size of the data list
    public void test017() {
        ArrayList<Object> sizeOfTheDataList = response.extract().path("data");
        System.out.println("Size of the data list = " + sizeOfTheDataList.size());
    }

    @Test//7. Get all the value of the store where store name = St Cloud
    public void test018() {
       HashMap<String , Object> valueOfAllTheStCloud = response.extract().path("data[6]");
        System.out.println("Value of Al the St. Cloud Store"+valueOfAllTheStCloud);
    }

    @Test//8. Get the address of the store where store name = Rochester
    public void test019() {
       String addressOfRochesterStore = response.extract().path("data[8].address");
        System.out.println("Address of the Rochester Store: "+ addressOfRochesterStore );
    }

    @Test//9. Get all the services of 8th store
    public void test020() {
       ArrayList<Object> allTheServicesFor8thStore = response.extract().path("data[8].services");
        System.out.println("All the Services for the 8th Store "+allTheServicesFor8thStore );
    }

    @Test//10. Get store services of the store where service name = Windows Store
    public void test021() {
       ArrayList <Object> storeServices = response.extract().path("data.services.flatten().findAll{it.name='Windows Store'}.storeservices");
        System.out.println("Store services for Windows Store: "+ storeServices);
    }

    @Test//11. Get all the storeId of all the store
    public void test022() {
       ArrayList<Object> allStoreId = response.extract().path("data.id");
        System.out.println("ID of All Stores: "+allStoreId);
    }

    @Test//12. Get id of all the store services
    public void test023() {
       ArrayList<String> idOfAlltheStoreServices = response.extract().path("data.services.id");
        System.out.println("ID of All the Store Services: "+ idOfAlltheStoreServices);
    }

    @Test//13. Find the store names Where state = ND
    public void test024() {
       ArrayList<String> nameOfTheStoreWhereStateIsND = response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("Name of the store where state is ND: "+nameOfTheStoreWhereStateIsND);
    }

    @Test//14. Find the Total number of services for the store where store name = Rochester
    public void test025() {
        ArrayList<String> totalNoOfServices = response.extract().path("data[8].services");
        System.out.println("Total No. of services: " + totalNoOfServices.size());
    }

    @Test//15. Find the createdAt for all services whose name = “Windows Store”
    public void test026() {
      /*ArrayList<String> allServicesWhoseNameIsWindowsStore =   response.extract().path("data.services.findAll{it.name =='Windows Store'}.createdAt");
        System.out.println(allServicesWhoseNameIsWindowsStore);*/

     ArrayList<String> allServicesCreatedAtWindowsStore=   response.extract().path("data.services.flatten().findAll{it.name=='Windows Store'}.createdAt");
        System.out.println("All services createdAt Window Store" +allServicesCreatedAtWindowsStore);
    }

    @Test//16. Find the name of all services Where store name = “Fargo”
    public void test027() {
       ArrayList<String> allServicesWhereTheStoreNameIsFargo= response.extract().path("data.findAll{it.name='Fargo'}.services.name");
        System.out.println("Find the name of all services Where store name is Fargo "+ allServicesWhereTheStoreNameIsFargo);
    }

    @Test//17. Find the zip of all the store
    public void test028() {
       ArrayList<String> zipOfAllTheStore= response.extract().path("data.zip");
        System.out.println("Zip of All the Store: "+zipOfAllTheStore);
    }

    @Test//18. Find the zip of store name = Roseville
    public void test029() {
       ArrayList<String> zipOfRosevilleStore = response.extract().path("data.findAll{it.name='Roseville'}.zip");
        System.out.println("Zip of Roseville store: "+zipOfRosevilleStore);
    }

    @Test//19. Find the store services details of the service name = Magnolia Home Theater
    public void test030() {
      ArrayList<String> allTheStoreServicesThatHasMagnoliaTheatre =  response.extract().path("data.services.flatten().findAll{it.name='Magnolia Home Theater'}.storeservices");
        System.out.println("Store services details of the service name is Magnolia Home Theater: "+allTheStoreServicesThatHasMagnoliaTheatre);
    }

    @Test//20. Find the lat of all the stores*/
    public void test031() {
       ArrayList<String> latOfAllTheStores = response.extract().path("data.lat");
        System.out.println("lat of the All the stores: " + latOfAllTheStores);


    }
}
