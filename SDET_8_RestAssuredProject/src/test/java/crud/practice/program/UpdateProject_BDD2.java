package crud.practice.program;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject_BDD2 {
	
	@Test
	public void getallProjectsTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Manoj2");
		obj.put("projectName", "SCAnamiras");
		obj.put("status", "Completed");
		obj.put("teamSize", 12);
		
        
		 given()
		   .contentType(ContentType.JSON)
		   .and()
		   .body(obj)
		 .when()
		    .post("http://localhost:8084/addProject")
		 .then()
		    .log().all()
		    .assertThat().statusCode(201);
	}

}
