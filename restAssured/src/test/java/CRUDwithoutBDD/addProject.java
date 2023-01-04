package CRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class addProject {
	@Test
	public void addProject()
	{
		//create json body using json simple
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Rashmi");
		jobj.put("projectName", "LIMS");
		jobj.put("status", "completed");
		jobj.put("teamSize", 526);
		
		//pre-request for the script
		RequestSpecification reqSpec = RestAssured.given(); 
		reqSpec.body(jobj);
		reqSpec.contentType(ContentType.JSON);
		
		//Action
		Response response = reqSpec.post("http://localhost:8084/addProject");
		
		//validation
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.jsonPath());
		System.out.println(response.htmlPath());
		System.out.println(response.xmlPath());
		
		response.then().log().all();
		System.out.println(response.then().assertThat().contentType(ContentType.JSON));
		
		response.then().assertThat().statusCode(500);
		response.then().assertThat().statusLine("HTTP/1.1 500 ");
	}
}
