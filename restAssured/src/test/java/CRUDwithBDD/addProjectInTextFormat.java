package CRUDwithBDD;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;

public class addProjectInTextFormat {
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
		
		baseURI = "http://localhost";
		port = 8084;
		
		//pre-request for the script
		given()
			.body(jobj)
			.contentType(ContentType.TEXT)
			
		//Action
			.when()
				.post("/addProject")
				
		//validation
		.then()
			.assertThat().contentType(ContentType.JSON)
			.assertThat().statusCode(500)
			.assertThat().statusLine("HTTP/1.1 500 ")
			.log().all();
	}
}
