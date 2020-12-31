package crud.practice.program;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProject {

	
	@Test
	public void deleteProject() {
		
		when()
		  .delete("http://localhost:8084/projects/TY_PROJ_1602")
		.then()
		  .log().all()
		  .assertThat().statusCode(204);
		
	}
}
