package crud.practice.program;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostComplexRequest_Vai_Json {
	
	@Test
	public void sampleTest() {
		
	File fis = new File("./sampleProject.json");
		
        given()
          .auth().basic("username", "password")
          .contentType(ContentType.JSON)
          .body(fis)
        .when()
          .post("http://localhost:8084/addProject")
        .then()
          .log().all()
          .assertThat().statusCode(201);
	}

}
