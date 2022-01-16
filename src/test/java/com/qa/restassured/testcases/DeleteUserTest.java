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

public class DeleteUserTest extends TestBase{
  
  @BeforeClass
  public void setUp() throws IOException {
	  
	  RestAssured.baseURI=readPropertyValue("baseUrl");
	  
  }
 
  @Test
  public void deleteUserTest() throws IOException {
	  
	 /*step1. create a Request using RestAssured given() which returns RequestSpecification object
	  * How to call return type static methods
	  * datatype variable=classname.returnstaticmethod();
	  */
	  System.out.println("Started executing the deleteUserTest()..............");
	 RequestSpecification req= RestAssured.given();
	 
	 //step2 - add the headers to request
	 req.header("Content-Type", "application/json");
	 req.header("Accept","application/json");
	 
	
	 //step 3- send the request and store the Response in response Object
	 Response respObj=req.request(Method.DELETE,  readPropertyValue("deleteUserEndPoint"));
	 //step 4 - print the Response output to the console
	 System.out.println("Create User Response output is:"+respObj.asString()); 
	 //validate the status code- 204 code
	 int respStatusCode=respObj.getStatusCode();
	 System.out.println("Get All Users request response code is:"+respStatusCode);
	 Assert.assertEquals(respStatusCode, 204);
	 //fetch the status message line
	 String statusLine=respObj.getStatusLine();
	 System.out.println("rsponse status line is:"+statusLine);
	 Assert.assertEquals(statusLine, "HTTP/1.1 204 No Content");
	 
	 
	 System.out.println("Ended executing the deleteUserTest()..............");
  }
  
  
  
}
