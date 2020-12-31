package crud.practice.program;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Random;

import org.testng.annotations.Test;

import com.rmgyantra.api.pojoclass.Project;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;

public class PostComplexRequest_using_PojoClass {
	@Test
	public void sampleTest() {
		Random ram = new Random();
		int randomNum = ram.nextInt(1000);
		
     Project obj = new Project("Muni_"+randomNum, "Swagger", "Completed", 10);
		
        given()
          .contentType(ContentType.JSON)
          .body(obj, ObjectMapperType.JACKSON_1)
        .when()
          .post("http://localhost:8084/addProject")
        .then()
          .log().all()
          .assertThat().statusCode(201);
	}
}
