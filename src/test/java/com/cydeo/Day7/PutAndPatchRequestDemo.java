package com.cydeo.Day7;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PutAndPatchRequestDemo extends SpartanTestBase {

    @DisplayName("PUT request to one spartan for update with Map")
    @Test
    public void PUTRequest(){
        //just like post request we have a different options to send body, we will go with map
        Map<String, Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("name", "BruceWayne");
        putRequestMap.put("gender", "Male");
        putRequestMap.put("phone", "8877441111L");

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(putRequestMap).log().body()
                .and().pathParam("id", 388)
                .when().put("/api/spartans/{id}")
                .then()
                .statusCode(204);

        //send a get request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send

    }

    @DisplayName("PATCH request to one spartan for update with Map")
    @Test
    public void PATCHRequest() {
        //just like post request we have a different options to send body, we will go with map
        Map<String, Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("phone", "8877441111L");

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(putRequestMap).log().body()
                .and().pathParam("id", 388)
                .when().patch("/api/spartans/{id}")
                .then()
                .statusCode(204);
    }

    @DisplayName("DELETE one spartan")
    @Test
    public void deleteSpartan(){
        int idTODelete=258;

        given().pathParam("id", idTODelete)
                .when().delete("/api/spartans/{id}")
                .then().statusCode(204);

    }




}