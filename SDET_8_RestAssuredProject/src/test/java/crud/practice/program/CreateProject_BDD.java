package crud.practice.program;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject_BDD {
	
	@Test
	public void getallProjectsTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Manoj3");
		obj.put("projectName", "SCAnamiras");
		obj.put("status", "On Going");
		obj.put("teamSize", 12);
		
        given()
          .contentType(ContentType.JSON)
          .body(obj)
        .when()
          .put("http://localhost:8084/projects/TY_PROJ_1603")
        .then()
          .log().all()
          .assertThat().statusCode(200);
		 
	}

}



