package crud.practice.program;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProjectTest_BDD {
	
	@Test
	public void getallProjectsTest() {
	
		when()
		  .get("http://localhost:8084/projects")
		.then()
		  .assertThat().statusCode(200)
		  .assertThat().contentType(ContentType.JSON)
		  .log().all();
	
	
		
		
	}

}
