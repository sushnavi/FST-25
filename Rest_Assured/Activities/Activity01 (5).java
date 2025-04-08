package activities;
import static org.testng.Assert.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
	@Test(priority = 1)
	
	
	public void addNewPet() {
		//create request body
		
	   Map<String, Object> reqBody = new HashMap<>();
	   reqBody.put("id", 19242);
	   reqBody.put("name", "Tomy");
	   reqBody.put("status", "alive");
	   
	   //Send request, get response, assert response
	   given()
	   .baseUri("https://petstore.swagger.io/v2/pet")
		.header("Content-Type", "application/json")
		.body(reqBody)
		.when()
         .post()
	    .then()
	     .statusCode(200)
	     .body("name", equalTo("Tomy"))
	     .body("status", equalTo("alive"));
	     
	   }

	@Test(priority = 2)
	
	public void getPetInfo() {
		given()
		.baseUri("https://petstore.swagger.io/v2/pet")
		.header("Content-Type", "application/json")
		.pathParam("petId" , 19242)
		.log().all()
		.when()
		.get("/{petId}")
		.then()
		 .log().all()
		 .statusCode(200)
		 .body("name", equalTo("Tomy"))
	     .body("status", equalTo("alive"));
	     
	}

		 
	
	@Test(priority = 3)

	public void deletePet() {
		given()
		.baseUri("https://petstore.swagger.io/v2/pet")
		.header("Content-Type", "application/json")
		.pathParam("petId" , 19242)
		.log().all()
		.when()
		.delete("/{petId}")
		.then()
		 .log().all()
		 .statusCode(200)
		 .body("name", equalTo("Tomy"))
	     .body("status", equalTo("alive"));
		
	
		
		
	}

}