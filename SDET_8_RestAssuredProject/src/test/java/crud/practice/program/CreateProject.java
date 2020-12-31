package crud.practice.program;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void getallProjectsTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Manoj");
		obj.put("projectName", "SCAnamiras");
		obj.put("status", "Completed");
		obj.put("teamSize", 12);
		
		 RequestSpecification reqs =   RestAssured.given();
		
		 reqs.contentType(ContentType.JSON);
		 reqs.body(obj);
		Response resp =  reqs.post("http://localhost:8084/addProject");
		
		System.out.println(resp.getStatusCode());
		
	}

}
