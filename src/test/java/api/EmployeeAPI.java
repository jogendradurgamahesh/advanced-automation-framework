package api;

import io.restassured.response.Response;


import io.restassured.RestAssured;

public class EmployeeAPI {
	
//	   public static Response validateApp() {
//	        return given()
//	                .baseUri("https://opensource-demo.orangehrmlive.com")
//	        .when()
//	                .get("/web/index.php/auth/login");  // GET request to login page
//	    }
	
	  public static Response validateApp() {
	        return RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");
	    }

}
