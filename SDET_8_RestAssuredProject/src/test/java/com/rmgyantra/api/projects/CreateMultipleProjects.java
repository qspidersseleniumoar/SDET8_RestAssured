package com.rmgyantra.api.projects;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.api.genericUtils.BaseApiClass;
import com.rmgyantra.api.genericUtils.EndPoints;
import com.rmgyantra.api.pojoclass.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateMultipleProjects  extends BaseApiClass{
	
    @Test(dataProvider =  "provideData")
    public void addMulipleProjects(String createdBy , String projectName , int size) {
    	Project projectObj = new Project(createdBy, projectName, "On Going", size);
    	Response resp = given()
				  .contentType(ContentType.JSON)
				  .body(projectObj)
			   .when()
			      .post(EndPoints.addPRojecttest);
				
			   resp.then()
			      .assertThat().statusCode(201)
			      .log().all();
    }
    
    @DataProvider
    public Object[][] provideData() {
    	Object[][] objArr = new Object[5][3];
    	 
    	objArr[0][0] = "deepak";
    	objArr[0][1] = "samsung";
    	objArr[0][2] = 10;
    	
    	objArr[1][0] = "deepak";
    	objArr[1][1] = "nokia";
    	objArr[1][2] = 10;
    	
    	objArr[2][0] = "deepak";
    	objArr[2][1] = "samsung";
    	objArr[2][2] = 10;
    	
    	objArr[3][0] = "deepak";
    	objArr[3][1] = "moto";
    	objArr[3][2] = 10;
    	
    	objArr[4][0] = "deepak";
    	objArr[4][1] = "1plus";
    	objArr[4][2] = 10;
		return objArr;
    	
    }

}






