package com.qa.restassured.testcases;

import org.testng.annotations.Test;

import com.qa.restassured.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class UpdateUserTest extends TestBase{
  
  @BeforeClass
  public void setUp() throws IOException {
	  
	  RestAssured.baseURI=readPropertyValue("baseUrl");
	  
  }
  
  
  
  @Test
  public void updateUserTest() throws IOException {
	  
	 /*step1. create a Request using RestAssured given() which returns RequestSpecification object
	  * How to call return type static methods
	  * datatype variable=classname.returnstaticmethod();
	  */
	  System.out.println("Started executing the updateUserTest()..............");
	 RequestSpecification req= RestAssured.given();
	 
	 //step2 - add the headers to request
	 req.header("Content-Type", "application/json");
	 req.header("Accept","application/json");
	 
	 //step 3- Add the request body to the request 
	 JSONObject jsonObj=new JSONObject();
	 jsonObj.put("name", "morpheus");
	 jsonObj.put("job", "zion resident");
	 //attach the map to request
	 req.body(jsonObj.toString());
	
	 //step 4- send the request and store the Response in response Object
	 Response respObj=req.request(Method.PUT,  readPropertyValue("updateUserEndPoint"));
	 //step 4 - print the Response output to the console
	 System.out.println("Create User Response output is:"+respObj.asString()); 
	 //validate the status code- 201 code
	 int respStatusCode=respObj.getStatusCode();
	 System.out.println("Get All Users request response code is:"+respStatusCode);
	 Assert.assertEquals(respStatusCode, 200);
	 //fetch the status message line
	 String statusLine=respObj.getStatusLine();
	 System.out.println("rsponse status line is:"+statusLine);
	 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	 //fetch the respobody parameter values
	  String nameValue=respObj.jsonPath().get("name");
	 System.out.println("response body parameter name value is:"+nameValue);
	 Assert.assertEquals(nameValue, "morpheus");
	 String jobValue=respObj.jsonPath().get("job");
	 System.out.println("response body job value is:"+jobValue);
	 
	 //id value 
	 String idValue=respObj.jsonPath().get("id");
	 System.out.println("response body id value is:"+idValue);
	 
	 //updatedAtValue
		 String updatedAtValue=respObj.jsonPath().get("updatedAt");
		 System.out.println("response body createdAt value is:"+updatedAtValue);
	 
	 
	 System.out.println("Ended executing the updateUserTest()..............");
  }
  
  
  @Test
  public void updateUserWithPatchTest() throws IOException {
	  
	 /*step1. create a Request using RestAssured given() which returns RequestSpecification object
	  * How to call return type static methods
	  * datatype variable=classname.returnstaticmethod();
	  */
	  System.out.println("Started executing the updateUserWithPatchTest()..............");
	 RequestSpecification req= RestAssured.given();
	 
	 //step2 - add the headers to request
	 req.header("Content-Type", "application/json");
	 req.header("Accept","application/json");
	 
	 //step 3- Add the request body to the request 
	 JSONObject jsonObj=new JSONObject();
	 jsonObj.put("name", "morpheus");
	 jsonObj.put("job", "Software Test Engineer");
	 //attach the map to request
	 req.body(jsonObj.toString());
	
	 //step 4- send the request and store the Response in response Object
	 Response respObj=req.request(Method.PATCH,  readPropertyValue("patchUserEndPoint"));
	 //step 4 - print the Response output to the console
	 System.out.println("Create User Response output is:"+respObj.asString()); 
	 //validate the status code- 201 code
	 int respStatusCode=respObj.getStatusCode();
	 System.out.println("Get All Users request response code is:"+respStatusCode);
	 Assert.assertEquals(respStatusCode, 200);
	 //fetch the status message line
	 String statusLine=respObj.getStatusLine();
	 System.out.println("rsponse status line is:"+statusLine);
	 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	 //fetch the respobody parameter values
	  String nameValue=respObj.jsonPath().get("name");
	 System.out.println("response body parameter name value is:"+nameValue);
	 Assert.assertEquals(nameValue, "morpheus");
	 String jobValue=respObj.jsonPath().get("job");
	 System.out.println("response body job value is:"+jobValue);
	 
	 //id value 
	 String idValue=respObj.jsonPath().get("id");
	 System.out.println("response body id value is:"+idValue);
	 
	 //updatedAtValue
		 String updatedAtValue=respObj.jsonPath().get("updatedAt");
		 System.out.println("response body createdAt value is:"+updatedAtValue);
	 
	 
	 System.out.println("Ended executing the updateUserWithPatchTest()..............");
  }
  
  
  
}
