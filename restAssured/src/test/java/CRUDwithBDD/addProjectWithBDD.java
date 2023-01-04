package CRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class addProjectWithBDD {

	@Test
	public void addProject()
	{
		//create json body using json simple
		JavaUtility jLib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Rashmi");
		jobj.put("projectName", "LIMS"+jLib.getRandomNumber());
		jobj.put("status", "created");
		jobj.put("teamSize", 5);
		
		//pre-request for the script
		 RequestSpecification reqSpec = given();
		 reqSpec.body(jobj);
		 reqSpec.contentType(ContentType.JSON);
		 
		 //ACTION
		Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_804");
		
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
		response.then().assertThat().statusCode(200);
		response.then().assertThat().statusLine("HTTP/1.1 200 ");
	}	
}
