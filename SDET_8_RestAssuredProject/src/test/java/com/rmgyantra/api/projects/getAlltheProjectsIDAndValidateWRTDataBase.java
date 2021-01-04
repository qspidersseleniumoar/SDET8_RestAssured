package com.rmgyantra.api.projects;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rmgyantra.api.genericUtils.BaseApiClass;
import com.rmgyantra.api.genericUtils.DataBaseUtilities;
import com.rmgyantra.api.genericUtils.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;


public class getAlltheProjectsIDAndValidateWRTDataBase extends BaseApiClass{
	SoftAssert soft = new SoftAssert();
	@Test
	public void getAllProjectsAndValidteWRTdataBase() throws Throwable {
		
	Response resp = 	given()
						  .contentType(ContentType.JSON)
						.when()
						  .get(EndPoints.getProjects);
	
	  List<String> lst = resp.jsonPath().get("projectId");
	  
        for(String projectIds : lst) {       	
        	boolean status = DataBaseUtilities.verifyexpectedDatainTable("select * from project", 1, projectIds);
        	soft.assertTrue(status);
        }
		
        soft.assertAll();
	}
}



