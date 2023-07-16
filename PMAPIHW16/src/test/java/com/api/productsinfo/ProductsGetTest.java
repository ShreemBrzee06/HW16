package com.api.productsinfo;

import com.api.bestbuytestbase.TestBase;
import io.restassured.response.Response;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsGetTest extends TestBase {

    @Test// get all products
    public void test001(){
       Response response= given()
                .when()
                .get();
       response.then().statusCode(200);


    }
    @Test// get data using query parameter $limit

    public void test002(){
        given()
                .log().all()
                .queryParam("$limit","2")
                .when()
                .get()
            .then().log().all().statusCode(200);

    }

    @Test// skip 25000 products
     public void test003(){
        given()
                .log().all()
                .queryParam("$skip","25000")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
    @Test//get all products, sort by highest price(descending)
    public void test004(){
        given()
                .log().all()
                .queryParam("$sort[price]","-1")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
    @Test// get all products, sort by lowest price(ascending)
           public void test005() {
        given()
                .log().all()
                .queryParam("$sort[price]","1")
                .when()
                .get()
                .then().log().all().statusCode(200);

    }
    @Test// get all products, but only show the name and price in the result
    public void test006(){
        given()
                .log().body()
                .queryParam("$select[]","name")
                .queryParam("$select[]","price")
                .when()
                .get()
                .then().log().all().statusCode(200);

    }

    @Test// get products of type HardGood
    public void test007(){
        given()
                .log().all()
                .queryParam("type","HardGood")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
    @Test//get products less than or equal to $1
    public void test008(){
        given()
                .log().all()
                .queryParam("price[$lte]","1")
                .when()
                .get()
                .then().log().all().statusCode(200);

    }
    @Test
// get products that have 'star wars' in the name and are under$30
    public void test009(){
        given()
                .log().all()
                .queryParam("name[$like]","*star+wars*")
                .queryParam("price[$lt]","30")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
@Test// get products that are either $0.99 or$1.99
    public void test010(){
        given()
                .log().all()
                .queryParam("price[$in]","0.99")
                .queryParam("price[$in]","1.99")
                .when()
                .get()
                .then().log().all().statusCode(200);
}

@Test // get products that have a shipping price of more than $10
    public void test011(){
        given()
                .log().all()
                .queryParam("shipping[$gt]","10")
                .when()
                .get()
                .then().log().all().statusCode(200);
}

@Test// get products that are not HardGood or Software
    public void test012(){
        given()
                .log().all()
                .queryParam("type[$nin][]","HardGood")
                .queryParam("type[$nin][]","Software")
                .when()
                .get()
                .then().log().all().statusCode(200);
}
@Test// get products that are in category name"Coffee Pods"
    public void test013(){
        given()
                .log().all()
                .queryParam("category.name","Coffee Pods")
                .when()
                .get()
                .then().log().all().statusCode(200);
}

@Test// GET PRODUCTS THAT ARE IN CATEGORY ID "abcat0106004" (TV Mounts)
    public void test014(){
        given()
                .log().all()
                .queryParam("category.id","abcat0106004")
                .when()
                .get()
                .then().log().all().statusCode(200);
}
}
