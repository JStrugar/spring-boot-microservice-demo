package com.example.demo.apitest;

import com.example.demo.DemoApplication;

import org.json.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;

public class DataRequestTest {

    @Test
    @Tag("ApiTest")
    public void AddLeftDataPost() {
        JSONObject requestParams = new JSONObject();
        try {
            requestParams.put("data", "cXdlcXdl");
        }catch (JSONException e) {
            Assertions.fail("Something went wrong with creating json body");
        }
        given().port(8081)
                .contentType("application/json\r\n")
                .body(requestParams.toString())
                .when()
                .post("/v1/diff/1/left")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
