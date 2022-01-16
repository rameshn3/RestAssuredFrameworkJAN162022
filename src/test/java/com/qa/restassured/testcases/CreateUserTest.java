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

public class CreateUserTest extends TestBase{
  
  @BeforeClass
  public void setUp() throws IOException {
	  
	  RestAssured.baseURI=readPropertyValue("baseUrl");
	  
  }
  
  
  
  @Test
  public void createUsersTest() throws IOException {
	  
	 /*step1. create a Request using RestAssured given() which returns RequestSpecification object
	  * How to call return type static methods
	  * datatype variable=classname.returnstaticmethod();
	  */
	  System.out.println("Started executing the createUsersTest()..............");
	 RequestSpecification req= RestAssured.given();
	 
	 //step2 - add the headers to request
	 req.header("Content-Type", "application/json");
	 req.header("Accept","application/json");
	 
	 //step 3- Add the request body to the request 
	 JSONObject jsonObj=new JSONObject();
	 jsonObj.put("name", "CH Ramesh");
	 jsonObj.put("job", "AutomationTestLead");
	 //attach the map to request
	 req.body(jsonObj.toString());
	
	 //step 4- send the request and store the Response in response Object
	 Response respObj=req.request(Method.POST, "");
	 //step 4 - print the Response output to the console
	 System.out.println("Create User Response output is:"+respObj.asString()); 
	 //validate the status code- 201 code
	 int respStatusCode=respObj.getStatusCode();
	 System.out.println("Get All Users request response code is:"+respStatusCode);
	 Assert.assertEquals(respStatusCode, 201);
	 //fetch the status message line
	 String statusLine=respObj.getStatusLine();
	 System.out.println("rsponse status line is:"+statusLine);
	 Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
	 //fetch the respobody parameter values
	  String nameValue=respObj.jsonPath().get("name");
	 System.out.println("response body parameter name value is:"+nameValue);
	 Assert.assertEquals(nameValue, "CH Ramesh");
	 String jobValue=respObj.jsonPath().get("job");
	 System.out.println("response body job value is:"+jobValue);
	 
	 //id value 
	 String idValue=respObj.jsonPath().get("id");
	 System.out.println("response body id value is:"+idValue);
	 
	 //createdAt
		 String createdAtValue=respObj.jsonPath().get("CreatedAt");
		 System.out.println("response body createdAt value is:"+createdAtValue);
	 
	 
	 System.out.println("Ended executing the createUsersTest()..............");
  }
  
  
  @Test
  public void createUser400BadReqestTest() throws IOException {
	  
	 /*step1. create a Request using RestAssured given() which returns RequestSpecification object
	  * How to call return type static methods
	  * datatype variable=classname.returnstaticmethod();
	  */
	  System.out.println("Started executing the createUser400BadReqestTest()..............");
	 RequestSpecification req= RestAssured.given();
	 
	 //step2 - add the headers to request
	 req.header("Content-Type", "application/json");
	 req.header("Accept","application/json");
	 
	/* //step 3- Add the request body to the request 
	 JSONObject jsonObj=new JSONObject();
	 jsonObj.put("name", "CH Ramesh");
	 jsonObj.put("job", "AutomationTestLead");
	 //attach the map to request
	 req.body(jsonObj.toString());*/
	 String reqbody="{\n" + 
	 		"    \"name\": \"Ch Ramesh\n" + 
	 		"    \"job\": \"AutomationTestlead\"\n" + 
	 		"}";
	 req.body(reqbody);
	 //step 4- send the request and store the Response in response Object
	 Response respObj=req.request(Method.POST, "");
	 //step 4 - print the Response output to the console
	 System.out.println("Create User Response output is:"+respObj.asString()); 
	 //validate the status code- 201 code
	 int respStatusCode=respObj.getStatusCode();
	 System.out.println("Get All Users request response code is:"+respStatusCode);
	 Assert.assertEquals(respStatusCode, 400);
	 //fetch the status message line
	 String statusLine=respObj.getStatusLine();
	 System.out.println("rsponse status line is:"+statusLine);
	 Assert.assertEquals(statusLine, "HTTP/1.1 400 Bad Request");
	
	 
	 System.out.println("Ended executing the createUser400BadReqestTest()..............");
  }
  
  
  
  
}
