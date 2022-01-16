package com.qa.restassured.testcases;

import org.testng.annotations.Test;

import com.qa.restassured.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class GetUsersTest extends TestBase{
  
  @BeforeClass
  public void setUp() throws IOException {
	  
	  RestAssured.baseURI=readPropertyValue("baseUrl");
	  
  }
  
  
  
  @Test
  public void getAllUsersTest() throws IOException {
	  
	 /*step1. create a Request using RestAssured given() which returns RequestSpecification object
	  * How to call return type static methods
	  * datatype variable=classname.returnstaticmethod();
	  */
	  System.out.println("Started executing the getAllUsersTest()..............");
	 RequestSpecification req= RestAssured.given();
	 
	 //step2 - add the headers to request
	 req.header("Content-Type", "application/json");
	 req.header("Accept","application/json");
	 //step 3- send the request and store the Response in response Object
	 Response respObj=req.request(Method.GET, readPropertyValue("getAllUsersEndPoint"));
	 //step 4 - print the Response output to the console
	 System.out.println("Response output is:"+respObj.asString()); 
	 //validate the status code- 200 code
	 int respStatusCode=respObj.getStatusCode();
	 System.out.println("Get All Users request response code is:"+respStatusCode);
	 Assert.assertEquals(respStatusCode, 200);
	 //fetch the status message line
	 String statusLine=respObj.getStatusLine();
	 System.out.println("rsponse status line is:"+statusLine);
	 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	 //fetch the respobody parameter values
	 Integer totalValue=respObj.jsonPath().get("total");
	 System.out.println("response body parameter total value is:"+totalValue);
	// Assert.assertEquals(totalValue.toString(), String.valueOf(12));
	 Integer perPageValue=respObj.jsonPath().get("per_page");
	 System.out.println("response body per_page value is:"+perPageValue);
	 //fetch array first element value
	 String emailVal=respObj.jsonPath().get("data[0].email");
	 System.out.println("data email value is:"+emailVal);
	 System.out.println("Ended executing the getAllUsersTest()..............");
  }
  
  @Test
  public void getSingleUserTest() throws IOException {
	  
	 /*step1. create a Request using RestAssured given() which returns RequestSpecification object
	  * How to call return type static methods
	  * datatype variable=classname.returnstaticmethod();
	  */
	 System.out.println("Started executing the getSingleUserTest()..............");
	 RequestSpecification req= RestAssured.given();
	 
	 //step2 - add the headers to request
	 req.header("Content-Type", "application/json");
	 req.header("Accept","application/json");
	 //step 3- send the request and store the Response in response Object
	 Response respObj=req.request(Method.GET, readPropertyValue("getSingleUserEndPoint"));
	 //step 4 - print the Response output to the console
	 System.out.println("Response output is:"+respObj.asString()); 
	 //validate the status code- 200 code
	 int respStatusCode=respObj.getStatusCode();
	 System.out.println("Get All Users request response code is:"+respStatusCode);
	 Assert.assertEquals(respStatusCode, 200);
	 //fetch the status message line
	 String statusLine=respObj.getStatusLine();
	 System.out.println("rsponse status line is:"+statusLine);
	 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	 System.out.println("Ended executing the getSingleUserTest()..............");
  }
  
  
  @Test
  public void getSingleUserNotFoundTest() throws IOException {
	  
	 /*step1. create a Request using RestAssured given() which returns RequestSpecification object
	  * How to call return type static methods
	  * datatype variable=classname.returnstaticmethod();
	  */
	 System.out.println("Started executing the getSingleUserNotFoundTest()..............");
	 RequestSpecification req= RestAssured.given();
	 
	 //step2 - add the headers to request
	 req.header("Content-Type", "application/json");
	 req.header("Accept","application/json");
	 //step 3- send the request and store the Response in response Object
	 Response respObj=req.request(Method.GET, readPropertyValue("singleUserNotFoundEndPoint"));
	 //step 4 - print the Response output to the console
	 System.out.println("Response output is:"+respObj.asString()); 
	 //validate the status code- 404 code
	 int respStatusCode=respObj.getStatusCode();
	 System.out.println("Get All Users request response code is:"+respStatusCode);
	 Assert.assertEquals(respStatusCode, 404);
	 //fetch the status message line
	 String statusLine=respObj.getStatusLine();
	 System.out.println("rsponse status line is:"+statusLine);
	 Assert.assertEquals(statusLine, "HTTP/1.1 404 Not Found");
	 System.out.println("Ended executing the getSingleUserNotFoundTest()..............");
  }
  
}
