
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

public class Activity2 {
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
	
	public void getUserInfo() {
		//Import JSON file to write to
		File outputJSON = new File("src/test/java/activities/userGETResponse.json");
		
		Response response = given()
		.baseUri("https://petstore.swagger.io/v2/user") //set base URI
		.header("Content-Type", "application/json") //set Headers
		.pathParam("username" , "justinc") //pass request body from file
		
		.when().get("/{username}");//Send POST Request
		
		//Get Response body
		String resBody = response.getBody().asPrettyString();
		
		try {
			//Create JSON File
			outputJSON.createNewFile();
			//Write response body to external file
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		}catch (IOException excp) {
			excp.printStackTrace();
		}
		//Assertion
		response.then().body("id", equalTo(9901));
		response.then().body("username", equalTo("justinc"));
		response.then().body("firstName", equalTo("justin"));
	    response.then().body("lastName", equalTo("Case"));
	    response.then().body("email", equalTo("justincase@mail.com"));
	    
	    
				
			
		
		
		
		
		
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

	

