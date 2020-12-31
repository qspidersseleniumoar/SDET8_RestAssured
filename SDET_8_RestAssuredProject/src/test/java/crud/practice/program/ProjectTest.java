package crud.practice.program;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ProjectTest {
	
	@Test
	public void getallProjectsTest() {
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
		
		System.err.println(resp.getStatusCode());
		Assert.assertEquals(200, resp.getStatusCode());
		
		System.err.println(resp.getContentType());
		
		
	}

}
